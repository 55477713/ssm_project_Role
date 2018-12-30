package com.itheima.controller;

import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<UserInfo> userInfoList = userService.findAll();
        model.addAttribute("userList",userInfoList);
        System.out.println(userInfoList);
        return "user-list";
    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
    userService.save(userInfo);
        return "user-add";

    }
    @RequestMapping("/findById")
    public String findById(String id,Model model){
        System.out.println("qqqqqqqqqqqqqqqq"+id);
       UserInfo userInfo= userService.findById(id);
        System.out.println("wwwwwwwwwww"+userInfo);
       model.addAttribute("user",userInfo);
       return "user-show";
    }

}
