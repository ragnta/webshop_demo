package com.szgomb.webshop.auth.service.impl;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final PasswordEncoder pwencoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("admin")) {
			// TODO getUser from repository
			return new User(username, pwencoder.encode("password"), List.of(new SimpleGrantedAuthority("USER")));
		}
		return null;
	}
}
