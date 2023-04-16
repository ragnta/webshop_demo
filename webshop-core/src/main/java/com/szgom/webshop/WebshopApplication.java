package com.szgom.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szgom.webshop.customer.config.EnableCustomerService;
import com.szgomb.webshop.auth.config.EnableAuthenticationController;
import com.szgomb.webshop.auth.config.EnableAuthenticationService;
import com.szgomb.webshop.product.config.EnableProductController;
import com.szgomb.webshop.product.config.EnableProductService;

@SpringBootApplication(scanBasePackages = {})
@EnableAuthenticationController
@EnableAuthenticationService
@EnableCustomerService
@EnableProductService
@EnableProductController
public class WebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

}
