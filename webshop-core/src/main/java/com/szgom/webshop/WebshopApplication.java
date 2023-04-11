package com.szgom.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szgomb.webshop.auth.config.EnableAuthenticationController;
import com.szgomb.webshop.auth.config.EnableAuthenticationService;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {})
@EnableAuthenticationController
@EnableAuthenticationService
public class WebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

}
