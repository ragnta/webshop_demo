package com.szgomb.webshop.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szgomb.webshop.auth.controller.AuthenticationController;
import com.szgomb.webshop.auth.service.AuthenticationService;


@Configuration
public class AuthenticationControllerConfig {

	@Bean
	public AuthenticationController getAuthenticationController(AuthenticationService authService) {
		return new AuthenticationController(authService);
	}
}
