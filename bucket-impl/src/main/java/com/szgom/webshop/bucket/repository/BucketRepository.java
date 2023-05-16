package com.szgom.webshop.bucket.repository;

import com.szgom.webshop.bucket.model.ComplexBucket;

public interface BucketRepository {

	ComplexBucket getBucket(Long bucketId, Long customerId);
}
