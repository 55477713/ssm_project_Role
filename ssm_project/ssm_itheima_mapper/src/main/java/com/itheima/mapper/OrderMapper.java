package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrderMapper {
    //遍历订单
    List<Orders>findAll();

    Orders findById(String id);
}
