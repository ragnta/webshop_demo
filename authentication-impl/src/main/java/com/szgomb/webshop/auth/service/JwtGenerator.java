package com.szgomb.webshop.auth.service;

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
	 * Generate the token based on the username
	 * 
	 * @param username
	 * @return
	 */
	String generateToken(String userName);
}
