package com.ryan.shiroauth.service.impl;

import com.ryan.shiroauth.mapper.UserRoleMapper;
import com.ryan.shiroauth.model.User;
import com.ryan.shiroauth.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lr
 * @date 2018/1/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User selectByUsername(String username) {
        return userRoleMapper.selectByUsername(username);
    }
}
