package com.szgomb.webshop.auth.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.szgom.webshop.customer.model.User;
import com.szgom.webshop.customer.service.CustomerService;
import com.szgomb.webshop.auth.dto.AuthenticationResponse;
import com.szgomb.webshop.auth.dto.LoginRequest;
import com.szgomb.webshop.auth.dto.RegisterRequest;
import com.szgomb.webshop.auth.service.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

	private final AuthenticationManager authManager;

	private final JwtGeneratorImpl generator;
	
	private final UserDetailsService userDetailService;

	private final CustomerService service;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		// var user =  UserDetailsImpl.builder().username(request.getUsername()).password(request.getPassword()).build();
		User user = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).email(request.getEmail()).build();
		service.storeUser(user);
		String jwtToken = generator.generateToken(user.getUsername());
		return AuthenticationResponse.builder().accessToken(jwtToken).build();
	}

	@Override
	public AuthenticationResponse login(LoginRequest request) {
		authManager.authenticate(
			        new UsernamePasswordAuthenticationToken(
			            request.getUsername(),
			            request.getPassword()
			        )
			    );
		var user = service.getUserByUserName(request.getUsername());
		String jwtToken = generator.generateToken(user.getUsername());
		return AuthenticationResponse.builder().accessToken(jwtToken).build();
	}

	@Override
	public UserDetails getUserByUsername(String userName) {
		return userDetailService.loadUserByUsername(userName);
	}

	

}
