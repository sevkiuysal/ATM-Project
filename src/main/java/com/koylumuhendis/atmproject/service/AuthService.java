package com.koylumuhendis.atmproject.service;

import org.springframework.security.authentication.AuthenticationManager;

import com.koylumuhendis.atmproject.utils.TokenGenerator;

public class AuthService {
	
	private final AuthenticationManager authenticationManager;
	
	private final AdminService adminService;
	
	private final UserService userService;
	
	private final TokenGenerator generator;

	public AuthService(AuthenticationManager authenticationManager, AdminService adminService, UserService userService,
			TokenGenerator generator) {
		this.authenticationManager = authenticationManager;
		this.adminService = adminService;
		this.userService = userService;
		this.generator = generator;
	}
	

}
