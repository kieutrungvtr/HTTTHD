package com.example.cowmanager.repository;

import com.example.cowmanager.entity.DeviceEntity;
import com.example.cowmanager.jpa.RepositoryBase;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DeviceRepository extends RepositoryBase<DeviceEntity, Integer> {

    public List<DeviceEntity> findAllByStatus(Integer tinhTrang) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM DeviceEntity e ");
        builder.append(" WHERE e.tinhTrang = :tinhTrang");

        final Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("tinhTrang", tinhTrang);
        return query.getResultList();
    }

    public List<DeviceEntity> findByCowIds(List<Integer> cowIds) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM DeviceEntity e ");
        builder.append(" WHERE e.bo.maBo IN ( " + cowIds.get(0));
        for (int i = 1; i < cowIds.size(); i++) {
            builder.append(" , ");
            builder.append(cowIds.get(i));
        }
        builder.append(" ) ");
        final Query query = getEntityManager().createQuery(builder.toString());
        return query.getResultList();
    }

    public List<DeviceEntity> findAllDeviceAvailable() {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM DeviceEntity e ");
        builder.append(" WHERE e.tinhTrang = :tinhTrang");
        builder.append(" AND e.bo IS NULL");
        final Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("tinhTrang", CowManagerConstants.DEVICE_STATUS_GOOD);
        return query.getResultList();
    }

}
