package com.ryan.shiroauth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ryan.shiroauth.mapper.ResourcesMapper;
import com.ryan.shiroauth.model.Resources;
import com.ryan.shiroauth.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lr
 * @date 2018/1/23
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {
    
    @Autowired
    private ResourcesMapper resourcesMapper;
    
    
    /**
     * 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
     *  roles[admin,user] 拥有角色访问
     *  perms[file:edit] 拥有资源访问
     *  authc:所有url都必须认证通过才可以访问;
     *  anon:所有url都都可以匿名访问
     */
    @Override
    public Map<String, String> loadShiroFilter() {
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        // 静态资源部受权限限制
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");
        filterChainDefinitionMap.put("/static/**","anon");
    
        //加载资源环境过滤
        List<Resources> resourcesList = queryAll();
        for(Resources resources : resourcesList){
            if (StrUtil.isNotEmpty(resources.getResurl())) {
                String permission = "perms[" + resources.getResurl()+ "]";
                filterChainDefinitionMap.put(resources.getResurl(), permission);
            }
        }
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }
    
    @Override
    public List<Resources> loadUserResources(Integer userId) {
        return resourcesMapper.loadUserResources(userId);
    }
    
    @Override
    public List<Resources> queryAll() {
        return resourcesMapper.queryAll();
    }
}
