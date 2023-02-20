package com.phanmemquanly.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TiepNhanDto implements Serializable {
	
	private int idTiepNhan;
	
	private Date ngayTN;
	
	private Time gio;
	
	private String doituongKB;
	
	private String soBHYT;
	
	private String donVi;
	
	private Date startDate;
	
	private Date endDate;
	
	private String kham;
	
	private int phongKham;
	
	private double tongTien;
	
	private int trangThai;

	private int idBenhNhan;
	
	
	

}
