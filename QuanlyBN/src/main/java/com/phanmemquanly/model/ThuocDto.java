package com.phanmemquanly.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThuocDto  implements Serializable {
	private int idThuoc;
	
	private String nameThuoc;
	
	private String loaiThuoc;

	private String donvi;
	
	private int soluong;
	
	private double dongia;
	private String dangThuoc;
	private String dongGoi;
	private String phuongThuc;
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

	private Boolean isEdit=false;
	
	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}


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
