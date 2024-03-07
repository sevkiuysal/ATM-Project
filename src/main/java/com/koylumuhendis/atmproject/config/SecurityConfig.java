package com.koylumuhendis.atmproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
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
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("api/v1/auth/login");
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security
				.csrf().disable()
				.cors().and()
				.authorizeRequests((auth)->{
					auth.requestMatchers("api/v1/admin").hasAuthority("ADMIN");
					auth.requestMatchers("api/v1/user").hasAnyAuthority("ADMIN","USER");
					auth.anyRequest().authenticated();
				}
				).build();
	}
}
