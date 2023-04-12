package com.szgomb.webshop.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.szgomb.webshop.auth.dto.AuthenticationResponse;
import com.szgomb.webshop.auth.dto.LoginRequest;
import com.szgomb.webshop.auth.dto.RegisterRequest;

public interface AuthenticationService {

	/**
	 * 
	 * Register a user based on the registerdata
	 * 
	 * @param request
	 * @return
	 */
	AuthenticationResponse register(RegisterRequest request);
	
	/**
	 * 
	 * Authenticate a user, and generate a token
	 * 
	 * @param request
	 * @return
	 */
	AuthenticationResponse login(LoginRequest request);
	
	/**
	 * Get UserDetails by username
	 */
	UserDetails getUserByUsername(String userName);
}
