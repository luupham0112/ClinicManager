package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "patients")
public class Patient implements Serializable  {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idBenhNhan;
	@Column(columnDefinition = "nvarchar(100)")
	private String hotenBN;
	@Column(columnDefinition = "nvarchar(100)")
	private String CCCD;
	@Column(columnDefinition = "nvarchar(100)")
	private Date ngaysinh;
	@Column(nullable=false)
	private int gioiTinh;
	@Column(nullable=false)
	private int tuoi;
	@Column(nullable=false)
	private String queQuan;
	private String ngheNghiep;
	

	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getNgheNghiep() {
		return ngheNghiep;
	}
	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;
	
	
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
	private Set<KhamBenh> khamBenhs;
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
	private Set<TiepNhan> tiepNhans;
	
	// don thuoc
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	List<Donthuoc> donthuoc = new ArrayList<Donthuoc>();
	//
	
	
	public int getIdBenhNhan() {
		return idBenhNhan;
	}
	public void setIdBenhNhan(int idBenhNhan) {
		this.idBenhNhan = idBenhNhan;
	}
	public String getHotenBN() {
		return hotenBN;
	}
	public void setHotenBN(String hotenBN) {
		this.hotenBN = hotenBN;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public Set<KhamBenh> getKhamBenhs() {
		return khamBenhs;
	}
	public void setKhamBenhs(Set<KhamBenh> khamBenhs) {
		this.khamBenhs = khamBenhs;
	}
	public Set<TiepNhan> getTiepNhans() {
		return tiepNhans;
	}
	public void setTiepNhans(Set<TiepNhan> tiepNhans) {
		this.tiepNhans = tiepNhans;
	}
//	
	
}
