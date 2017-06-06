package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MilkGetting implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -815698195012745935L;

    private Cow bo;

    private Integer nangSuat;

    private Timestamp ngayVatSua;

    private Timestamp ngayNhap;

    private Timestamp ngayTao;

    /**
     * @return the bo
     */
    public Cow getBo() {
        return bo;
    }

    /**
     * @param bo the bo to set
     */
    public void setBo(Cow bo) {
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
