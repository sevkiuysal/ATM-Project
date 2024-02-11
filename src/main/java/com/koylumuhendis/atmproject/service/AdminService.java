package com.koylumuhendis.atmproject.service;


import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koylumuhendis.atmproject.dto.AdminDto;
import com.koylumuhendis.atmproject.dto.ConvertClass;
import com.koylumuhendis.atmproject.dto.CreateAdminRequest;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.model.Admin;
import com.koylumuhendis.atmproject.model.User;
import com.koylumuhendis.atmproject.repository.AdminRepository;

@Service
public class AdminService {
	
	private AdminRepository adminRepository;
	
	private ConvertClass convert;

	public AdminService(AdminRepository adminRepository,ConvertClass convert) {
		this.adminRepository = adminRepository;
		this.convert=convert;
	}
	
	public AdminDto saveAdmin(CreateAdminRequest request) {
		return convert.AdminToDto(
				adminRepository.save(
						convert.CreateToAdmin(request)));

	}
	
	public AdminDto getAdminByName(String username) {
		Admin admin=adminRepository.findAdminByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("user not found given name !"));
		return convert.AdminToDto(admin);
		
	}
	
	public List<UserDto> getUsersByAdminId(Long id){
		List<User> users=adminRepository.getUsersByAdminId(id);
		for(User user:users) {
			System.out.println(user);
		}
		return convert.ListUserToDto(users);
	}
	
}
