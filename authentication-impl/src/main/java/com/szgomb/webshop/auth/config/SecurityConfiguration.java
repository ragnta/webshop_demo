package com.szgomb.webshop.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.szgom.webshop.customer.service.CustomerService;
import com.szgomb.webshop.auth.filter.JwtAuthEntryPoint;
import com.szgomb.webshop.auth.filter.JwtAuthenticationFilter;
import com.szgomb.webshop.auth.service.AuthenticationService;
import com.szgomb.webshop.auth.service.impl.AuthenticationServiceImpl;
import com.szgomb.webshop.auth.service.impl.JwtGeneratorImpl;
import com.szgomb.webshop.auth.service.impl.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling() //
				.authenticationEntryPoint(getJwtAuthEntryPoint()) //
				.and() //
				.sessionManagement()//
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //
				.and() //
				.authorizeHttpRequests() //
				.requestMatchers("/api/auth/**").permitAll() //
				.anyRequest().authenticated() //
				.and()//
				.httpBasic();
		http.addFilterBefore(getJwtAuthenticationFilter(getUserDetailsService(getBCryptPasswordEncoder()), getJwtGenerator()),
				UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	public JwtAuthenticationFilter getJwtAuthenticationFilter(UserDetailsService service, JwtGeneratorImpl tokenGenerator) {
		return new JwtAuthenticationFilter(tokenGenerator, service);
	}

	@Bean
	public JwtGeneratorImpl getJwtGenerator() {
		return new JwtGeneratorImpl();
	}

	@Bean
	public AuthenticationService getAuthenticationServiceImpl(AuthenticationManager authManager, JwtGeneratorImpl generator, UserDetailsService userDetailService, CustomerService customerService) {
		return new AuthenticationServiceImpl(authManager, generator, userDetailService, customerService);
	}

	@Bean
	public PasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthEntryPoint getJwtAuthEntryPoint() {
		return new JwtAuthEntryPoint();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService(PasswordEncoder passwordEncoder) {
		return new UserDetailsServiceImpl(passwordEncoder);
	}
}
