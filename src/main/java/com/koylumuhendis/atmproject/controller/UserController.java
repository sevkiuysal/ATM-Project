package com.koylumuhendis.atmproject.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koylumuhendis.atmproject.dto.CreateUserRequest;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//http://localhost:8080/user/create
	@PostMapping("/create")
	public ResponseEntity<UserDto> saveUser(@RequestBody CreateUserRequest request){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.saveUser(request));
	}
	
	//http://localhost:8080/user/{id}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable("id")Long id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findUserbyId(id));
	}
	
	//http://localhost:8080/user/addmoney/{id}
	@PutMapping("/addmoney/{id}")
	public ResponseEntity<UserDto> addMoney(@PathVariable("id") Long id,@RequestBody Double money){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.addMoney(id,money));
	}
	
	//http://localhost:8080/user/drawmoney/{id}
	@PutMapping("/drawmoney/{id}")
	public ResponseEntity<Optional<UserDto>> drawMoney(@PathVariable("id") Long id,@RequestBody Double money){		
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.drawMoney(id,money));
	}
	
	//http://localhost:8080/user/sendmoney/{id}/{iban}
	@PostMapping("/sendmoney/{id}/{iban}")
	public ResponseEntity<Optional<UserDto>> sendMoney(
			@PathVariable("id")Long id,
			@PathVariable("iban")Long iban,
			@RequestBody Double money){
		
		return ResponseEntity.ok()
				.body(userService.sendMoney(id, money, iban));
	}

}
