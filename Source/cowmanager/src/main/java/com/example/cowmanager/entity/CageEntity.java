package com.example.cowmanager.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.OneToMany;

public class CageEntity extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7241632482696938442L;

	private String maChuong;

	private String viTri;

	private Integer gioiHan;

	private Integer deletedFlag;

	private Timestamp ngayCapNhat;

	private Timestamp ngayTao;

	@OneToMany(mappedBy = "chuong")
	private List<CowEntity> danhSachBo;
	
	@OneToMany(mappedBy = "chuong")
	private List<CageLogEntity> lichDon;

	/**
	 * @return the maChuong
	 */
	public String getMaChuong() {
		return maChuong;
	}

	/**
	 * @param maChuong
	 *            the maChuong to set
	 */
	public void setMaChuong(String maChuong) {
		this.maChuong = maChuong;
	}

	/**
	 * @return the viTri
	 */
	public String getViTri() {
		return viTri;
	}

	/**
	 * @param viTri
	 *            the viTri to set
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
	 * @param gioiHan
	 *            the gioiHan to set
	 */
	public void setGioiHan(Integer gioiHan) {
		this.gioiHan = gioiHan;
	}

	/**
	 * @return the deletedFlag
	 */
	public Integer getDeletedFlag() {
		return deletedFlag;
	}

	/**
	 * @param deletedFlag
	 *            the deletedFlag to set
	 */
	public void setDeletedFlag(Integer deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	/**
	 * @return the ngayCapNhat
	 */
	public Timestamp getNgayCapNhat() {
		return ngayCapNhat;
	}

	/**
	 * @param ngayCapNhat
	 *            the ngayCapNhat to set
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
	 * @param ngayTao
	 *            the ngayTao to set
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

	/**
	 * @return the lichDon
	 */
	public List<CageLogEntity> getLichDon() {
		return lichDon;
	}

	/**
	 * @param lichDon the lichDon to set
	 */
	public void setLichDon(List<CageLogEntity> lichDon) {
		this.lichDon = lichDon;
	}

}
