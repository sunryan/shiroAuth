package com.ryan.shiroauth.service;


import com.ryan.shiroauth.model.User;

/**
 * Created by yangqj on 2017/4/21.
 */
public interface UserService {

    User selectByUsername(String username);

    void delUser(Integer userid);

}
