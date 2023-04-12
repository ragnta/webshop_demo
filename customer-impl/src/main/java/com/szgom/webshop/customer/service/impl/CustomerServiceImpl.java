package com.szgom.webshop.customer.service.impl;

import com.szgom.webshop.customer.model.User;
import com.szgom.webshop.customer.repository.CustomerRepository;
import com.szgom.webshop.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repository;

    @Override
    public User getUserByUserName(String userName) {
        return repository.getUserByUsername(userName);
    }

    @Override
    public User getUserByUserUserId(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUserUserId'");
    }

}
