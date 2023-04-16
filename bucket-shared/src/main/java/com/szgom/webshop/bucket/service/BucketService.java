package com.szgom.webshop.bucket.service;

import com.szgom.webshop.bucket.model.Bucket;
import com.szgom.webshop.bucket.model.BucketStatus;
import com.szgom.webshop.product.model.Product;

public interface BucketService {

	Bucket createBucket(Long userId);
	
	Bucket addProductToBucket(Product product);
	
	Bucket handleBucket(Long bucketId, BucketStatus newBucketState);
}
