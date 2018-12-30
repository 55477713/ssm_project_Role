package com.itheima.mapper;

import com.itheima.domain.UserInfo;

import java.util.List;

public interface UserMapper {
    UserInfo findUserByUsername(String username);
    List<UserInfo> findAll();
    UserInfo findById(String id);

    void save(UserInfo userInfo);
}
