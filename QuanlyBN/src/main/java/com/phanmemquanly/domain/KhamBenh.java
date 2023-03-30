package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "khambenhs")
public class KhamBenh implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idKhamBenh;
	@Column(nullable=false)
	private float canNang;
	@Column(nullable=false)
	private float mach;
	@Column(nullable=false)
	private float nhipTho;
	@Column(nullable=false)
	private float huyetAp;
	@Column(nullable=false)
	private float nhietdo;
	
	private String chuanDoan;
	@Column(columnDefinition = "nvarchar(100)")
	private String bacSi;
	private String tiensu;
	private String diung;
	
	@Temporal(TemporalType.DATE)
	private Date ngayTK;
	@Temporal(TemporalType.DATE)
	private Date ngayKB;
	private String tuanhoan;
	private String hohap;
	private String tieuhoa;
	private String than;
	private String coxuong;
	private String thankinh;
	private String tamthan;
	private String khac;
	
	private String ketqua1;
	private String ketqua2;
	private String ketqua3;
	private String ketqua4;
	private String ketqua5;
	private String ketqua6;
	private String huongDT;
	
	public Date getNgayKB() {
		return ngayKB;
	}

	public void setNgayKB(Date ngayKB) {
		this.ngayKB = ngayKB;
	}

	@ManyToOne
	@JoinColumn(name="idBenhNhan",referencedColumnName="idBenhNhan")
	private Patient patient;
	
	public int getIdKhamBenh() {
		return idKhamBenh;
	}

	
	public Date getNgayTK() {
		return ngayTK;
	}

	public void setNgayTK(Date ngayTK) {
		this.ngayTK = ngayTK;
	}

	public void setIdKhamBenh(int idKhamBenh) {
		this.idKhamBenh = idKhamBenh;
	}

	public float getCanNang() {
		return canNang;
	}

	public void setCanNang(float canNang) {
		this.canNang = canNang;
	}

	public float getMach() {
		return mach;
	}

	public void setMach(float mach) {
		this.mach = mach;
	}

	public float getNhipTho() {
		return nhipTho;
	}

	public void setNhipTho(float nhipTho) {
		this.nhipTho = nhipTho;
	}

	public float getHuyetAp() {
		return huyetAp;
	}

	public void setHuyetAp(float huyetAp) {
		this.huyetAp = huyetAp;
	}

	public float getNhietdo() {
		return nhietdo;
	}

	public void setNhietdo(float nhietdo) {
		this.nhietdo = nhietdo;
	}

	public String getTiensu() {
		return tiensu;
	}

	public void setTiensu(String tiensu) {
		this.tiensu = tiensu;
	}

	public String getDiung() {
		return diung;
	}

	public void setDiung(String diung) {
		this.diung = diung;
	}

	public String getChuanDoan() {
		return chuanDoan;
	}

	public void setChuanDoan(String chuanDoan) {
		this.chuanDoan = chuanDoan;
	}

	public String getBacSi() {
		return bacSi;
	}

	public void setBacSi(String bacSi) {
		this.bacSi = bacSi;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTuanhoan() {
		return tuanhoan;
	}

	public void setTuanhoan(String tuanhoan) {
		this.tuanhoan = tuanhoan;
	}

	public String getHohap() {
		return hohap;
	}

	public void setHohap(String hohap) {
		this.hohap = hohap;
	}

	public String getTieuhoa() {
		return tieuhoa;
	}

	public void setTieuhoa(String tieuhoa) {
		this.tieuhoa = tieuhoa;
	}

	public String getThan() {
		return than;
	}

	public void setThan(String than) {
		this.than = than;
	}

	public String getCoxuong() {
		return coxuong;
	}

	public void setCoxuong(String coxuong) {
		this.coxuong = coxuong;
	}

	public String getThankinh() {
		return thankinh;
	}

	public void setThankinh(String thankinh) {
		this.thankinh = thankinh;
	}

	public String getTamthan() {
		return tamthan;
	}

	public void setTamthan(String tamthan) {
		this.tamthan = tamthan;
	}

	public String getKhac() {
		return khac;
	}

	public void setKhac(String khac) {
		this.khac = khac;
	}

	public String getKetqua1() {
		return ketqua1;
	}

	public void setKetqua1(String ketqua1) {
		this.ketqua1 = ketqua1;
	}

	public String getKetqua2() {
		return ketqua2;
	}

	public void setKetqua2(String ketqua2) {
		this.ketqua2 = ketqua2;
	}

	public String getKetqua3() {
		return ketqua3;
	}

	public void setKetqua3(String ketqua3) {
		this.ketqua3 = ketqua3;
	}

	public String getKetqua4() {
		return ketqua4;
	}

	public void setKetqua4(String ketqua4) {
		this.ketqua4 = ketqua4;
	}

	public String getKetqua5() {
		return ketqua5;
	}

	public void setKetqua5(String ketqua5) {
		this.ketqua5 = ketqua5;
	}

	public String getKetqua6() {
		return ketqua6;
	}

	public void setKetqua6(String ketqua6) {
		this.ketqua6 = ketqua6;
	}

	public String getHuongDT() {
		return huongDT;
	}

	public void setHuongDT(String huongDT) {
		this.huongDT = huongDT;
	}

	
}
