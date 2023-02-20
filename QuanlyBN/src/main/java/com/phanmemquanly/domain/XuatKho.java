package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "xuatkho")
public class XuatKho implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPhieuxuat;
	@Temporal(TemporalType.DATE)
	private Date ngayXuat;
	@Column(columnDefinition = "nvarchar(100)")
	private String nguoiXuat;
	@Column(columnDefinition = "nvarchar(100)")
	private String tenKH;
	@Column(nullable=false)
	private int namsinh;
	@Column(columnDefinition = "nvarchar(200)")
	private String diachi;
	@Column(columnDefinition = "nvarchar(100)")
	private String dienthoai;
}
