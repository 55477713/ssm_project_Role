package com.itheima.controller;

import com.itheima.domain.Roles;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
@Autowired
private RoleService roleService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Roles> rolesList = roleService.findAll();
        model.addAttribute("roleList",rolesList);
        return "role-list";
    }

}
