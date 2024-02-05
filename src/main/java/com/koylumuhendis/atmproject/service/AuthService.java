package com.koylumuhendis.atmproject.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.koylumuhendis.atmproject.dto.LoginRequest;
import com.koylumuhendis.atmproject.dto.TokenResponseDto;
import com.koylumuhendis.atmproject.model.Role;
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
	
	public TokenResponseDto loginUser(LoginRequest request) {
		try {
		
			Authentication authentication=authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			TokenResponseDto responseDto=null;
			if(request.getRole()==Role.USER) {
				responseDto=new TokenResponseDto(
					generator.generateToken(authentication), userService.getUserByName(request.getUsername())
					);
			}else if(request.getRole()==Role.ADMIN) {
				responseDto=new TokenResponseDto(
						generator.generateToken(authentication), adminService.getAdminByName(request.getUsername())
						);
			}
			
			return responseDto;
		}catch (Exception e) {
			throw new UsernameNotFoundException("User not found given request.");
		}
	}
	

}
