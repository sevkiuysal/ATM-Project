package com.koylumuhendis.atmproject.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.koylumuhendis.atmproject.dto.ConvertClass;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.repository.AdminRepository;

@Service
public class AdminService {
	
	private AdminRepository adminRepository;
	
	private ConvertClass convertClass;

	public AdminService(AdminRepository adminRepository,ConvertClass convertClass) {
		this.adminRepository = adminRepository;
		this.convertClass=convertClass;
	}
	
	public List<UserDto> getAllUserByAdminId(Long id){
		return adminRepository.findUserById(id).stream()
				.map(user -> convertClass.convert(user)).collect(Collectors.toList());
	}
}
