package com.ryan.shiroauth.service;


import com.ryan.shiroauth.model.Resources;

import java.util.List;
import java.util.Map;

/**
 *
 * @author yangqj
 * @date 2017/4/25
 */
public interface ResourcesService  {
    
    /**
     * @param map
     * @return
     */
    List<Resources> loadUserResources(Map<String, Object> map);
    
    /**
     * @return
     */
    List<Resources> queryAll();
    
}
