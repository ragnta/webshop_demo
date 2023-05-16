package com.szgom.webshop.bucket.handler.configuration;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Bean;

import com.szgom.webshop.bucket.handler.impl.AbstractComplexBucketHandler;
import com.szgom.webshop.bucket.handler.impl.BucketHandlerFactory;
import com.szgom.webshop.bucket.handler.impl.ConfirmBucketHandler;
import com.szgom.webshop.bucket.handler.impl.DeleteBucketHandler;
import com.szgom.webshop.bucket.handler.impl.PayedBucketHandler;
import com.szgom.webshop.bucket.handler.impl.PendingBucketHandler;
import com.szgom.webshop.bucket.repository.BucketRepository;

public class BucketHandlerConfiguration {

	@Bean
	public AbstractComplexBucketHandler getPendingBucketHandler(BucketRepository bucketRepository) {
		return new PendingBucketHandler(bucketRepository);
	}
	
	@Bean
	public AbstractComplexBucketHandler getDeleteBucketHandler(BucketRepository bucketRepository) {
		return new DeleteBucketHandler(bucketRepository);
	}
	
	@Bean
	public AbstractComplexBucketHandler getPayedBucketHandler(BucketRepository bucketRepository) {
		return new PayedBucketHandler(bucketRepository);
	}
	
	@Bean
	public AbstractComplexBucketHandler getConfirmBucketHandler(BucketRepository bucketRepository) {
		return new ConfirmBucketHandler(bucketRepository);
	}
	
	@Bean
	public BucketHandlerFactory getBucketHandlerFactory(ListableBeanFactory beanFactory) {
		return new BucketHandlerFactory(beanFactory);
	}
}
