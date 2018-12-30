package com.itheima.controller;

import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;
    /*查询所有订单*/
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Orders> list = service.findAll();
        System.out.println(list);
        model.addAttribute("orderList",list);
        return "orders-list";
    }
    @RequestMapping("/findById")
    public String findByOrdersId(String id,Model model){
        Orders orders= service.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }

}
