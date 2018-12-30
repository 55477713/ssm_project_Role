package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Product> list = productMapper.findAll();
        return list;
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
        System.out.println("方法执行了"+product);
    }

    @Override
    public void delete(String[] id) {
        if (id!=null){
            for (String s : id) {
                productMapper.delete(s);

            }
        }


    }

    @Override
    public List<Product> dim(String dim) {
        return productMapper.dim(dim);

    }
}
