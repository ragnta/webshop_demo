package com.szgomb.webshop.product.service;

import java.util.List;

import com.szgom.webshop.product.model.Product;
import com.szgom.webshop.product.service.ProductService;
import com.szgomb.webshop.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository repository;
	
	@Override
	public List<Product> getProducts(Long offset, Long limit) {
		
		return repository.getProductList(offset, limit);
	}

}
