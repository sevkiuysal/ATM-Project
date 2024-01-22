package com.koylumuhendis.atmproject.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.koylumuhendis.atmproject.dto.CreateUserRequest;
import com.koylumuhendis.atmproject.dto.ConvertClass;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.exception.InsufficientBalanceException;
import com.koylumuhendis.atmproject.exception.UserNotFoundException;
import com.koylumuhendis.atmproject.models.User;
import com.koylumuhendis.atmproject.repository.UserRepository;

@Service
public class UserService extends Thread {
	
	private UserRepository userRepository;
	private ConvertClass convertUserDto;

	public UserService(UserRepository userRepository,ConvertClass convertUserDto) {
		this.userRepository = userRepository;
		this.convertUserDto = convertUserDto;
	}

	public UserDto saveUser(CreateUserRequest request) {
		
		return convert(userRepository.save(convertUserDto.convert(request)));
	}
		
	public UserDto addMoney(Long id,Double money) {
		UserDto userDto=findUserbyId(id);
		money=userDto.getBalance()+money;
		userRepository.updateBalanceById(id, money);
		userDto=findUserbyId(id);
		return userDto;
	}
	
	public Optional<UserDto> drawMoney(Long id,Double money) {
		UserDto userDto=findUserbyId(id);
		money=userDto.getBalance()-money;
		if(money<=0) {
			return Optional.ofNullable(userDto);
		}else {
		userRepository.updateBalanceById(id ,money);
		userDto=findUserbyId(id);
		return Optional.of(userDto);
		}
	}
	
	public Optional<UserDto> sendMoney(Long id,Double money,Long userIban) {
		UserDto sender=findUserbyId(id);
		UserDto recipient=findUserbyIban(userIban);
		
		Double balance=money;  
		
		balance=sender.getBalance()-balance;
		if(balance<=0) {
			throw (new InsufficientBalanceException());
		}else
		userRepository.updateBalanceById(id, balance);

		money=recipient.getBalance()+money;
		userRepository.updateBalanceByUserIban(userIban, money);
		
		sender=findUserbyId(id);
		return Optional.of(sender);
	}
	
	public UserDto findUserbyId(Long id) {
		return convert(userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id)));
	}
	
	private UserDto findUserbyIban(Long iban) {
		return convert(userRepository.findByUserIban(iban).orElseThrow(()->new UserNotFoundException(iban)));
	}
	private UserDto convert(User user) {
		return convertUserDto.convert(user);
	}



	
	

	
	

}
