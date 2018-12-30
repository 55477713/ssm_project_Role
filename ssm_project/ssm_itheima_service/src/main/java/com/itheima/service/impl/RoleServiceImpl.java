package com.itheima.service.impl;

import com.itheima.domain.Roles;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Roles> findAll() {
        return roleMapper.findAll();
    }
}
