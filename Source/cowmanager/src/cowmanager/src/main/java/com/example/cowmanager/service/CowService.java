package com.example.cowmanager.service;

import com.example.cowmanager.entity.*;
import com.example.cowmanager.model.*;
import com.example.cowmanager.repository.*;
import com.example.cowmanager.util.CowManagerConstants;
import com.example.cowmanager.util.RandomGenerator;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Logger;

@Service
public class CowService extends BaseService {

    @Autowired
    private CageService cageService;

    @Autowired
    private EmployeeRepository employRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private CageRepository cageRepository;

    @Autowired
    private CowRepository cowRepository;

    @Autowired
    private CowLogRepository cowLogRepository;

    @Autowired
    private MilkGettingRepository milkRepository;

    public List<Cow> getListCow() throws CowManagerException {
        List<CowEntity> entities = cowRepository.findAllAvailable();
        return convertToListCow(entities);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cow addCowProfile(CowRequest request) throws CowManagerException {
        String dacDiem = request.getDacDiem();
        Integer maNv = request.getMaNhanVien();
        Integer maChuong = request.getMaChuong();
        Integer maThietBi = request.getMaThietBi();
        if (TextUtils.isEmpty(dacDiem)) {
            throw new CowManagerException("Dac diem nhan dang khong dc trong");
        }
        if (request.getNgayNhap() == null) {
            throw  new CowManagerException("Ngay nhap bo khong duoc trong");
        }

        CowEntity cowEntity = toCowEntity(request);
        cowEntity.setTrangThai(CowManagerConstants.COW_STATUS_ON);
        cowEntity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        cowEntity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));

        if (maNv != null) {
            EmployeeEntity employeeEntity = employRepository.findOneByColumn("maNv", maNv);
            if (employeeEntity == null) {
                throw new CowManagerException("Ma nhan vien khong ton tai trong db");
            } else {
                cowEntity.setNhanVien(employeeEntity);
                if (maChuong != null) {
                    CageEntity cageEntity = cageRepository.findOneByColumn("maChuong", maChuong);
                    if (cageEntity == null) {
                        throw new CowManagerException("Ma chuong khong ton tai trong db");
                    } else {
                        cowEntity.setChuong(cageEntity);
                    }
                }
            }
        }

        if (maThietBi != null) {
            DeviceEntity deviceEntity = deviceRepository.findOneByColumn("maTb", maThietBi);
            if (deviceEntity == null) {
                throw new CowManagerException("Thiet bi khong ton tai");
            } else {
                cowEntity.setThietBi(deviceEntity);
            }
        }

        CowEntity existedEntity;
        Integer maBo = new Integer(0);
        do {
            maBo = new Integer(RandomGenerator.getIntRand());
            existedEntity = cowRepository
                    .findOneByColumn("maBo", maBo);
        } while (null != existedEntity);
        cowEntity.setMaBo(maBo);
        cowEntity = cowRepository.save(cowEntity);
        return toCow2(cowEntity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cow updateCowProfile(CowRequest request) throws CowManagerException {
        Integer maBo = request.getMaBo();
        Integer maNv = request.getMaNhanVien();
        Integer maChuong = request.getMaChuong();
        Integer maThietBi = request.getMaThietBi();
        String dacDiem = request.getDacDiem();
        String benhTat = request.getBenhTat();
        Integer trangThai = request.getTrangThai();
        if (maBo == null) {
            throw new CowManagerException("Ma bo khong ton tai");
        }
        CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
        if (cowEntity == null) {
            throw new CowManagerException("Bo khong ton tai trong db");
        }
        if (!TextUtils.isEmpty(benhTat)) {
            cowEntity.setBenhTat(benhTat);
        }
        if (!TextUtils.isEmpty(dacDiem)) {
            cowEntity.setDacDiem(dacDiem);
        }

        if (trangThai != null) {
            cowEntity.setTrangThai(trangThai);
        }

        if (maNv != null) {
            EmployeeEntity employeeEntity = employRepository.findOneByColumn("maNv", maNv);
            if (employeeEntity == null) {
                throw new CowManagerException("Ma nhan vien khong ton tai trong db");
            } else {
                cowEntity.setNhanVien(employeeEntity);
                if (maChuong != null) {
                    CageEntity cageEntity = cageRepository.findOneByColumn("maChuong", maChuong);
                    if (cageEntity == null) {
                        throw new CowManagerException("Ma chuong khong ton tai trong db");
                    } else {
                        cowEntity.setChuong(cageEntity);
                        cowEntity.setTrangThai(CowManagerConstants.COW_STATUS_IN_CASE);
                    }
                }
            }
        }
        if (maThietBi != null) {
            DeviceEntity deviceEntity = deviceRepository.findOneByColumn("maTb", maThietBi);
            if (deviceEntity == null) {
                throw new CowManagerException("Thiet bi khong ton tai");
            } else {
                cowEntity.setThietBi(deviceEntity);
            }
        }
        cowEntity = cowRepository.save(cowEntity);
        return toCow2(cowEntity);
    }

    public Cow getCowById(Integer maBo) throws CowManagerException {
        if (maBo == null) {
            throw new CowManagerException("Ma bo khong ton tai");
        }
        CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
        return toCow(cowEntity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public MilkGetting getMilk(CowRequest request) throws CowManagerException {
        Integer maBo = request.getMaBo();

        if (maBo == null) {
            throw new CowManagerException("Ma bo khong ton tai");
        }
        CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
        if (cowEntity == null) {
            throw new CowManagerException("Bo khong ton tai trong db");
        }
        // Kiem tra bo da ton tai trong chua
        if(cowEntity.getChuong() != null) {
            cageService.cleanCage(cowEntity.getChuong().getMaChuong(), new Timestamp(System.currentTimeMillis()));
        } else {
            throw new CowManagerException("Bo chua duoc dua vao chuong");
        }
        // Kiem tra suc khoe
        CowRequest healthRequest = new CowRequest();
        healthRequest.setMaBo(maBo);
        CowLog health = checkHealth(healthRequest);
        if (health.getTinhTrang() == CowManagerConstants.COW_HEALTH_BAD) {
            throw new CowManagerException("Bo suc khoe kem, ko the lay sua");
        }

        MilkGettingEntity milkEntity = new MilkGettingEntity();
        milkEntity.setBo(cowEntity);
        milkEntity.setNangSuat((int) (Math.random() * 10));
        milkEntity.setNgayNhap(new Timestamp(System.currentTimeMillis()));
        milkEntity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        milkEntity.setNgayVatSua(new Timestamp(System.currentTimeMillis()));
        milkEntity = milkRepository.save(milkEntity);
        return toMilkGetting(milkEntity);
    }

    public List<MilkGetting> getListMilkTimeRange(Timestamp startTime, Timestamp endTime) throws CowManagerException {
        // Get report a month
        if (startTime == null && endTime == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(System.currentTimeMillis()));
            calendar.add(Calendar.MONTH, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            startTime = new Timestamp(calendar.getTimeInMillis());
            endTime = new Timestamp(System.currentTimeMillis());
        }
        List<MilkGettingEntity> entities = milkRepository.findAllToday(startTime, endTime);
        HashMap<CowEntity, MilkGettingEntity> hashCow = new HashMap<>();
        for (MilkGettingEntity entity: entities) {
            MilkGettingEntity data = hashCow.putIfAbsent(entity.getBo(), entity);
            //Exist
            if (data == null) {
                hashCow.get(entity.getBo()).setNangSuat(entity.getNangSuat());
            }
        }
        List<MilkGettingEntity> result = new ArrayList<>(hashCow.values());
        return convertToListMilk(result);
    }
    
    @Transactional(rollbackOn = CowManagerException.class)
    public List<MilkGetting> getListMilkGettingToday() throws CowManagerException {
        Timestamp startTime, endTime;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        startTime = new Timestamp(calendar.getTimeInMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        endTime = new Timestamp(calendar.getTimeInMillis());

        List<MilkGettingEntity> entities = milkRepository.findAllToday(startTime, endTime);
        HashMap<CowEntity, MilkGettingEntity> hashCow = new HashMap<>();
        for (MilkGettingEntity entity: entities) {
            MilkGettingEntity data = hashCow.putIfAbsent(entity.getBo(), entity);
            //Exist
            if (data == null) {
                hashCow.get(entity.getBo()).setNangSuat(entity.getNangSuat());
            }
        }
        List<MilkGettingEntity> result = new ArrayList<>(hashCow.values());
        return convertToListMilk(result);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public CowLog checkHealth(CowRequest request) throws CowManagerException {
        Integer maBo = request.getMaBo();
        if (maBo == null) {
            throw new CowManagerException("Ma bo khong ton tai");
        }
        CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
        if (cowEntity == null) {
            throw new CowManagerException("Bo khong ton tai trong db");
        }
        CowLogEntity cowLogEntity = new CowLogEntity();
        cowLogEntity.setBo(cowEntity);
        cowLogEntity.setCanNang(RandomGenerator.getIntRand());
        cowLogEntity.setChatBeo(RandomGenerator.getIntRand());
        cowLogEntity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        cowLogEntity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        int temperature = (int) (Math.random() * 50);
        cowLogEntity.setNhietDo(temperature);
        cowLogEntity.setProtit(RandomGenerator.getIntRand());
        if (temperature > 37) {
            cowLogEntity.setTinhTrang(CowManagerConstants.COW_HEALTH_BAD);
        } else {
            int status = (int) (Math.random() * 2 + 1);
            cowLogEntity.setTinhTrang(status);
        }
        cowLogEntity = cowLogRepository.save(cowLogEntity);
        return toCowLog(cowLogEntity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cow removeCowProfile(CowRequest request) throws CowManagerException {
        Integer maBo = request.getMaBo();
        Integer maNhanVien = request.getMaNhanVien();
        if (maBo == null) {
            throw new CowManagerException("Ma bo khong ton tai");
        }
        CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
        if (cowEntity == null) {
            throw new CowManagerException("Bo khong ton tai trong db");
        }
        if (maNhanVien != null) {
            EmployeeEntity employeeEntity = employRepository.findOneByColumn("maNv", maNhanVien);
            if (employeeEntity == null) {
                throw new CowManagerException("Ma nhan vien khong ton tai trong db");
            } else {
                cowEntity.setChuong(null);
                cowEntity.setTrangThai(CowManagerConstants.COW_STATUS_OFF);
            }
        }
        cowEntity.setThietBi(null);
        cowEntity = cowRepository.save(cowEntity);
        return toCow2(cowEntity);
    }

    // Simulator check health all cow
    @Transactional(rollbackOn = CowManagerException.class)
    public void checkHealthAllCow() throws CowManagerException {
        List<CowEntity> entities = cowRepository.findAllAvailable();
        for (CowEntity entity : entities) {
            CowRequest request = new CowRequest();
            request.setMaBo(entity.getMaBo());
            checkHealth(request);
        }
    }

    public List<Cow> getListCow(CowRequest req) throws CowManagerException {
        Integer maNv = req.getMaNhanVien();
        if (maNv == null) {
            throw new CowManagerException(" Ma nhan vien khong duoc trong ");
        }
        EmployeeEntity employeeEntity = employRepository.findOneByColumn("maNv", maNv);
        if (employeeEntity == null) {
            throw new CowManagerException("Nhan vien khong ton tai trong db");
        }
        RoleEmployeeEntity roleEntity = employeeEntity.getQuyen();
        List<CowEntity> entities = new ArrayList<>();
        if (roleEntity != null) {
            if (roleEntity.getId() == CowManagerConstants.ROLE_EMPLOYEE) {
                entities = cowRepository.findAllByMaNv(maNv);
            } else {
                entities = cowRepository.findAllAvailable();
            }
        }
        return convertToListCow(entities);
    }

    public List<CowLog> getListCowByHealth(CowRequest req) throws CowManagerException {
        Integer maNv = req.getMaNhanVien();
        if (maNv == null) {
            throw new CowManagerException(" Ma nhan vien khong duoc trong ");
        }
        EmployeeEntity employeeEntity = employRepository.findOneByColumn("maNv", maNv);
        if (employeeEntity == null) {
            throw new CowManagerException("Nhan vien khong ton tai trong db");
        }
        RoleEmployeeEntity roleEntity = employeeEntity.getQuyen();
        List<CowEntity> entities = new ArrayList<>();
        if (roleEntity != null) {
            if (roleEntity.getId() == CowManagerConstants.ROLE_EMPLOYEE) {
                entities = cowRepository.findAllByMaNv(maNv);
            } else {
                entities = cowRepository.findAllAvailable();
            }
        }
        List<CowLog> result = new ArrayList<>();
        for (CowEntity cowEntity : entities) {
            List<CowLogEntity> logEntities = cowEntity.getTheoDoiSucKhoe();
            if (logEntities != null) {
                for (CowLogEntity entity : logEntities) {
                    if (req.getTinhTrangSucKhoe().equals(entity.getTinhTrang())) {
                        result.add(toCowLog(entity));
                    }
                }
            }
        }
        return result;
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public List<MilkGetting> getMilkAllCow(Integer maNhanVien) throws CowManagerException {
        List<MilkGettingEntity> resultEntity = new ArrayList<>();
        List<CowEntity> cowEntities;
        if (maNhanVien == null) {
            cowEntities = cowRepository.findAllAvailable();
        } else {
            // Get milk by maNv
            cowEntities = cowRepository.findAllByMaNv(maNhanVien);
        }
        for (CowEntity cowEntity: cowEntities) {
            if (cowEntity.getChuong() != null) {
                cageService.cleanCage(cowEntity.getChuong().getMaChuong(), new Timestamp(System.currentTimeMillis()));
                // Kiem tra suc khoe
                CowRequest healthRequest = new CowRequest();
                healthRequest.setMaBo(cowEntity.getMaBo());
                CowLog health = checkHealth(healthRequest);
                if (health.getTinhTrang() != CowManagerConstants.COW_HEALTH_BAD) {
                    MilkGettingEntity milkEntity = new MilkGettingEntity();
                    milkEntity.setBo(cowEntity);
                    milkEntity.setNangSuat((int) (Math.random() * 10));
                    milkEntity.setNgayNhap(new Timestamp(System.currentTimeMillis()));
                    milkEntity.setNgayTao(new Timestamp(System.currentTimeMillis()));
                    milkEntity.setNgayVatSua(new Timestamp(System.currentTimeMillis()));
                    milkEntity = milkRepository.save(milkEntity);
                    if (milkEntity != null) {
                        resultEntity.add(milkEntity);
                    }
                }
            }
        }
        return convertToListMilk(resultEntity);
    }

}
