package com.koylumuhendis.atmproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/allusers/{id}")
	public ResponseEntity<List<UserDto>> getAllUsersById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(adminService.getAllUserByAdminId(id));
	}
}
