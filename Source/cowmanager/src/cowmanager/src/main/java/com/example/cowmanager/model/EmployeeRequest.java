package com.example.cowmanager.model;

import java.io.Serializable;

public class EmployeeRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5864921753507442739L;

    private Integer maNv;

    private String tenNv;

    private String ngaySinh;

    private Integer sodt;

    private String diaChi;

    private String boPhan;

    private Integer chucDanh;

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
     * @return the sodt
     */
    public Integer getSodt() {
        return sodt;
    }

    /**
     * @param sodt the sodt to set
     */
    public void setSodt(Integer sodt) {
        this.sodt = sodt;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public Integer getMaNv() {
        return maNv;
    }

    public void setMaNv(Integer maNv) {
        this.maNv = maNv;
    }

    public Integer getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(Integer chucDanh) {
        this.chucDanh = chucDanh;
    }


}
