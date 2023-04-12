package com.szgom.webshop.customer.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.szgom.webshop.customer.model.User;

@Mapper
public interface CustomerRepository {

    User getUserByUsername(@Param("name") String userName);
}
