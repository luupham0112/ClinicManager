package com.phanmemquanly.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "donthuocs")
public class Donthuoc  implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_donthuoc")
	private int idDonthuoc;
	@Column(nullable=false)
	private double tongtien;	
	private String number;
	private String status;
	

	private String bacsi;
  
	private Date ngayTao;
   
	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date date) {
		this.ngayTao = date;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idBenhNhan",referencedColumnName="idBenhNhan")
	private Patient patient;
	
	@OneToMany(mappedBy = "donthuoc", fetch = FetchType.LAZY )
	List<DonthuocDetail> donthuocDetails = new ArrayList<DonthuocDetail>();

	
	public List<DonthuocDetail> getDonthuocDetails() {
		return donthuocDetails;
	}

	public void setDonthuocDetails(List<DonthuocDetail> donthuocDetails) {
		this.donthuocDetails = donthuocDetails;
	}


	public int getIdDonthuoc() {
		return idDonthuoc;
	}

	public void setIdDonthuoc(int idDonthuoc) {
		this.idDonthuoc = idDonthuoc;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getBacsi() {
		return bacsi;
	}

	public void setBacsi(String bacsi) {
		this.bacsi = bacsi;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


    
	
}

