package com.example.cowmanager.service;

import com.example.cowmanager.entity.*;
import com.example.cowmanager.model.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {

    protected EmployeeEntity toEmployeeEntity(EmployeeRequest request) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setBoPhan(request.getBoPhan());
        entity.setDiaChi(request.getDiaChi());
        entity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        entity.setSoDt(request.getSoDt());
        entity.setTen(request.getTenNv());
        return entity;
    }

    protected Employee toEmployeeWithoutCowEntity(EmployeeEntity entity) throws CowManagerException {
        try {
            Employee result = new Employee();
            result.setMaNv(entity.getMaNv());
            result.setChucDanh(toRole(entity.getQuyen()));
            result.setNgaySinh(entity.getNgaySinh());
            result.setSoDt(entity.getSoDt());
            result.setTenNv(entity.getTen());
            return result;
        } catch (Exception ex) {
            throw new CowManagerException("Vui long khoi tao bang quyen (role)");
        }
    }

    protected Employee toEmployee(EmployeeEntity entity) throws CowManagerException {
        try {
            Employee result = new Employee();
            result.setMaNv(entity.getMaNv());
            result.setChucDanh(toRole(entity.getQuyen()));
            result.setNgaySinh(entity.getNgaySinh());
            result.setSoDt(entity.getSoDt());
            result.setTenNv(entity.getTen());
            result.setDanhSachBo(convertToListCow(entity.getDanhSachBo()));
            return result;
        } catch (Exception ex) {
            throw new CowManagerException("Vui long khoi tao bang quyen (role)");
        }
    }

    protected Cage toCage(CageEntity entity) {
        Cage cage = new Cage();
        cage.setDanhSachBo(convertToListCow(entity.getDanhSachBo()));
        cage.setGioiHan(entity.getGioiHan());
        cage.setLichDon(convertToCalendarCleaning(entity.getLichDon()));
        cage.setMaChuong(entity.getMaChuong());
        cage.setNgayCapNhat(entity.getNgayCapNhat());
        cage.setNgayTao(entity.getNgayTao());
        cage.setTrangThai(entity.getTrangThai());
        cage.setViTri(entity.getViTri());
        return cage;
    }

    protected Cage toCage2(CageEntity entity) {
        Cage cage = new Cage();
//        cage.setDanhSachBo(convertToListCow(entity.getDanhSachBo()));
        cage.setGioiHan(entity.getGioiHan());
        cage.setLichDon(convertToCalendarCleaning(entity.getLichDon()));
        cage.setMaChuong(entity.getMaChuong());
        cage.setNgayCapNhat(entity.getNgayCapNhat());
        cage.setNgayTao(entity.getNgayTao());
        cage.setTrangThai(entity.getTrangThai());
        cage.setViTri(entity.getViTri());
        return cage;
    }

    protected List<CageLog> convertToCalendarCleaning(List<CageLogEntity> entities) {
        if (entities == null) {
            return null;
        }
        List<CageLog> result = new ArrayList<>();
        for (CageLogEntity entity : entities) {
            CageLog log = toCageLog(entity);
            result.add(log);
        }
        return result;
    }

    protected CageLog toCageLog(CageLogEntity entity) {
        CageLog data = new CageLog();
        data.setChuong(toCage(entity.getChuong()));
        data.setNgayDon(entity.getNgayDon());
        return data;
    }

    protected Cow toCow(CowEntity entity) {
        Cow cow = new Cow();
        cow.setBenhTat(entity.getBenhTat());
        if (entity.getChuong() != null) {
            cow.setChuong(toCage(entity.getChuong()));
        }
        cow.setDacDiem(entity.getDacDiem());
        if (entity.getTheoDoiSucKhoe() != null) {
            cow.setLichChamSocSucKhoe(convertToListCowLog(entity.getTheoDoiSucKhoe()));
        }
        if (entity.getLichVatSua() != null ) {
            cow.setLichVatSua(convertToListMilk(entity.getLichVatSua()));
        }
        cow.setMaBo(entity.getMaBo());
        cow.setNgayNhap(entity.getNgayNhap());
        if (entity.getNhanVien() != null) {
            try {
                cow.setNhanVien(toEmployee(entity.getNhanVien()));
            } catch (CowManagerException e) {
                e.printStackTrace();
            }
        }
        if (entity.getChuong() != null) {
            cow.setChuong(toCage(entity.getChuong()));
        }
        return cow;
    }

    protected RoleEmployee toRole(RoleEmployeeEntity entity) {
        RoleEmployee role = new RoleEmployee();
        role.setId(entity.getId());
        role.setDescription(entity.getDescription());
        return role;
    }

    protected DeviceEntity toDeviceEntity(DeviceRequest request) {
        DeviceEntity entity = new DeviceEntity();
        entity.setMaTb(request.getMaTb());
        entity.setMoTa(request.getMoTa());
        entity.setNhaCungCap(request.getNhaCungCap());
        entity.setTenTb(request.getTenTb());
        entity.setTinhTrang(request.getTinhTrang());
        return entity;
    }

    protected CageEntity toCageEntity(CageRequest request) {
        CageEntity entity = new CageEntity();
        entity.setGioiHan(request.getGioiHan());
        entity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        entity.setViTri(request.getViTri());
        return entity;
    }

    protected Device toDevice(DeviceEntity entity) {
        Device device = new Device();
        device.setMaTb(entity.getMaTb());
        device.setMoTa(entity.getMoTa());
        device.setNgayNhap(entity.getNgayNhap());
        device.setNgayTao(entity.getNgayTao());
        device.setNhaCungCap(entity.getNhaCungCap());
        device.setTenTb(entity.getTenTb());
        device.setTinhTrang(entity.getTinhTrang());
        return device;
    }

    protected List<Device> convertToListDevice(List<DeviceEntity> entities) {
        List<Device> result = new ArrayList<>();
        for (DeviceEntity entity : entities) {
            Device device = toDevice(entity);
            result.add(device);
        }
        return result;
    }

    protected List<Cow> convertToListCow(List<CowEntity> entities) {
        if (entities == null) {
            return null;
        }
        List<Cow> listCow = new ArrayList<>();
        for (CowEntity entity : entities) {
            Cow cow = toCow2(entity);
            listCow.add(cow);
        }
        return listCow;
    }


    protected CowEntity toCowEntity(CowRequest request) {
        CowEntity entity = new CowEntity();
        entity.setNgayNhap(request.getNgayNhap());
        entity.setBenhTat(request.getBenhTat());
        entity.setDacDiem(request.getDacDiem());
        return entity;
    }

    protected CowLog toCowLog(CowLogEntity entity) {
        CowLog cowLog = new CowLog();
        cowLog.setBo(toCow2(entity.getBo()));
        cowLog.setCanNang(entity.getCanNang());
        cowLog.setChatBeo(entity.getChatBeo());
        cowLog.setNgayCapNhat(entity.getNgayCapNhat());
        cowLog.setNgayTao(entity.getNgayTao());
        cowLog.setNhietDo(entity.getNhietDo());
        cowLog.setProtit(entity.getProtit());
        cowLog.setTinhTrang(entity.getTinhTrang());
        return cowLog;
    }

    protected MilkGetting toMilkGetting(MilkGettingEntity entity) {
        MilkGetting result = new MilkGetting();
        result.setBo(toCow2(entity.getBo()));
        result.setNangSuat(entity.getNangSuat());
        result.setNgayNhap(entity.getNgayNhap());
        result.setNgayTao(entity.getNgayTao());
        result.setNgayVatSua(entity.getNgayVatSua());
        return result;
    }

    protected Cow toCow2(CowEntity entity) {
        Cow cow = new Cow();
        cow.setBenhTat(entity.getBenhTat());
        if (entity.getChuong() != null) {
            cow.setChuong(toCage2(entity.getChuong()));
        }
        cow.setDacDiem(entity.getDacDiem());
        cow.setMaBo(entity.getMaBo());
        cow.setNgayNhap(entity.getNgayNhap());
        return cow;
    }

    protected List<MilkGetting> convertToListMilk(List<MilkGettingEntity> entities) {
        if (entities == null) {
            return null;
        }
        List<MilkGetting> result = new ArrayList<>();
        for (MilkGettingEntity entity : entities) {
            MilkGetting item = toMilkGetting(entity);
            result.add(item);
        }
        return result;
    }

    protected List<CowLog> convertToListCowLog(List<CowLogEntity> entities) {
        if (entities == null) {
            return null;
        }
        List<CowLog> result = new ArrayList<>();
        for (CowLogEntity entity : entities) {
            CowLog cowLog = toCowLog(entity);
            result.add(cowLog);
        }
        return result;
    }

    protected List<RoleEmployee> convertToListRole(List<RoleEmployeeEntity> entities) {
        List<RoleEmployee> result = new ArrayList<>();
        for (RoleEmployeeEntity entity: entities) {
            result.add(toRole(entity));
        }
        return result;
    }
}
