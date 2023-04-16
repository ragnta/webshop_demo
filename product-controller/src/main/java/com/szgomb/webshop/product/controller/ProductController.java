package com.szgomb.webshop.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.szgom.webshop.product.model.Product;
import com.szgom.webshop.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(@RequestParam(defaultValue = "0") Long offset,
            @RequestParam(defaultValue = "20") Long limit){
		return ResponseEntity.ok(productService.getProducts(offset, limit));
	}
}
