package com.itheima.service.impl;

import com.itheima.domain.Orders;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl  implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Orders> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Orders findById(String id) {
        return orderMapper.findById(id);
    }
}
