package com.example.cowmanager.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class CowEntity extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1674396598743694564L;

	private String maBo;

	private String dacDiem;

	private Timestamp ngayNhap;

	@OneToOne
	@JoinColumn(name = "ma_chuong")
	private CageEntity chuong;

	@OneToOne
	@JoinColumn(name = "ma_nhan_vien")
	private EmployeeEntity nhanVien;

	private Integer benhTat;

	private Timestamp ngayCapNhat;

	private Timestamp ngayTao;

	@OneToOne
	@JoinColumn(name = "ma_thiet_bi")
	private DeviceEntity thietBi;
	
	@OneToMany(mappedBy="bo")
	private List<MilkingProcessEntity> lichVatSua;
	
	@OneToMany(mappedBy="bo")
	private List<CowLogEntity> theoDoiSucKhoe;
	/**
	 * @return the maBo
	 */
	public String getMaBo() {
		return maBo;
	}

	/**
	 * @param maBo
	 *            the maBo to set
	 */
	public void setMaBo(String maBo) {
		this.maBo = maBo;
	}

	/**
	 * @return the dacDiem
	 */
	public String getDacDiem() {
		return dacDiem;
	}

	/**
	 * @param dacDiem
	 *            the dacDiem to set
	 */
	public void setDacDiem(String dacDiem) {
		this.dacDiem = dacDiem;
	}

	/**
	 * @return the ngayNhap
	 */
	public Timestamp getNgayNhap() {
		return ngayNhap;
	}

	/**
	 * @param ngayNhap
	 *            the ngayNhap to set
	 */
	public void setNgayNhap(Timestamp ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	/**
	 * @return the chuong
	 */
	public CageEntity getChuong() {
		return chuong;
	}

	/**
	 * @param chuong
	 *            the chuong to set
	 */
	public void setChuong(CageEntity chuong) {
		this.chuong = chuong;
	}

	/**
	 * @return the nhanVien
	 */
	public EmployeeEntity getNhanVien() {
		return nhanVien;
	}

	/**
	 * @param nhanVien
	 *            the nhanVien to set
	 */
	public void setNhanVien(EmployeeEntity nhanVien) {
		this.nhanVien = nhanVien;
	}

	/**
	 * @return the benhTat
	 */
	public Integer getBenhTat() {
		return benhTat;
	}

	/**
	 * @param benhTat
	 *            the benhTat to set
	 */
	public void setBenhTat(Integer benhTat) {
		this.benhTat = benhTat;
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
	 * @return the thietBi
	 */
	public DeviceEntity getThietBi() {
		return thietBi;
	}

	/**
	 * @param thietBi the thietBi to set
	 */
	public void setThietBi(DeviceEntity thietBi) {
		this.thietBi = thietBi;
	}

	/**
	 * @return the lichVatSua
	 */
	public List<MilkingProcessEntity> getLichVatSua() {
		return lichVatSua;
	}

	/**
	 * @param lichVatSua the lichVatSua to set
	 */
	public void setLichVatSua(List<MilkingProcessEntity> lichVatSua) {
		this.lichVatSua = lichVatSua;
	}

	/**
	 * @return the theoDoiSucKhoe
	 */
	public List<CowLogEntity> getTheoDoiSucKhoe() {
		return theoDoiSucKhoe;
	}

	/**
	 * @param theoDoiSucKhoe the theoDoiSucKhoe to set
	 */
	public void setTheoDoiSucKhoe(List<CowLogEntity> theoDoiSucKhoe) {
		this.theoDoiSucKhoe = theoDoiSucKhoe;
	}

	
}
