package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tiepnhans")

public class TiepNhan implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTiepNhan;
	@Temporal(TemporalType.DATE)
	private Date ngayTN;
	@Temporal(TemporalType.TIME)
	private Time gio;
	@Column(columnDefinition = "nvarchar(100)")
	private String doituongKB;
	@Column(columnDefinition = "nvarchar(100)")
	private String soBHYT;
	@Column(columnDefinition = "nvarchar(100)")
	private String donVi;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(columnDefinition = "nvarchar(100)")
	private String kham;
	@Column(nullable=false)
	private int phongKham;
	@Column(nullable=false)
	private double tongTien;
	@Column(nullable=false)
	private int trangThai;
	
	@ManyToOne
	@JoinColumn(name="idBenhNhan")
	private Patient patient;
	
	

}
