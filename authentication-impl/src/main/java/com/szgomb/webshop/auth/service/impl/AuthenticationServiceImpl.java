package com.szgomb.webshop.auth.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.szgom.webshop.customer.service.CustomerService;
import com.szgomb.webshop.auth.dto.AuthenticationResponse;
import com.szgomb.webshop.auth.dto.LoginRequest;
import com.szgomb.webshop.auth.dto.RegisterRequest;
import com.szgomb.webshop.auth.model.UserDetailsImpl;
import com.szgomb.webshop.auth.service.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

	private final AuthenticationManager authManager;

	private final JwtGeneratorImpl generator;
	
	private final UserDetailsService userDetailService;

	private final CustomerService service;
	
	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		// var user =  UserDetailsImpl.builder().username(request.getUsername()).password(request.getPassword()).build();
		var user = service.getUserByUserName(request.getUsername());
		var userDetails = UserDetailsImpl.buildFromUser(user);
		String jwtToken = generator.generateToken(userDetails);
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
		
		// TODO getUser from repository
		var user =  UserDetailsImpl.builder().username(request.getUsername()).password(request.getPassword()).build();
		String jwtToken = generator.generateToken(user);
		return AuthenticationResponse.builder().accessToken(jwtToken).build();
	}

	@Override
	public UserDetails getUserByUsername(String userName) {
		return userDetailService.loadUserByUsername(userName);
	}

	

}
