package com.szgom.webshop.bucket.handler.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ListableBeanFactory;

import com.szgom.webshop.bucket.handler.BucketHandler;
import com.szgom.webshop.bucket.model.BucketStatus;

import lombok.Getter;

public class BucketHandlerFactory {

	@Getter
	private final Map<BucketStatus, BucketHandler> bucketHandlers;

	public BucketHandlerFactory(ListableBeanFactory context) {
		bucketHandlers = context.getBeansOfType(AbstractComplexBucketHandler.class).entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toMap(AbstractComplexBucketHandler::getStatus, Function.identity()));
	}

}
