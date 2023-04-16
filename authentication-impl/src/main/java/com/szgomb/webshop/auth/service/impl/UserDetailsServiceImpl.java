package com.szgomb.webshop.auth.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.szgom.webshop.customer.service.CustomerService;
import com.szgomb.webshop.auth.model.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final CustomerService customerService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserDetailsImpl.buildFromUser(customerService.getUserByUserName(username));
	}
}
