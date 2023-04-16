package com.szgomb.webshop.product.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.szgom.webshop.product.service.ProductService;
import com.szgomb.webshop.product.repository.ProductRepository;
import com.szgomb.webshop.product.service.ProductServiceImpl;

@Configuration
public class ProductConfig {

	@Bean
    public MapperFactoryBean<ProductRepository> getProductRepository(SqlSessionFactory sqlSessionFactory) throws Exception {
      MapperFactoryBean<ProductRepository> factoryBean = new MapperFactoryBean<>(ProductRepository.class);
      factoryBean.setSqlSessionFactory(sqlSessionFactory);
      return factoryBean;
    }

    @Bean
    public ProductService getProductService(ProductRepository repository){
        return new ProductServiceImpl(repository);
    }
}
