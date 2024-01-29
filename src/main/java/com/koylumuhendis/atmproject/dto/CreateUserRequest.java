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
	
	public String getPassword() {
		return password;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public static class builder {
		private String username;
		private String password;
		private Admin admin;
		
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		public builder admin(Admin admin) {
			this.admin=admin;
			return this;
		}
		
		public CreateUserRequest build() {
			return new CreateUserRequest(this);
		}
	}
	public CreateUserRequest(builder builder) {
		this.admin=builder.admin;
		this.username=builder.username;
		this.password=builder.password;
	}

}
