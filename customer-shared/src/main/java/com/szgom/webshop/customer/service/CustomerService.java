package com.szgom.webshop.customer.service;

import com.szgom.webshop.customer.model.User;

public interface CustomerService {

	User getUserByUserName(String userName);
	
	User getUserByUserUserId(Long userId);
	
	void storeUser(User user);
	
	
}
