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
@Table(name = "nhapkhochitiet")
public class NhapkhoChitiet implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idXuatkhoChitiet;
	@Column(nullable=false)
	private int soluong;
	
	@ManyToOne
	@JoinColumn(name="idThuoc")
	private Thuoc thuoc;
	
	@ManyToOne
	@JoinColumn(name="idPhieunhap")
	private NhapKho nhapKho;
	
	
}