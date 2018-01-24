package com.ryan.shiroauth.mapper;


import com.ryan.shiroauth.model.Resources;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ResourcesMapper {
    
    List<Resources> queryAll();
    
    List<Resources> loadUserResources(@Param("userId") Integer userId);
}