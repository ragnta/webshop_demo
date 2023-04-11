package com.szgom.webshop.customer.service;

import com.szgom.webshop.customer.model.User;

public interface CustomerService {

	User getUserByUserName(String userName);
	
	User getUserByUserUserId(String userId);
	
	
}
