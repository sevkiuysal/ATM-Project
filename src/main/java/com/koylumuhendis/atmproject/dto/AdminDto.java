package com.koylumuhendis.atmproject.dto;

public class AdminDto {
	
	private Long id;

	private String username;
	
	private String password;

	public AdminDto() {
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public static class builder{
		private Long id;

		private String username;
		
		private String password;
		
		public builder id(Long id) {
			this.id=id;
			return this;
		}
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		public AdminDto build() {
			return new AdminDto(this);
		}
	}
	
	public AdminDto(builder builder) {
		this.id=builder.id;
		this.username=builder.username;
		this.password=builder.password;
	}
}
