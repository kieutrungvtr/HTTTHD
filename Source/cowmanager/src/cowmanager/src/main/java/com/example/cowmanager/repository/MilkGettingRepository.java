package com.example.cowmanager.repository;

import com.example.cowmanager.entity.MilkGettingEntity;
import com.example.cowmanager.jpa.RepositoryBase;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class MilkGettingRepository extends RepositoryBase<MilkGettingEntity, Integer> {

    public List<MilkGettingEntity> findAllToday(Timestamp startTime
            , Timestamp endTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM MilkGettingEntity e ");
        builder.append(" WHERE e.ngayVatSua between ");
        builder.append(" ( " + startTime + " , " + endTime + ")");
        final Query query = getEntityManager().createQuery(builder.toString());
        return query.getResultList();
    }

}
