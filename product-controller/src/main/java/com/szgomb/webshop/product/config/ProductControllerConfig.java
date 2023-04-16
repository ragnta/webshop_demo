package com.szgomb.webshop.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szgom.webshop.product.service.ProductService;
import com.szgomb.webshop.product.controller.ProductController;

@Configuration
public class ProductControllerConfig {

	@Bean
	public ProductController getProductController(ProductService productService) {
		return new ProductController(productService);
	}
}
