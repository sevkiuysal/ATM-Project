package com.koylumuhendis.atmproject.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.koylumuhendis.atmproject.dto.AdminDto;
import com.koylumuhendis.atmproject.dto.CreateAdminRequest;
import com.koylumuhendis.atmproject.dto.CreateUserRequest;
import com.koylumuhendis.atmproject.models.Admin;
import com.koylumuhendis.atmproject.service.AdminService;
import com.koylumuhendis.atmproject.service.UserService;

@Component
public class StartupConfig implements CommandLineRunner {

	private final UserService service;
	
	private final AdminService adminService;
	
	
	public StartupConfig(UserService service,AdminService adminService) {
		this.service = service;
		this.adminService=adminService;
	}


	@Override
	public void run(String... args) throws Exception {
//		AdminDto adminDto= adminService.saveAdmin(new CreateAdminRequest.builder()
//				.username("admin")
//				.password("password")
//				.build());
//		Admin admin=new Admin.builder()
//				.id(adminDto.getId())
//				.username(adminDto.getUsername())
//				.password(adminDto.getPassword())
//				.build();
//		service.saveUser(new CreateUserRequest.builder()
//				.username("username")
//				.password("password")
//				.admin(admin)
//				.build());
//		
	}

}
