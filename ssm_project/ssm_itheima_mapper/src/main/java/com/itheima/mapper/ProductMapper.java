package com.itheima.mapper;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAll();

    void save(Product product);
    void delete(String id);
    List<Product> dim(String dim);
    Product findProductById(String pid);
}
