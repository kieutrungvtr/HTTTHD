package com.example.cowmanager.entity;

import java.sql.Timestamp;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class DeviceEntity extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3806212433202532146L;

	private String maTb;

	private String tenTb;

	private Integer tinhTrang;

	private String moTa;

	private String nhaCungCap;

	private Timestamp ngayNhap;

	private Timestamp ngayTao;

	@OneToOne(mappedBy = "thietBi")
	@JoinColumn(name = "ma_bo")
	private CowEntity bo;

	/**
	 * @return the maTb
	 */
	public String getMaTb() {
		return maTb;
	}

	/**
	 * @param maTb the maTb to set
	 */
	public void setMaTb(String maTb) {
		this.maTb = maTb;
	}

	/**
	 * @return the tenTb
	 */
	public String getTenTb() {
		return tenTb;
	}

	/**
	 * @param tenTb the tenTb to set
	 */
	public void setTenTb(String tenTb) {
		this.tenTb = tenTb;
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
	 * @return the moTa
	 */
	public String getMoTa() {
		return moTa;
	}

	/**
	 * @param moTa the moTa to set
	 */
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	/**
	 * @return the nhaCungCap
	 */
	public String getNhaCungCap() {
		return nhaCungCap;
	}

	/**
	 * @param nhaCungCap the nhaCungCap to set
	 */
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	/**
	 * @return the ngayNhap
	 */
	public Timestamp getNgayNhap() {
		return ngayNhap;
	}

	/**
	 * @param ngayNhap the ngayNhap to set
	 */
	public void setNgayNhap(Timestamp ngayNhap) {
		this.ngayNhap = ngayNhap;
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
	 * @return the bo
	 */
	public CowEntity getBo() {
		return bo;
	}

	/**
	 * @param bo the bo to set
	 */
	public void setBo(CowEntity bo) {
		this.bo = bo;
	}
	
	

}
