package com.szgom.webshop.bucket.handler.impl;

import com.szgom.webshop.bucket.handler.BucketHandler;
import com.szgom.webshop.bucket.model.BucketStatus;
import com.szgom.webshop.bucket.repository.BucketRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractComplexBucketHandler implements BucketHandler{

	protected final BucketRepository bucketService;
	
	
	abstract BucketStatus getStatus();
}
