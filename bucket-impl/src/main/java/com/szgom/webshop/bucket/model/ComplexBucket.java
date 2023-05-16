package com.szgom.webshop.bucket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ComplexBucket extends Bucket{

	@Getter
	@Setter
	private BucketStatus status;
}
