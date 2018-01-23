package com.ryan.shiroauth.mapper;


import com.ryan.shiroauth.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    public List<Role> queryRoleListWithSelected(Integer id);
}