package com.phanmemquanly.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {
	
	private int idBenhNhan;	
	@NotEmpty
	private String hotenBN;
	@Length(min=9)
	private String CCCD;
	@NotNull
	private Date ngaysinh;
	
	private int gioiTinh;
	@Min(0)
	private int tuoi;
	
	private String diaChi;
	private Boolean isEdit=false;
	private String queQuan;
	private String ngheNghiep;
	
	List<DonthuocDto> donthuocDtos= new ArrayList<>();
	
	
	

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
	
	
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	

}
