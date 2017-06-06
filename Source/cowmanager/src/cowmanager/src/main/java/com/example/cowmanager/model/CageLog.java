package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CageLog implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6487141042907877008L;

    private Cage chuong;

    private Timestamp ngayDon;

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

    public Cage getChuong() {
        return chuong;
    }

    public void setChuong(Cage chuong) {
        this.chuong = chuong;
    }

}
