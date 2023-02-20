package com.phanmemquanly.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "donthuocs")
public class Donthuoc  implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idDonthuoc;
	@Column(columnDefinition = "nvarchar(100)")
	private String bacsi;
	@Temporal(TemporalType.DATE)
	private Date ngayTK;
	@Column(nullable=false)
	private double tongtien;
//	@Column(nullable=false)
//	private int idBenhNhan;
	
	@ManyToOne
	@JoinColumn(name="idBenhNhan")
	private Patient patient;
	
	@OneToMany(mappedBy = "donthuoc", cascade = CascadeType.ALL )
	private Set<DonthuocDetail> donthuocDetails;
}

