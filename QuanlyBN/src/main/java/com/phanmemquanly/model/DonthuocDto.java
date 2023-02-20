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
	private String bacsi;
	private Date ngayTK;
	private double tongtien;
	private int idBenhNhan;
}
