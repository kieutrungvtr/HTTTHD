package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Cage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7216876394243624036L;

    private Integer maChuong;

    private String viTri;

    private Integer gioiHan;

    private Integer trangThai;

    private Timestamp ngayCapNhat;

    private Timestamp ngayTao;

    private List<Cow> danhSachBo;

    private List<CageLog> lichDon;

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
     * @return the viTri
     */
    public String getViTri() {
        return viTri;
    }

    /**
     * @param viTri the viTri to set
     */
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    /**
     * @return the gioiHan
     */
    public Integer getGioiHan() {
        return gioiHan;
    }

    /**
     * @param gioiHan the gioiHan to set
     */
    public void setGioiHan(Integer gioiHan) {
        this.gioiHan = gioiHan;
    }

    /**
     * @return the trangThai
     */
    public Integer getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the ngayCapNhat
     */
    public Timestamp getNgayCapNhat() {
        return ngayCapNhat;
    }

    /**
     * @param ngayCapNhat the ngayCapNhat to set
     */
    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
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

    /**
     * @return the danhSachBo
     */
    public List<Cow> getDanhSachBo() {
        return danhSachBo;
    }

    /**
     * @param danhSachBo the danhSachBo to set
     */
    public void setDanhSachBo(List<Cow> danhSachBo) {
        this.danhSachBo = danhSachBo;
    }

    /**
     * @return the lichDon
     */
    public List<CageLog> getLichDon() {
        return lichDon;
    }

    /**
     * @param lichDon the lichDon to set
     */
    public void setLichDon(List<CageLog> lichDon) {
        this.lichDon = lichDon;
    }


}
