package com.example.cowmanager.model;

import java.util.List;

public class Employee {

    private Integer maNv;

    private String tenNv;

    private String ngaySinh;

    private Integer soDt;

    private String boPhan;

    private RoleEmployee chucDanh;

    private List<Cow> danhSachBo;

    /**
     * @return the tenNv
     */
    public String getTenNv() {
        return tenNv;
    }

    /**
     * @param tenNv the tenNv to set
     */
    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the soDt
     */
    public Integer getSoDt() {
        return soDt;
    }

    /**
     * @param soDt the soDt to set
     */
    public void setSoDt(Integer soDt) {
        this.soDt = soDt;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    /**
     * @return the chucDanh
     */
    public RoleEmployee getChucDanh() {
        return chucDanh;
    }

    /**
     * @param chucDanh the chucDanh to set
     */
    public void setChucDanh(RoleEmployee chucDanh) {
        this.chucDanh = chucDanh;
    }

    public List<Cow> getDanhSachBo() {
        return danhSachBo;
    }

    public void setDanhSachBo(List<Cow> danhSachBo) {
        this.danhSachBo = danhSachBo;
    }

    public Integer getMaNv() {
        return maNv;
    }

    public void setMaNv(Integer maNv) {
        this.maNv = maNv;
    }

}
