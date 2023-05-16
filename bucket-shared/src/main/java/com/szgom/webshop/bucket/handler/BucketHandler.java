package com.szgom.webshop.bucket.handler;

import com.szgom.webshop.bucket.model.Bucket;

public interface BucketHandler {
	
	Bucket onForward(Bucket bucket);
	
	Bucket onBack(Bucket bucket);
}
