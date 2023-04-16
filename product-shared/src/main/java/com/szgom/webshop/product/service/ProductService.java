package com.szgom.webshop.product.service;

import java.util.List;

import com.szgom.webshop.product.model.Product;

public interface ProductService {

	List<Product> getProducts(Long offset, Long limit);
}
