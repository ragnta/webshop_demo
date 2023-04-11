package com.szgomb.webshop.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
public class LoginRequest {

	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
}
