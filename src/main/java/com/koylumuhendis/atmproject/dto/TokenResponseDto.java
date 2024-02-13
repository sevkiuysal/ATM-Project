package com.koylumuhendis.atmproject.dto;

public class TokenResponseDto {
	
	private String accessToken;
	
	private UserDto userDto;
	
	private AdminDto adminDto;


	public TokenResponseDto(String accessToken, UserDto userDto) {
		this.accessToken = accessToken;
		this.userDto = userDto;
	}
	
	public TokenResponseDto(String accessToken, AdminDto adminDto) {
		this.accessToken = accessToken;
		this.adminDto = adminDto;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public AdminDto getAdminDto() {
		return adminDto;
	}

	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}


}
