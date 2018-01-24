package com.ryan.shiroauth.service;


import com.ryan.shiroauth.model.Resources;

import java.util.List;
import java.util.Map;

/**
 * @author lr
 * @date 2018/1/23
 */
public interface ResourcesService  {
    
    /**
     * 加载shiro 资源权限过滤器
     * @return
     */
    Map<String, String> loadShiroFilter();
    
    /**
     * @param userId
     * @return
     */
    List<Resources> loadUserResources(Integer userId);
    
    /**
     * 查询所有资源
     * @return
     */
    List<Resources> queryAll();
    
}
