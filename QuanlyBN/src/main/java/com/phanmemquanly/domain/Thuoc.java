package com.phanmemquanly.domain;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "thuocs")
public class Thuoc  implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idThuoc;
	@Column(columnDefinition = "nvarchar(100)")
	private String nameThuoc;
	@Column(columnDefinition = "nvarchar(100)")
	private String loaiThuoc;
	@Column(columnDefinition = "nvarchar(100)")
	private String donvi;
	@Column(nullable=false)
	private int soluong;
	@Column(nullable=false)
	private double dongia;
	@Column(columnDefinition = "nvarchar(100)")
	private String dangThuoc;
	@Column(columnDefinition = "nvarchar(100)")
	private String dongGoi;
	@Column(columnDefinition = "nvarchar(100)")
	private String phuongThuc;
	@Column(nullable=false)
	private int thuocNgoai;
	
	public String getDangThuoc() {
		return dangThuoc;
	}
	public void setDangThuoc(String dangThuoc) {
		this.dangThuoc = dangThuoc;
	}
	public String getDongGoi() {
		return dongGoi;
	}
	public void setDongGoi(String dongGoi) {
		this.dongGoi = dongGoi;
	}
	public String getPhuongThuc() {
		return phuongThuc;
	}
	public void setPhuongThuc(String phuongThuc) {
		this.phuongThuc = phuongThuc;
	}
	public int getThuocNgoai() {
		return thuocNgoai;
	}
	public void setThuocNgoai(int thuocNgoai) {
		this.thuocNgoai = thuocNgoai;
	}
	public Set<DonthuocDetail> getDonthuocDetails() {
		return donthuocDetails;
	}
	public void setDonthuocDetails(Set<DonthuocDetail> donthuocDetails) {
		this.donthuocDetails = donthuocDetails;
	}
	
	
	
	@OneToMany(mappedBy = "thuoc", cascade = CascadeType.ALL)
	private Set<DonthuocDetail> donthuocDetails;
	
	public int getIdThuoc() {
		return idThuoc;
	}
	public void setIdThuoc(int idThuoc) {
		this.idThuoc = idThuoc;
	}
	public String getNameThuoc() {
		return nameThuoc;
	}
	public void setNameThuoc(String nameThuoc) {
		this.nameThuoc = nameThuoc;
	}
	public String getLoaiThuoc() {
		return loaiThuoc;
	}
	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}
	public String getDonvi() {
		return donvi;
	}
	public void setDonvi(String donvi) {
		this.donvi = donvi;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	
	

}
