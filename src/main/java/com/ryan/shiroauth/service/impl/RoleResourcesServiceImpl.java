package com.ryan.shiroauth.service.impl;

import com.ryan.shiroauth.model.RoleResources;
import com.ryan.shiroauth.service.RoleResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lr
 * @date 2018/1/23
 */
@Service
public class RoleResourcesServiceImpl implements RoleResourcesService {

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addRoleResources(RoleResources roleResources) {


    }
}
