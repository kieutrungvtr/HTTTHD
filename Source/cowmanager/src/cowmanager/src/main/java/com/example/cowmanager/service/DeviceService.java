package com.example.cowmanager.service;

import com.example.cowmanager.entity.CageEntity;
import com.example.cowmanager.entity.CowEntity;
import com.example.cowmanager.entity.DeviceEntity;
import com.example.cowmanager.model.CowManagerException;
import com.example.cowmanager.model.Device;
import com.example.cowmanager.model.DeviceRequest;
import com.example.cowmanager.repository.CageRepository;
import com.example.cowmanager.repository.CowRepository;
import com.example.cowmanager.repository.DeviceRepository;
import com.example.cowmanager.util.CowManagerConstants;
import com.example.cowmanager.util.RandomGenerator;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService extends BaseService {

    /**
     * {@link DeviceRepository}.
     */
    @Autowired
    private DeviceRepository deviceRepository;
    /**
     * {@link CowRepository}.
     */
    @Autowired
    private CowRepository cowRepository;
    /**
     * {@link CageRepository}.
     */
    @Autowired
    private CageRepository cageRepository;

    public List<Device> getListDevice(Integer trangThai)
            throws CowManagerException {
        List<DeviceEntity> entities = new ArrayList<>();
        if (trangThai == null) {
            entities = deviceRepository.findAll();
        } else {
            entities = deviceRepository.findAllByStatus(trangThai);
        }
        return convertToListDevice(entities);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Device addDevice(DeviceRequest request) throws CowManagerException {
        String tenTB = request.getTenTb();
        String moTa = request.getMoTa();
        String nhaCungCap = request.getNhaCungCap();
        Integer tinhTrang = request.getTinhTrang();
        Integer maBo = request.getMaBo();
        if (TextUtils.isEmpty(tenTB)) {
            throw new CowManagerException("Ten thiet bi khong dc rong");
        }
        if (TextUtils.isEmpty(nhaCungCap)) {
            throw new CowManagerException("Nha cung cap khong dc rong");
        }
        if (TextUtils.isEmpty(moTa)) {
            throw new CowManagerException("Nha cung cap khong dc rong");
        }
        if (tinhTrang == null) {
            request.setTinhTrang(CowManagerConstants.DEVICE_STATUS_GOOD);
        }
        DeviceEntity entity = toDeviceEntity(request);
        DeviceEntity existedEntity;
        Integer maTB = new Integer(0);
        do {
            maTB = new Integer(RandomGenerator.getIntRand());
            existedEntity = deviceRepository
                    .findOneByColumn("maTb", maTB);
        } while (null != existedEntity);

        entity.setMaTb(maTB);
        entity.setBo(registerCowToDevice(maBo));
        entity.setNgayNhap(new Timestamp(System.currentTimeMillis()));
        entity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        entity = deviceRepository.save(entity);
        return toDevice(entity);
    }

    private CowEntity registerCowToDevice(Integer maBo) throws CowManagerException {
        if (maBo != null) {
            CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
            if (cowEntity == null) {
                throw new CowManagerException("Ma bo khong ton tai trong db");
            } else {
                return cowEntity;
            }
        }
        return null;
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Device removeDeviceCow(DeviceRequest request) throws CowManagerException {
        Integer maTb = request.getMaTb();
        Integer maBo = request.getMaBo();
        if (maTb == null) {
            throw new CowManagerException("Ma bo khong dc de trong");
        }
        DeviceEntity existedEntity = deviceRepository
                .findOneByColumn("maTb", request.getMaTb());
        if (existedEntity == null) {
            throw new CowManagerException("Khong ton tai thiet bi trong db");
        }
        if (maBo != null) {
            CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
            if (cowEntity == null) {
                throw new CowManagerException("Ma bo khong ton tai trong db");
            } else {
                existedEntity.setBo(null);
            }
        }
        existedEntity.setNgayNhap(new Timestamp(System.currentTimeMillis()));
        existedEntity = deviceRepository.save(existedEntity);
        return toDevice(existedEntity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Device updateDevice(DeviceRequest request) throws CowManagerException {
        Integer maTb = request.getMaTb();
        if (maTb == null) {
            throw new CowManagerException("Ma bo khong dc de trong");
        }
        DeviceEntity existedEntity = deviceRepository
                .findOneByColumn("maTb", request.getMaTb());
        if (existedEntity == null) {
            throw new CowManagerException("Khong ton tai thiet bi trong db");
        }
        String tenTB = request.getTenTb();
        String moTa = request.getMoTa();
        String nhaCungCap = request.getNhaCungCap();
        Integer tinhTrang = request.getTinhTrang();
        Integer maBo = request.getMaBo();
        if (!TextUtils.isEmpty(tenTB)) {
            existedEntity.setTenTb(tenTB);
        }
        if (!TextUtils.isEmpty(nhaCungCap)) {
            existedEntity.setNhaCungCap(nhaCungCap);
        }
        if (!TextUtils.isEmpty(moTa)) {
            existedEntity.setMoTa(moTa);
        }
        if (tinhTrang != null) {
            existedEntity.setTinhTrang(tinhTrang);
        }
        // Gan device cho con bo moi
        if (maBo != null) {
            CowEntity cowEntity = cowRepository.findOneByColumn("maBo", maBo);
            if (cowEntity == null) {
                throw new CowManagerException("Ma bo khong ton tai trong db");
            } else {
                existedEntity.setBo(cowEntity);
            }
        }
        existedEntity.setNgayNhap(new Timestamp(System.currentTimeMillis()));
        existedEntity = deviceRepository.save(existedEntity);
        return toDevice(existedEntity);
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Device removeDevice(DeviceRequest request) throws CowManagerException {
        Integer maTb = request.getMaTb();
        if (maTb == null) {
            throw new CowManagerException("Ma bo khong dc de trong");
        }
        DeviceEntity existedEntity = deviceRepository
                .findOneByColumn("maTb", request.getMaTb());
        if (existedEntity == null) {
            throw new CowManagerException("Khong ton tai thiet bi trong db");
        }
        existedEntity.setTinhTrang(CowManagerConstants.DEVICE_STATUS_OFF);
        // Xoa bo ra khoi device
        existedEntity.setBo(null);
        existedEntity = deviceRepository.save(existedEntity);
        return toDevice(existedEntity);
    }

    public List<Device> getListDeviceByCage(Integer cageId) throws CowManagerException {
        List<Device> result = new ArrayList<>();
        if (cageId == null) {
            throw new CowManagerException("Ma chuong khong duoc trong");
        }
        CageEntity cageEntity = cageRepository.findOneByColumn("maChuong", cageId);
        if (cageEntity == null) {
            throw new CowManagerException("Chuong khong ton tai " + cageId);
        }
        List<CowEntity> cowEntities = cageEntity.getDanhSachBo();
        List<Integer> cowIds = new ArrayList<>();
        for (CowEntity entity : cowEntities) {
            cowIds.add(entity.getMaBo());
        }
        if (cowIds.size() == 0) {
            return result;
        }
        List<DeviceEntity> deviceEntities = deviceRepository.findByCowIds(cowIds);
        return convertToListDevice(deviceEntities);
    }

    public List<Device> getListDeviceAvailable() throws CowManagerException {
        List<DeviceEntity> entities = deviceRepository.findAllDeviceAvailable();
        return convertToListDevice(entities);
    }

}
