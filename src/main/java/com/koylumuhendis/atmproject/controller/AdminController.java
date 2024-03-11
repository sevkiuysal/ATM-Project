package com.koylumuhendis.atmproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koylumuhendis.atmproject.dto.AdminDto;
import com.koylumuhendis.atmproject.dto.CreateAdminRequest;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.service.AdminService;


	
@RestController
@RequestMapping(value = "api/v1/admin")
public class AdminController {
	
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//http://localhost:8080/admin/create
	@PostMapping("/create")
	public ResponseEntity<AdminDto> saveAdmin(@RequestBody CreateAdminRequest request){
		return ResponseEntity.ok()
				.body(adminService.saveAdmin(request));
	}
	//http://localhost:8080/admin/getAllUsers/4
	@GetMapping("/getAllUsers/{id}")
	public ResponseEntity<List<UserDto>> getAllUsers(@PathVariable("id")Long id){
		return ResponseEntity.ok()
				.body(adminService.getUsersByAdminId(id));
	}
	
}
