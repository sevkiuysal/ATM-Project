package com.koylumuhendis.atmproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public Optional<UserDto> addMoney(Long id,Double money) {
		
		return userRepository.updateCreditbyId(id ,money);
	}
	
	

}
