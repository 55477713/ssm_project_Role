package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1")Integer pageNum, @RequestParam(required = false,defaultValue = "3")Integer pageSize, Model model){
        List<Product> productList = productService.findAll(pageNum,pageSize);
        /*物理分页*/
        PageInfo page=new PageInfo(productList);
        model.addAttribute("page",page);


        return "product-list";
    }
   @RequestMapping("/save")
    public String save(Product product){
    productService.save(product);
    return "redirect:findAll";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request ){
        String[] ids = request.getParameterValues("ids");
        productService.delete(ids);
        return "redirect:findAll";
    }
    @RequestMapping("/dim")
    public  String dim(HttpServletRequest request){
        String fo = request.getParameter("fo");
        System.out.println(fo);
        List<Product> list = productService.dim(fo);
        request.setAttribute("list",list);
        return "product-list";

    }
}
