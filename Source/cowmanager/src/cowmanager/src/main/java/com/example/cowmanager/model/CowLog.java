package com.example.cowmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CowLog implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4604308382168081872L;

    private Cow bo;

    private Integer canNang;

    private Integer nhietDo;

    private Integer protit;

    private Integer chatBeo;

    private Integer tinhTrang;

    private Timestamp ngayCapNhat;

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
     * @return the canNang
     */
    public Integer getCanNang() {
        return canNang;
    }

    /**
     * @param canNang the canNang to set
     */
    public void setCanNang(Integer canNang) {
        this.canNang = canNang;
    }

    /**
     * @return the nhietDo
     */
    public Integer getNhietDo() {
        return nhietDo;
    }

    /**
     * @param nhietDo the nhietDo to set
     */
    public void setNhietDo(Integer nhietDo) {
        this.nhietDo = nhietDo;
    }

    /**
     * @return the protit
     */
    public Integer getProtit() {
        return protit;
    }

    /**
     * @param protit the protit to set
     */
    public void setProtit(Integer protit) {
        this.protit = protit;
    }

    /**
     * @return the chatBeo
     */
    public Integer getChatBeo() {
        return chatBeo;
    }

    /**
     * @param chatBeo the chatBeo to set
     */
    public void setChatBeo(Integer chatBeo) {
        this.chatBeo = chatBeo;
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

}
