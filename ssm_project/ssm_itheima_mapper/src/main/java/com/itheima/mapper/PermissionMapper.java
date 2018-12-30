package com.itheima.mapper;

import com.itheima.domain.UserInfo;

import java.util.List;

public interface PermissionMapper {
    List<UserInfo> findByRoleId(String roleId);

}
