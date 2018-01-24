package com.ryan.shiroauth.controller;

import cn.hutool.core.util.StrUtil;
import com.ryan.shiroauth.model.Resources;
import com.ryan.shiroauth.service.ResourcesService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 后台资源管理
 * @author lr
 * @date 2018/1/24
 */
@Controller
@RequestMapping("/sys/resour")
public class SysResourcesController {
    
//    @Resource
    private ShiroFilterFactoryBean shiroFilterFactoryBean;
    @Resource
    private ResourcesService resourcesService;
    
    /**
     * 更新资源后 重新加载权限注入shiro
     */
    @RequestMapping("/updatePermission")
    public void updatePermission() {
        
        AbstractShiroFilter shiroFilter;
        try {
            shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("get ShiroFilter from shiroFilterFactory error!");
        }
        
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
    
        // 清空老的权限控制
        manager.getFilterChains().clear();
        
        shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
        //重新加载
        shiroFilterFactoryBean.setFilterChainDefinitionMap(resourcesService.loadShiroFilter());
        // 重新构建生成
        Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
        for (Map.Entry<String, String> entry : chains.entrySet()) {
            String url = entry.getKey();
            String chainDefinition = entry.getValue().trim().replace(" ", "");
            manager.createChain(url, chainDefinition);
        }
        
        System.out.println("更新权限成功！！");
    
    }
}
