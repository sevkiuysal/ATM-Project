package com.koylumuhendis.atmproject.dto;

public class LoginRequest {

	private String username;
	
	private String password;

	public LoginRequest() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public static class builder{
		private String username;
		
		private String password;
		
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		public LoginRequest build() {
			return new LoginRequest(this);
		}
	}
	
	public LoginRequest(builder builder) {
		this.username=builder.username;
		this.password=builder.password;
	}
} 
