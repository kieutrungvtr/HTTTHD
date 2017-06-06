package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class CowRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2467636039159280844L;

    private Integer maBo;

    private String dacDiem;

    private Timestamp ngayNhap;

    private Integer maChuong;

    private Integer maNhanVien;

    private Integer maThietBi;

    private Integer trangThai;

    private String benhTat;

    private Integer tinhTrangSucKhoe;

    /**
     * @return the maBo
     */
    public Integer getMaBo() {
        return maBo;
    }

    /**
     * @param maBo the maBo to set
     */
    public void setMaBo(Integer maBo) {
        this.maBo = maBo;
    }

    /**
     * @return the dacDiem
     */
    public String getDacDiem() {
        return dacDiem;
    }

    /**
     * @param dacDiem the dacDiem to set
     */
    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
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
     * @return the maChuong
     */
    public Integer getMaChuong() {
        return maChuong;
    }

    /**
     * @param maChuong the maChuong to set
     */
    public void setMaChuong(Integer maChuong) {
        this.maChuong = maChuong;
    }

    /**
     * @return the maNhanVien
     */
    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getBenhTat() {
        return benhTat;
    }

    public void setBenhTat(String benhTat) {
        this.benhTat = benhTat;
    }

    public Integer getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(Integer maThietBi) {
        this.maThietBi = maThietBi;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getTinhTrangSucKhoe() {
        return tinhTrangSucKhoe;
    }

    public void setTinhTrangSucKhoe(Integer tinhTrangSucKhoe) {
        this.tinhTrangSucKhoe = tinhTrangSucKhoe;
    }


}
