package com.koylumuhendis.atmproject.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.koylumuhendis.atmproject.model.Admin;
import com.koylumuhendis.atmproject.model.User;

@Component
public class ConvertClass {
	
	public UserDto UserToDto(User user) {
		return new UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.createTime(user.getCreateTime())
				.updateTime(user.getUpdateTime())
				.balance(user.getBalance())
				.userIban(user.getUserIban())
				.build();
	}

	public User CreateToUser(CreateUserRequest request) {
		return new User.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.adminId(request.getAdminId())
				.balance(0.0)
				.userIban(123456L)
				.build();
	}
	
	public Admin CreateToAdmin(CreateAdminRequest request) {
		return new Admin.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.build();
	}
	
	public AdminDto AdminToDto(Admin admin) {
		return new AdminDto.builder()
				.id(admin.getId())
				.username(admin.getUsername())
				.password(admin.getPassword())
				.build();
	}
	
	public List<UserDto> ListUserToDto(List<User> users){
		return users.stream()
				.map(user-> UserToDto(user))
				.collect(Collectors.toList());
	}
}
