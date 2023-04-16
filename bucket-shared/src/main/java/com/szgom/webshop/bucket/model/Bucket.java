package com.szgom.webshop.bucket.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bucket {

	@Getter
	@Setter
	private List<BucketItem> bucketItemList;
	
	@Getter
	@Setter
	private BucketStatus status;
}
