package com.szgomb.webshop.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
}
