package com.ryan.shiroauth.service;


import com.ryan.shiroauth.model.User;

/**
 * @author lr
 * @date 2018/1/23
 */
public interface UserService {

    User selectByUsername(String username);


}
