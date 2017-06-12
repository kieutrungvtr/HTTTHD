package com.example.cowmanager.entity;

import com.example.cowmanager.jpa.IdEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends IdEntity {
    /**
     *
     */
    private static final long serialVersionUID = -3655010184679286575L;
    /**
     *
     */
    private Integer maNv;

    /**
     *
     */
    private String ten;
    /**
     *
     */
    private String ngaySinh;
    /**
     *
     */
    private Integer soDt;
    /**
     *
     */
    private String diaChi;
    /**
     *
     */
    private String boPhan;
    /**
     *
     */
    private Integer trangThai;
    /**
     *
     */
    @OneToOne
    @JoinColumn(name = "chuc_vu")
    private RoleEmployeeEntity quyen;
    /**
     *
     */
    private Timestamp ngayCapNhat;
    /**
     *
     */
    private Timestamp ngayTao;
    /**
     *
     */
    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.EAGER)
    private List<CowEntity> danhSachBo;

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
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
    public List<CowEntity> getDanhSachBo() {
        return danhSachBo;
    }

    /**
     * @param danhSachBo the danhSachBo to set
     */
    public void setDanhSachBo(List<CowEntity> danhSachBo) {
        this.danhSachBo = danhSachBo;
    }

    public Integer getMaNv() {
        return maNv;
    }

    public void setMaNv(Integer maNv) {
        this.maNv = maNv;
    }


    /**
     * @return the quyen
     */
    public RoleEmployeeEntity getQuyen() {
        return quyen;
    }

    /**
     * @param quyen the quyen to set
     */
    public void setQuyen(RoleEmployeeEntity quyen) {
        this.quyen = quyen;
    }
}
