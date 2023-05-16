package com.szgom.webshop.bucket.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;

import com.szgom.webshop.bucket.handler.impl.BucketHandlerFactory;
import com.szgom.webshop.bucket.model.Bucket;
import com.szgom.webshop.bucket.model.ComplexBucket;
import com.szgom.webshop.bucket.repository.BucketRepository;
import com.szgom.webshop.bucket.service.BucketService;
import com.szgom.webshop.product.model.Product;
import com.szgomb.webshop.auth.model.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService{

	private final BucketHandlerFactory bucketHandlerFactory;
	private final BucketRepository repository;
	
	
	@Override
	public Bucket createBucket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket addProductToBucket(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket handleBucketForward(Long bucketId) {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ComplexBucket bucket = repository.getBucket(bucketId, userDetailsImpl.getUserId());
		return bucketHandlerFactory.getBucketHandlers().get(bucket.getStatus()).onForward(bucket);
	}

	@Override
	public Bucket handleBucketBack(Long bucketId) {
		// TODO Auto-generated method stub
		return null;
	}


}
