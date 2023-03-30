package com.phanmemquanly.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonthuocDto   implements Serializable{
	private int idDonthuoc;
	
	private double tongtien;
	
    private String bacsi;
    private String ngayTao;
    private String number;
    private String status;
   
	private PatientDto patientDto;
    private DonthuocDetailDto donthuocDetailDto;
    private DonthuocDetailDto[] donthuocDetailDtos;
    public String getBacsi() {
		return bacsi;
	}
	public void setBacsi(String bacsi) {
		this.bacsi = bacsi;
	}
	
	public String getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}
	public PatientDto getPatientDto() {
		return patientDto;
	}
	public void setPatientDto(PatientDto patientDto) {
		this.patientDto = patientDto;
	}
	public DonthuocDetailDto getDonthuocDetailDto() {
		return donthuocDetailDto;
	}
	public void setDonthuocDetailDto(DonthuocDetailDto donthuocDetailDto) {
		this.donthuocDetailDto = donthuocDetailDto;
	}
	public DonthuocDetailDto[] getDonthuocDetailDtos() {
		return donthuocDetailDtos;
	}
	public void setDonthuocDetailDtos(DonthuocDetailDto[] donthuocDetailDtos) {
		this.donthuocDetailDtos = donthuocDetailDtos;
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
