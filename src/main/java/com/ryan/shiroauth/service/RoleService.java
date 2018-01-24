package com.ryan.shiroauth.service;


import com.ryan.shiroauth.model.Role;

import java.util.List;

/**
 * @author lr
 * @date 2018/1/23
 */
public interface RoleService {

    public List<Role> queryRoleListWithSelected(Integer uid);

    /**
     * 删除角色 同时删除角色资源表中的数据
     * @param roleid
     */
    public void delRole(Integer roleid);
}
