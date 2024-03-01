package com.koylumuhendis.atmproject.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.service.UserDetailServiceImpl;
import com.koylumuhendis.atmproject.service.UserService;
import com.koylumuhendis.atmproject.utils.TokenGenerator;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final TokenGenerator generator;
	
	private final UserDetailServiceImpl detailServiceImpl;
	
	
	public JwtFilter(TokenGenerator generator, UserDetailServiceImpl detailServiceImpl) {
		this.generator = generator;
		this.detailServiceImpl=detailServiceImpl;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token=getToken(request);
		String username;
		try {
			if(!token.isBlank()) {
				username=generator.verifyJWT(token).getSubject();
				UserDetails userDetails=detailServiceImpl.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authenticationToken=
						new UsernamePasswordAuthenticationToken(userDetails,null);
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			ObjectMapper mapper=new ObjectMapper();
			response.setContentType("application/json");
			Map<String ,String> errors=new HashMap();
			errors.put("error", e.getMessage());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(mapper.writeValueAsString(errors));
		}
	}
	
	private String getToken(HttpServletRequest request) {
		
		String header=request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header==null && !header.startsWith("Bearer ")) {
			return "";
		}
		return header.substring(7);
	}

}
