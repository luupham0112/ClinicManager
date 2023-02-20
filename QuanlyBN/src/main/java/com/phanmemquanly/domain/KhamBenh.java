package com.phanmemquanly.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "khambenhs")
public class KhamBenh implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idKhamBenh;
	@Column(nullable=false)
	private float canNang;
	@Column(nullable=false)
	private float mach;
	@Column(nullable=false)
	private float nhipTho;
	@Column(nullable=false)
	private float huyetAp;
	@Column(nullable=false)
	private float nhietdo;
	@Column(columnDefinition = "nvarchar(500)")
	private String khamTim;
	@Column(columnDefinition = "nvarchar(500)")
	private String khamPhoi;
	@Column(columnDefinition = "nvarchar(500)")
	private String khamBung;
	@Column(columnDefinition = "nvarchar(500)")
	private String khamThan;
	@Column(columnDefinition = "nvarchar(500)")
	private String chuanDoan;
	@Column(columnDefinition = "nvarchar(100)")
	private String bacSi;
	@Column(columnDefinition = "nvarchar(10)  not null")
	private String dudieukien;
	
	@ManyToOne
	@JoinColumn(name="idBenhNhan")
	private Patient patient;
}
