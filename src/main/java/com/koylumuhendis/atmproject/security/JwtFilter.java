package com.koylumuhendis.atmproject.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.koylumuhendis.atmproject.utils.TokenGenerator;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final TokenGenerator generator;
	
	
	public JwtFilter(TokenGenerator generator) {
		this.generator = generator;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token=getToken(request);
	}
	
	private String getToken(HttpServletRequest request) {
		
		String header=request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header==null && !header.startsWith("Bearer ")) {
			return "";
		}
		return header.substring(7);
	}

}
