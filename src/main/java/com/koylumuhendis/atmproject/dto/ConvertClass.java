package com.koylumuhendis.atmproject.dto;

import org.springframework.stereotype.Component;

import com.koylumuhendis.atmproject.models.User;

@Component
public class ConvertClass {
	
	public UserDto convert(User user) {
		return new UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.createTime(user.getCreateTime())
				.updateTime(user.getUpdateTime())
				.balance(user.getBalance())
				.userIban(user.getUserIban())
				.build();
	}

	public User convert(CreateUserRequest request) {
		return new User.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.admin(request.getAdmin())
				.balance(0.0)
				.userIban(123456L)
				.build();
	}
}
