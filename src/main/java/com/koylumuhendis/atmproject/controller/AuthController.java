package com.koylumuhendis.atmproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.koylumuhendis.atmproject.dto.TokenResponseDto;
import com.koylumuhendis.atmproject.request.LoginRequest;
import com.koylumuhendis.atmproject.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	//http://localhost:8080/api/v1/auth/login
	@PostMapping("/login")
	public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok().body(authService.login(loginRequest));
	}

}
