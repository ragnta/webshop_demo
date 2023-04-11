package com.szgomb.webshop.auth.service;

import com.szgomb.webshop.auth.model.UserDetailsImpl;

public interface JwtGenerator {

	/**
	 * Validate the jwt token
	 * 
	 * @param token
	 * @return true if the token is valid
	 */
	boolean validateToken(String token);

	/**
	 * 
	 * Extract the username from the token
	 * 
	 * @param token
	 * @return
	 */
	String extractUsername(String token);

	/**
	 * 
	 * Generate the token based on the token
	 * 
	 * @param user
	 * @return
	 */
	String generateToken(UserDetailsImpl user);
}
