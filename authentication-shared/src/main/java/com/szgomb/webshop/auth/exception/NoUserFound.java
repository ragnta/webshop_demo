package com.szgomb.webshop.auth.exception;

public class NoUserFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUserFound(String message) {
		super(message);
	}
}
