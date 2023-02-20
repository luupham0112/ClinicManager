package com.phanmemquanly.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 
public class UserDto implements Serializable {
	@NotEmpty
	@Length(min=5)
	private String userName;
	@NotEmpty
	@Length(min=4)
	private String passWord;
	
	private String hotenTk;
	
	private String sdt;
	@Email
	private String email;
	
	private String anhTk;

	public UserDto() {
		
	}

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
