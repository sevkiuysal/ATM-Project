package com.koylumuhendis.atmproject.service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koylumuhendis.atmproject.model.Admin;
import com.koylumuhendis.atmproject.model.Role;
import com.koylumuhendis.atmproject.model.User;
import com.koylumuhendis.atmproject.repository.AdminRepository;
import com.koylumuhendis.atmproject.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	private final AdminRepository adminRepository;

	public UserDetailServiceImpl(UserRepository userRepository, AdminRepository adminRepository) {
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findUserByUsername(username);
		
		if(user!=null) {
			var roles=Stream.of(Role.USER)
					.map(t->
					new SimpleGrantedAuthority(t.name()))
					.collect(Collectors.toList());
			return new org.springframework.security.core.userdetails
					.User(user.getUsername(),user.getPassword(),roles);
		}else {
			Admin admin=adminRepository.findAdminByUsername(username).get();
			var roles=Stream.of(Role.ADMIN)
					.map(t->
					new SimpleGrantedAuthority(t.name()))
					.collect(Collectors.toList());
			return new org.springframework.security.core.userdetails
					.User(admin.getUsername(),admin.getPassword(),roles);
		}
	}
	
	

}
