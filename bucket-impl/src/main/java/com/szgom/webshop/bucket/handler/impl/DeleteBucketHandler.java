package com.szgom.webshop.bucket.handler.impl;

import com.szgom.webshop.bucket.model.Bucket;
import com.szgom.webshop.bucket.model.BucketStatus;
import com.szgom.webshop.bucket.repository.BucketRepository;

public class DeleteBucketHandler extends AbstractComplexBucketHandler {

	public DeleteBucketHandler(BucketRepository bucketRepository) {
		super(bucketRepository);
	}

	@Override
	public Bucket onForward(Bucket bucket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket onBack(Bucket bucket) {
		throw new RuntimeException("invalid state");
	}

	@Override
	BucketStatus getStatus() {
		return BucketStatus.DELETED;
	}

}
