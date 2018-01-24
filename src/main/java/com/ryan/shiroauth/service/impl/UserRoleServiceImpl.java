package com.ryan.shiroauth.service.impl;

import com.ryan.shiroauth.model.UserRole;
import com.ryan.shiroauth.service.UserRoleService;
import com.ryan.shiroauth.config.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lr
 * @date 2018/1/23
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(UserRole userRole) {
    }
}
