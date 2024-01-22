package com.koylumuhendis.atmproject.dto;

import com.koylumuhendis.atmproject.models.Admin;

public class CreateUserRequest {

	private String username;
	private String password;
	private Admin admin;
	public CreateUserRequest() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
