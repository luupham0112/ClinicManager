package com.phanmemquanly.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "service_exams")
public class ServiceExam {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idService;
	private String nameService;
	private int money;
	
	@OneToMany(mappedBy="service_exam", cascade = CascadeType.ALL)
	private Set<TiepNhan> tiepNhans;

	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Set<TiepNhan> getTiepNhans() {
		return tiepNhans;
	}

	public void setTiepNhans(Set<TiepNhan> tiepNhans) {
		this.tiepNhans = tiepNhans;
	}
	

}
