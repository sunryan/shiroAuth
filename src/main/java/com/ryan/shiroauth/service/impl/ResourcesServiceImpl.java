package com.ryan.shiroauth.service.impl;

import com.ryan.shiroauth.mapper.ResourcesMapper;
import com.ryan.shiroauth.model.Resources;
import com.ryan.shiroauth.service.ResourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {
   @Resource
    private ResourcesMapper resourcesMapper;
    
    
    @Override
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return null;
    }
    
    @Override
    public List<Resources> queryAll() {
        return null;
    }
}
