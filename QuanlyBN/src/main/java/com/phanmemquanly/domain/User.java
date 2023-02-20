package com.phanmemquanly.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users")
public class User implements Serializable {
	@Id
	@Column(length= 30)
	private String userName;
	@Column(length= 20, nullable=false)
	private String passWord;
	@Column(columnDefinition = "nvarchar(100)")
	private String hotenTk;
	@Column(columnDefinition = "nvarchar(50)")
	private String sdt;
	@Column(columnDefinition = "nvarchar(50)")
	private String email;
	@Column(columnDefinition = "nvarchar(50)")
	private String anhTk;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getHotenTk() {
		return hotenTk;
	}
	public void setHotenTk(String hotenTk) {
		this.hotenTk = hotenTk;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnhTk() {
		return anhTk;
	}
	public void setAnhTk(String anhTk) {
		this.anhTk = anhTk;
	}
	
	
}
