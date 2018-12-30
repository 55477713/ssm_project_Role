package com.itheima.service.impl;

import com.itheima.domain.Roles;
import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements com.itheima.service.UserService {
    @Autowired
    private UserMapper userMapper;
    UserInfo userInfo=null;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("----------username--------"+username);
        //根据用户名查询用户信息,在添加用户的时候保证用户名唯一
        userInfo = userMapper.findUserByUsername(username);
        System.out.println("返回的用户"+userInfo);
        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus()==1?true:false,
                true,true,true,getRoles(userInfo.getRoles() ));


        return user;
    }
    public List<SimpleGrantedAuthority> getRoles(List<Roles> rolesList){
        List<SimpleGrantedAuthority>roles=new ArrayList<>();
        for (Roles role : rolesList) {
            SimpleGrantedAuthority sga=new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            roles.add(sga);
        }

        return roles;
    }

    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userMapper.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userMapper.findById(id);
    }
}
