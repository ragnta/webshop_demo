package com.szgomb.webshop.auth.filter;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * This class define the logic what's happening if the authentication is failed.
 * 
 * if the authentication is failed we send an {@link HttpServletResponse.SC_UNAUTHORIZED}
 * 
 * @author szgomb
 *
 */
public class JwtAuthEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		
	}

}
