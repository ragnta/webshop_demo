package com.szgomb.webshop.product.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szgom.webshop.product.model.Product;

public interface ProductRepository {

	List<Product> getProductList(@Param("offset") Long offset, @Param("limit") Long limit);
}
