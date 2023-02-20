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
@Table(name = "nhapkhos")
public class NhapKho  implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPhieunhap;
	@Temporal(TemporalType.DATE)
	private Date ngayNhap;
	@Column(columnDefinition = "nvarchar(50)")
	private String nguoiNhap;

}
