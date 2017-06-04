package com.example.cowmanager.entity;

import java.sql.Timestamp;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class CageLogEntity extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4387314388930957232L;

	@OneToMany
	@JoinColumn(name="maChuong")
	private CageEntity chuong;
	
	private Timestamp ngayDon;

	/**
	 * @return the chuong
	 */
	public CageEntity getChuong() {
		return chuong;
	}

	/**
	 * @param chuong the chuong to set
	 */
	public void setChuong(CageEntity chuong) {
		this.chuong = chuong;
	}

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
	
	
}
