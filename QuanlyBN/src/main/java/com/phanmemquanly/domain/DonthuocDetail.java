package com.phanmemquanly.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "donthuocdetail")
public class DonthuocDetail implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int  donthuocDetailId ;
	
	@Column(nullable=false)
	private int soluong;
	@Column(nullable=false)
	private double giatien;
	private double tongtien;
	

	@Column(columnDefinition = "nvarchar(200)")
	private String ghichu;
	@OneToOne
	@JoinColumn(name="idThuoc")
	private Thuoc thuoc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_donthuoc")
	private Donthuoc donthuoc;


	public double getGiatien() {
		return giatien;
	}

	public void setGiatien(double giatien) {
		this.giatien = giatien;
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


	public int getDonthuocDetailId() {
		return donthuocDetailId;
	}

	public void setDonthuocDetailId(int donthuocDetailId) {
		this.donthuocDetailId = donthuocDetailId;
	}

	public Thuoc getThuoc() {
		return thuoc;
	}

	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}

	public Donthuoc getDonthuoc() {
		return donthuoc;
	}

	public void setDonthuoc(Donthuoc donthuoc) {
		this.donthuoc = donthuoc;
	}
	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	

}
