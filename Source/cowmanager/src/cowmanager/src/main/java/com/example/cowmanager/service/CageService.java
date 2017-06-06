package com.example.cowmanager.service;

import com.example.cowmanager.entity.CageEntity;
import com.example.cowmanager.entity.CageLogEntity;
import com.example.cowmanager.model.Cage;
import com.example.cowmanager.model.CageLog;
import com.example.cowmanager.model.CageRequest;
import com.example.cowmanager.model.CowManagerException;
import com.example.cowmanager.repository.CageLogRepository;
import com.example.cowmanager.repository.CageRepository;
import com.example.cowmanager.util.CowManagerConstants;
import com.example.cowmanager.util.RandomGenerator;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CageService extends BaseService {

    @Autowired
    private CageRepository cageRepository;

    @Autowired
    private CageLogRepository cageLogRepository;

    public List<Cage> getAllCase() throws CowManagerException {
        List<CageEntity> entities = cageRepository.findAllOn();
        List<Cage> result = new ArrayList<>();
        for (CageEntity entity : entities) {
            Cage cage = toCage(entity);
            result.add(cage);
        }
        return result;
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cage createCage(CageRequest request) throws CowManagerException {
        Integer gioiHan = request.getGioiHan();
        if (gioiHan == null) {
            gioiHan = 0;
        }
        String diaChi = request.getViTri();
        if (TextUtils.isEmpty(diaChi)) {
            throw new CowManagerException("Dia chi chuong khong dc trong");
        }
        CageEntity entity = toCageEntity(request);
        CageEntity existedEntity = null;
        Integer maChuong = new Integer(0);
        do {
            maChuong = new Integer(RandomGenerator.getIntRand());
            existedEntity = cageRepository
                    .findOneByColumn("maChuong", maChuong);
        } while (null != existedEntity);
        entity.setMaChuong(maChuong);
        entity.setNgayTao(new Timestamp(System.currentTimeMillis()));
        entity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        entity.setTrangThai(CowManagerConstants.CAGE_STATUS_ON);
        entity = cageRepository.save(entity);
        if (entity == null) {
            throw new CowManagerException("Khong the them vao db");
        } else {
            return toCage(entity);
        }
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cage updateCage(CageRequest request) throws CowManagerException {
        if (request.getMaChuong() == null) {
            throw new CowManagerException("Ma chuong khong dc rong");
        }
        CageEntity existedEntity = cageRepository
                .findOneByColumn("maChuong", request.getMaChuong());
        if (existedEntity == null) {
            throw new CowManagerException("Ma chuong khong ton tai trong db");
        }
        Integer gioiHan = request.getGioiHan();
        if (gioiHan == null) {
            gioiHan = 0;
        }
        existedEntity.setGioiHan(gioiHan);
        String diaChi = request.getViTri();
        if (!TextUtils.isEmpty(diaChi)) {
            existedEntity.setViTri(diaChi);
        }
        existedEntity.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        existedEntity = cageRepository.save(existedEntity);
        if (existedEntity == null) {
            throw new CowManagerException("Khong the cap nhat vao db");
        } else {
            return toCage(existedEntity);
        }
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public Cage releaseCage(CageRequest request) throws CowManagerException {
        if (request.getMaChuong() == null) {
            throw new CowManagerException("Ma chuong khong ton tai");
        }
        CageEntity cageProfile = cageRepository
                .findOneByColumn("maChuong", request.getMaChuong());
        if (cageProfile == null) {
            throw new CowManagerException("Ma chuong khong co trong db");
        }
        cageProfile.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
        cageProfile.setTrangThai(CowManagerConstants.EMPLOYEE_STATUS_OFF);
        cageProfile = cageRepository.save(cageProfile);
        if (cageProfile != null) {
            return toCage(cageProfile);
        } else {
            throw new CowManagerException("Cannot save to db");
        }
    }

    @Transactional(rollbackOn = CowManagerException.class)
    public void cleanCage(Integer maChuong, Timestamp ngayDon) throws CowManagerException {
        if (maChuong == null) {
            throw new CowManagerException("Ma chuong khong ton tai");
        }
        CageEntity cageProfile = cageRepository
                .findOneByColumn("maChuong", maChuong);
        if (cageProfile == null) {
            throw new CowManagerException("Ma chuong khong co trong db");
        }

        CageLogEntity log = new CageLogEntity();
        log.setChuong(cageProfile);
        if (ngayDon == null) {
            throw new CowManagerException("Ngay don khong hop le");
        }
        log.setNgayDon(ngayDon);
    }

    public List<CageLog> calendarCleaningToday() throws CowManagerException {
        Timestamp timeStart, timeEnd;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        timeStart = new Timestamp(calendar.getTimeInMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        timeEnd = new Timestamp(calendar.getTimeInMillis());
        List<CageLogEntity> entities = cageLogRepository.findAllByTimeRange(timeStart
                , timeEnd);
        return convertToCalendarCleaning(entities);
    }

    public Cage getById(Integer maChuong) throws CowManagerException {
        if (maChuong == null) {
            throw new CowManagerException("Ma chuong khong ton tai");
        }
        CageEntity cageProfile = cageRepository
                .findOneByColumn("maChuong", maChuong);
        if (cageProfile == null) {
            throw new CowManagerException("Ma chuong khong co trong db");
        } else {
            return toCage(cageProfile);
        }
    }

}
