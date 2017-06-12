package com.example.cowmanager.entity;

import com.example.cowmanager.jpa.IdEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "milk_getting")
public class MilkGettingEntity extends IdEntity {

    /**
     *
     */
    private static final long serialVersionUID = 3219156901479913717L;

    @OneToOne
    @JoinColumn(name = "lichVatSua")
    private CowEntity bo;

    private Integer nangSuat;

    private Timestamp ngayVatSua;

    private Timestamp ngayNhap;

    private Timestamp ngayTao;

    /**
     * @return the bo
     */
    public CowEntity getBo() {
        return bo;
    }

    /**
     * @param bo the bo to set
     */
    public void setBo(CowEntity bo) {
        this.bo = bo;
    }

    /**
     * @return the nangSuat
     */
    public Integer getNangSuat() {
        return nangSuat;
    }

    /**
     * @param nangSuat the nangSuat to set
     */
    public void setNangSuat(Integer nangSuat) {
        this.nangSuat = nangSuat;
    }

    /**
     * @return the ngayVatSua
     */
    public Timestamp getNgayVatSua() {
        return ngayVatSua;
    }

    /**
     * @param ngayVatSua the ngayVatSua to set
     */
    public void setNgayVatSua(Timestamp ngayVatSua) {
        this.ngayVatSua = ngayVatSua;
    }

    /**
     * @return the ngayNhap
     */
    public Timestamp getNgayNhap() {
        return ngayNhap;
    }

    /**
     * @param ngayNhap the ngayNhap to set
     */
    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    /**
     * @return the ngayTao
     */
    public Timestamp getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

}
