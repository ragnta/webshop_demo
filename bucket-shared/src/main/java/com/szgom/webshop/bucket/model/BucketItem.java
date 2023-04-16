package com.szgom.webshop.bucket.model;

import com.szgom.webshop.product.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BucketItem {

	@Getter
	@Setter
	private Product product;
	
	@Getter
	@Setter
	private int quantity;
}
