package com.koylumuhendis.atmproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
//	
//	@PutMapping("/addmoney/{id}")
//	public ResponseEntity<UserDto> addMoney(@PathVariable("id") Long id,@RequestBody Double money){
//		return ResponseEntity
//				.status(HttpStatus.OK)
//				.body(userService.addMoney(id,money).orElseThrow());
//	}

}
