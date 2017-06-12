package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Cow implements Serializable {

    private Integer maBo;

    private String dacDiem;

    private Timestamp ngayNhap;

    private Cage chuong;

    private Employee nhanVien;

    private String benhTat;

    private Device thietBi;

    private List<MilkGetting> lichVatSua;

    private List<CowLog> lichChamSocSucKhoe;

    public Integer getMaBo() {
        return maBo;
    }

    public void setMaBo(Integer maBo) {
        this.maBo = maBo;
    }

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

    public Timestamp getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Cage getChuong() {
        return chuong;
    }

    public void setChuong(Cage chuong) {
        this.chuong = chuong;
    }

    public Employee getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(Employee nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getBenhTat() {
        return benhTat;
    }

    public void setBenhTat(String benhTat) {
        this.benhTat = benhTat;
    }

    public Device getThietBi() {
        return thietBi;
    }

    public void setThietBi(Device thietBi) {
        this.thietBi = thietBi;
    }

    public List<MilkGetting> getLichVatSua() {
        return lichVatSua;
    }

    public void setLichVatSua(List<MilkGetting> lichVatSua) {
        this.lichVatSua = lichVatSua;
    }

    public List<CowLog> getLichChamSocSucKhoe() {
        return lichChamSocSucKhoe;
    }

    public void setLichChamSocSucKhoe(List<CowLog> lichChamSocSucKhoe) {
        this.lichChamSocSucKhoe = lichChamSocSucKhoe;
    }
}
