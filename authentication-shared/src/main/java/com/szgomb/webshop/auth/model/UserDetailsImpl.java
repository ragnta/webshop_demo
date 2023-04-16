package com.szgomb.webshop.auth.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.szgom.webshop.customer.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl  implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter	
	private Long userId;
	
	@Getter
	@Setter
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static UserDetails buildFromUser(User user){
		var userDetails = new UserDetailsImpl();
		userDetails.setPassword(user.getPassword());
		userDetails.setUserId(user.getUserId());
		userDetails.setUsername(user.getUsername());
		return userDetails;
	}

}
