package com.koylumuhendis.atmproject.request;


import com.koylumuhendis.atmproject.model.Role;

public class LoginRequest {
	
private String username;
	
	private String password;
	
	private Role role;

	public LoginRequest() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public Enum getRole() {
		return role;
	}
	
	public static class builder{
		private String username;
		
		private String password;
		
		private Role role;
		
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		
		public builder role(Role role) {
			this.role=role;
			return this;
		}
		public LoginRequest build() {
			return new LoginRequest(this);
		}
	}
	
	public LoginRequest(builder builder) {
		this.username=builder.username;
		this.password=builder.password;
		this.role=builder.role;
	}
	
	

}
