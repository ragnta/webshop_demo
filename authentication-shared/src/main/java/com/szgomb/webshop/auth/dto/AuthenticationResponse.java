package com.szgomb.webshop.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {

	@Getter
	@Setter
	private String accessToken;
}
