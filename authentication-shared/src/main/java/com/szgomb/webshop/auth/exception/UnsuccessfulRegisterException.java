package com.szgomb.webshop.auth.exception;

public class UnsuccessfulRegisterException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsuccessfulRegisterException(String message) {
		super(message);
	}
}
