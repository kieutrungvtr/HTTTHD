package com.example.cowmanager.repository;

import com.example.cowmanager.entity.CageLogEntity;
import com.example.cowmanager.jpa.RepositoryBase;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class CageLogRepository extends RepositoryBase<CageLogEntity, Integer> {

    public List<CageLogEntity> findAllByTimeRange(Timestamp startTime, Timestamp endTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM CageLogEntity e ");
        builder.append(" WHERE e.ngayDon between ");
        builder.append(" ( " + startTime + " , " + endTime + ")");
        final Query query = getEntityManager().createQuery(builder.toString());
        return query.getResultList();
    }

}