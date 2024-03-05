package com.koylumuhendis.atmproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.koylumuhendis.atmproject.security.JwtAccessDeniedHandler;
import com.koylumuhendis.atmproject.security.JwtAuthenticationEntryPoint;
import com.koylumuhendis.atmproject.security.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	private final JwtFilter jwtFilter;
	
	private final JwtAccessDeniedHandler accessDeniedHandler;
	
	private final JwtAuthenticationEntryPoint entryPoint;

	public SecurityConfig(JwtFilter jwtFilter, JwtAccessDeniedHandler accessDeniedHandler,
			JwtAuthenticationEntryPoint entryPoint) {
		this.jwtFilter = jwtFilter;
		this.accessDeniedHandler = accessDeniedHandler;
		this.entryPoint = entryPoint;
	}
	
	@Bean
	public WebMvcConfigurer mvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}
}
