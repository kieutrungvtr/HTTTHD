package com.example.cowmanager.model;

import java.io.Serializable;

public class DeviceRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -440551275716052323L;

    private Integer maTb;

    private String tenTb;

    private Integer tinhTrang;

    private String moTa;

    private String nhaCungCap;

    private Integer maBo;

    /**
     * @return the maTb
     */
    public Integer getMaTb() {
        return maTb;
    }

    /**
     * @param maTb the maTb to set
     */
    public void setMaTb(Integer maTb) {
        this.maTb = maTb;
    }

    /**
     * @return the tenTb
     */
    public String getTenTb() {
        return tenTb;
    }

    /**
     * @param tenTb the tenTb to set
     */
    public void setTenTb(String tenTb) {
        this.tenTb = tenTb;
    }

    /**
     * @return the tinhTrang
     */
    public Integer getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the nhaCungCap
     */
    public String getNhaCungCap() {
        return nhaCungCap;
    }

    /**
     * @param nhaCungCap the nhaCungCap to set
     */
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Integer getMaBo() {
        return maBo;
    }

    public void setMaBo(Integer maBo) {
        this.maBo = maBo;
    }

}
