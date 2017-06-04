package com.example.cowmanager.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class EmployeeEntity extends IdEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3655010184679286575L;
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
	private Integer boPhan;
	/**
	 * 
	 */
	private String chucDanh;
	/**
	 * 
	 */
	private Integer trangThai;
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
	@OneToMany(mappedBy ="nhanVien")
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
	public Integer getBoPhan() {
		return boPhan;
	}
	/**
	 * @param boPhan the boPhan to set
	 */
	public void setBoPhan(Integer boPhan) {
		this.boPhan = boPhan;
	}
	/**
	 * @return the chucDanh
	 */
	public String getChucDanh() {
		return chucDanh;
	}
	/**
	 * @param chucDanh the chucDanh to set
	 */
	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
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
	
	
}
