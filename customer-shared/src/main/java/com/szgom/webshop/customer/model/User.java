package com.szgom.webshop.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter	
	private Long userId;
	
	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String email;
	
}
