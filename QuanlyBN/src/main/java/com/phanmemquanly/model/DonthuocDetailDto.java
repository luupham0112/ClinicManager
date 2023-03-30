package com.phanmemquanly.model;

import java.io.Serializable;

import com.phanmemquanly.domain.Thuoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonthuocDetailDto   implements Serializable {
	private int  donthuocDetailId ;
	
	private int soluong;
	private double giatien;
	private double tongtien;
	private String ghichu;
	private ThuocDto thuocdto;


	public ThuocDto getThuocdto() {
		return thuocdto;
	}
	public void setThuocdto(ThuocDto thuocdto) {
		this.thuocdto = thuocdto;
	}


	public double getGiatien() {
		return giatien;
	}

	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}

	
	public int getDonthuocDetailId() {
		return donthuocDetailId;
	}


	public void setDonthuocDetailId(int donthuocDetailId) {
		this.donthuocDetailId = donthuocDetailId;
	}


	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}


	public double getTongtien() {
		return tongtien;
	}


	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	
	

}
