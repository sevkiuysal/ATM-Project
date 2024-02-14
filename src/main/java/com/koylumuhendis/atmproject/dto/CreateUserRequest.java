package com.koylumuhendis.atmproject.dto;

import com.koylumuhendis.atmproject.model.Admin;

public class CreateUserRequest {

	private String username;
	private String password;
	private Long adminId;
	public CreateUserRequest() {
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Long getAdminId() {
		return adminId;
	}
	
	public static class builder {
		private String username;
		private String password;
		private Long adminId;
		
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		public builder adminId(Long adminId) {
			this.adminId=adminId;
			return this;
		}
		
		public CreateUserRequest build() {
			return new CreateUserRequest(this);
		}
	}
	public CreateUserRequest(builder builder) {
		this.adminId=builder.adminId;
		this.username=builder.username;
		this.password=builder.password;
	}

}
