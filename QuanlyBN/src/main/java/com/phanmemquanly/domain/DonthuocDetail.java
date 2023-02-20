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
@Table(name = "donthuocdetail")
public class DonthuocDetail implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idDonthuocDetail;
//	@Column(nullable=false)
//	private int idDonthuoc;
//	@Column(nullable=false)
//	private int idThuoc;
	@Column(nullable=false)
	private int soluong;
	@Column(columnDefinition = "nvarchar(200)")
	private String ghichu;
	@Column(columnDefinition = "nvarchar(100)")
	private String nameThuoc;
	@Column(columnDefinition = "nvarchar(45)")
	private String donvi;
	@Column(columnDefinition = "nvarchar(45)")
	private String phuongthuc;
	
	@ManyToOne
	@JoinColumn(name="idThuoc")
	private Thuoc thuoc;
	
	@ManyToOne
	@JoinColumn(name="idDonthuoc")
	private Donthuoc donthuoc;

}
