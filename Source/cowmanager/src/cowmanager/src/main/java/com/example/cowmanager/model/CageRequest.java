package com.example.cowmanager.model;

import java.io.Serializable;

public class CageRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7410600263988447120L;

    private Integer maChuong;

    private String viTri;

    private Integer gioiHan;

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


}
