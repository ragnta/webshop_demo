package com.szgom.webshop.bucket.service;

import com.szgom.webshop.bucket.model.Bucket;
import com.szgom.webshop.product.model.Product;

public interface BucketService {

	Bucket createBucket();
	
	Bucket addProductToBucket(Product product);
	
	Bucket handleBucketForward(Long bucketId);
	
	Bucket handleBucketBack(Long bucketId);
}
