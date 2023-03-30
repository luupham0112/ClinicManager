package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tiepnhans")

public class TiepNhan implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTiepNhan;
	@Temporal(TemporalType.DATE)
	private Date ngayTN;
	@Temporal(TemporalType.TIME)
	private Time gio;
	@Column(nullable=false)
	private int doituongKB;
	@Column(columnDefinition = "nvarchar(100)")
	private String soBHYT;
	@Column(columnDefinition = "nvarchar(100)")
	private String donVi;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(nullable=false)
	private int kham;
	@Column(nullable=false)
	private int phongKham;
	@Column(nullable=false)
	private double tongTien;
	@Column(nullable=false)
	private int trangThai;
	
	@ManyToOne
	@JoinColumn(name="idBenhNhan")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="idService")
	private ServiceExam service_exam;

	
	
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

	public ServiceExam getService_exam() {
		return service_exam;
	}

	public void setService_exam(ServiceExam service_exam) {
		this.service_exam = service_exam;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	

}
