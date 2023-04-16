package com.szgom.webshop.product.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String name;
    
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private BigDecimal price;
    
	@Getter
	@Setter
	private String imgUrl;
    
	@Getter
	@Setter
	private Integer quantity;
}
