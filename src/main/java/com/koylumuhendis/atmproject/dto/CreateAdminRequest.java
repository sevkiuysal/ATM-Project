package com.koylumuhendis.atmproject.dto;

import com.koylumuhendis.atmproject.dto.CreateUserRequest.builder;
import com.koylumuhendis.atmproject.models.Admin;

public class CreateAdminRequest {

	private String username;
	
	private String password;

	public CreateAdminRequest() {
	}

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	public static class builder {
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
		
		public CreateAdminRequest build() {
			return new CreateAdminRequest(this);
		}
	}
	public CreateAdminRequest(builder builder) {
		this.username=builder.username;
		this.password=builder.password;
	}

	
	
}
