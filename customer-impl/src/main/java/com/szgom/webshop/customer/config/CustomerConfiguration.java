package com.szgom.webshop.customer.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szgom.webshop.customer.repository.CustomerRepository;
import com.szgom.webshop.customer.service.CustomerService;
import com.szgom.webshop.customer.service.impl.CustomerServiceImpl;

@Configuration
public class CustomerConfiguration{

    @Bean
    public MapperFactoryBean<CustomerRepository> customerRepository(SqlSessionFactory sqlSessionFactory) throws Exception {
      MapperFactoryBean<CustomerRepository> factoryBean = new MapperFactoryBean<>(CustomerRepository.class);
      factoryBean.setSqlSessionFactory(sqlSessionFactory);
      return factoryBean;
    }

    @Bean
    public CustomerService getCustomerService(CustomerRepository repository){
        return new CustomerServiceImpl(repository);
    }
}