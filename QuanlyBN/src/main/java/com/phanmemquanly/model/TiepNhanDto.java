package com.phanmemquanly.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TiepNhanDto implements Serializable {
	
	private int idTiepNhan;
	
	private Date ngayTN;
	
	private Time gio;
	
	private int doituongKB;
	
	private String soBHYT;
	
	private String donVi;
	
	private Date startDate;
	
	private Date endDate;
	
	private int kham;
	
	private int phongKham;
	
	private double tongTien;
	
	private int trangThai=0;

	private int idBenhNhan;
	
	private int idService;
		



	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public int getIdTiepNhan() {
		return idTiepNhan;
	}

	public void setIdTiepNhan(int idTiepNhan) {
		this.idTiepNhan = idTiepNhan;
	}

	public Date getNgayTN() {
		return ngayTN;
	}

	public void setNgayTN(Date ngayTN) {
		this.ngayTN = ngayTN;
	}

	public Time getGio() {
		return gio;
	}

	public void setGio(Time gio) {
		this.gio = gio;
	}

	

	public String getSoBHYT() {
		return soBHYT;
	}

	public void setSoBHYT(String soBHYT) {
		this.soBHYT = soBHYT;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDoituongKB() {
		return doituongKB;
	}

	public void setDoituongKB(int doituongKB) {
		this.doituongKB = doituongKB;
	}

	public int getKham() {
		return kham;
	}

	public void setKham(int kham) {
		this.kham = kham;
	}

	public int getPhongKham() {
		return phongKham;
	}

	public void setPhongKham(int phongKham) {
		this.phongKham = phongKham;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getIdBenhNhan() {
		return idBenhNhan;
	}

	public void setIdBenhNhan(int idBenhNhan) {
		this.idBenhNhan = idBenhNhan;
	}
	
	
	
	
	
	

}
