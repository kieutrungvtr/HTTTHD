package com.example.cowmanager.repository;

import com.example.cowmanager.entity.CowEntity;
import com.example.cowmanager.jpa.RepositoryBase;
import com.example.cowmanager.util.CowManagerConstants;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CowRepository extends RepositoryBase<CowEntity, Integer> {

    public List<CowEntity> findAllAvailable() {
        StringBuilder builder = new StringBuilder();
        builder.append(" select c from CowEntity");
        builder.append(" where c.trangThai != :trangThai");
        final Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("trangThai", CowManagerConstants.COW_STATUS_OFF);
        return query.getResultList();
    }

    public List<CowEntity> findAllByMaNv(Integer maNv) {
        StringBuilder builder = new StringBuilder();
        builder.append(" select c from CowEntity");
        builder.append(" where c.trangThai != :trangThai");
        builder.append(" and c.nhanVien.maNv = :maNv");
        final Query query = getEntityManager().createQuery(builder.toString());
        query.setParameter("trangThai", CowManagerConstants.COW_STATUS_OFF);
        query.setParameter("maNv", maNv);
        return query.getResultList();
    }

}
