package com.koylumuhendis.atmproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.koylumuhendis.atmproject.dto.ConvertClass;
import com.koylumuhendis.atmproject.dto.CreateUserRequest;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.exception.InsufficientBalanceException;
import com.koylumuhendis.atmproject.exception.UserNotFoundException;
import com.koylumuhendis.atmproject.model.User;
import com.koylumuhendis.atmproject.repository.UserRepository;

@Service
public class UserService extends Thread {
	
	private UserRepository userRepository;
	private ConvertClass convert;

	public UserService(UserRepository userRepository,ConvertClass convert) {
		this.userRepository = userRepository;
		this.convert = convert;
	}

	public UserDto saveUser(CreateUserRequest request) {
		
		return convertDto(
				userRepository.save(
						convert.CreateToUser(request)));
	}
	
	public UserDto getUserByName(String name) {
		
		return convertDto(userRepository.findUserByUsername(name));
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
		
		addMoney(recipient.getId(), money);
		
		sender=findUserbyId(id);
		
		return Optional.of(sender);
	}
	
	public UserDto findUserbyId(Long id) {
		return convertDto(userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id)));
	}
	
	public UserDto login(String username,String password) {
		return null;
	}
	private UserDto findUserbyIban(Long iban) {
		return convertDto(userRepository.findByUserIban(iban).orElseThrow(()->new UserNotFoundException(iban)));
	}
	private UserDto convertDto(User user) {
		return convert.UserToDto(user);
	}



	
	

	
	

}
