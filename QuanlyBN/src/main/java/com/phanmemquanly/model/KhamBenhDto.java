package com.phanmemquanly.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhamBenhDto implements Serializable {
	private int idKhamBenh;
	
	private float canNang;
	
	private float mach;
	
	private float nhipTho;
	
	private float huyetAp;
	
	private float nhietdo;
	
	private String khamTim;
	
	private String khamPhoi;
	
	private String khamBung;
	
	private String khamThan;
	
	private String chuanDoan;
	
	private String bacSi;
	
	private String dudieukien;
	
	private int idBenhNhan;

}
