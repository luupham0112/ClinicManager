package com.phanmemquanly.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {
	@NotEmpty
	private int idBenhNhan;	
	private String hotenBN;
	private String CCCD;
	private Date ngaysinh;
	private int gioiTinh;
	private int tuoi;
	private int doituong;
	private String diaChi;
	private Boolean isEdit=false;
	
	 
	public PatientDto() {
		
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
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
	
	public int getDoituong() {
		return doituong;
	}
	public void setDoituong(int doituong) {
		this.doituong = doituong;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	

}
