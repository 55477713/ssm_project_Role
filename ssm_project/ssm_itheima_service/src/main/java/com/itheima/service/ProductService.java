package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product>findAll(Integer pageNum,Integer pageSize);

    void save(Product product);
    void delete(String[] id);
    List<Product> dim(String dim);
}
