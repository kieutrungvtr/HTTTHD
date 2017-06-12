package com.example.cowmanager.entity;

import com.example.cowmanager.jpa.IdEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "cagelog")
public class CageLogEntity extends IdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 4387314388930957232L;

    @OneToOne
    @JoinColumn(name = "maChuong")
    private CageEntity chuong;

    private Timestamp ngayDon;

    /**
     * @return the chuong
     */
    public CageEntity getChuong() {
        return chuong;
    }

    /**
     * @param chuong the chuong to set
     */
    public void setChuong(CageEntity chuong) {
        this.chuong = chuong;
    }

    /**
     * @return the ngayDon
     */
    public Timestamp getNgayDon() {
        return ngayDon;
    }

    /**
     * @param ngayDon the ngayDon to set
     */
    public void setNgayDon(Timestamp ngayDon) {
        this.ngayDon = ngayDon;
    }


}
