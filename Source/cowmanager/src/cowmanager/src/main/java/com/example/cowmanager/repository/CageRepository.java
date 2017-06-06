package com.example.cowmanager.repository;

import com.example.cowmanager.entity.CageEntity;
import com.example.cowmanager.jpa.RepositoryBase;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CageRepository extends RepositoryBase<CageEntity, Integer> {

    public List<CageEntity> findAllOn() {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT e ");
        builder.append(" FROM CageEntity e ");
        builder.append(" WHERE e.trangThai = :trangThai");

        final Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("trangThai", CowManagerConstants.CAGE_STATUS_ON);
        return query.getResultList();
    }

}
