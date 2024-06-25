package com.cashrich.dto;

public class LoginDTO {

	public String userName;
	public String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public LoginDTO() {
	}
	
}
