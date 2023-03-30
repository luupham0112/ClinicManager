package com.phanmemquanly.model;



import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements Serializable{
	@NotEmpty
	private String userName;
	@NotEmpty
	private String passWord;
	private boolean rememberMe = false;
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
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	

}
