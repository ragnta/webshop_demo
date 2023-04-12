package com.szgom.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szgom.webshop.customer.config.EnableCustomerService;
import com.szgomb.webshop.auth.config.EnableAuthenticationController;
import com.szgomb.webshop.auth.config.EnableAuthenticationService;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {})
@EnableAuthenticationController
@EnableAuthenticationService
@EnableCustomerService
public class WebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

}
