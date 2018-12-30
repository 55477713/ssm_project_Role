package com.itheima.mapper;

import com.itheima.domain.Roles;
import com.itheima.domain.UserInfo;

import java.util.List;

public interface RoleMapper {
    public List<UserInfo> findByUserId(String userId);
    List<Roles> findAll();
}
