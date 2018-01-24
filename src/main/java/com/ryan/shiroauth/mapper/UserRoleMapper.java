package com.ryan.shiroauth.mapper;


import com.ryan.shiroauth.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface UserRoleMapper  {
    
    User selectByUsername(@Param("username") String username);
}