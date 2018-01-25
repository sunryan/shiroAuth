package com.ryan.shiroauth.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private static final long serialVersionUID = -8736616045315083846L;
    
    private Integer id;

    private String username;

    private String password;
    
    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 是否启用
     */
    private Integer enable;
    
    /**
     * 用户拥有角色
     */
    private List<Role> roleList;
    
    /**
     * 用户拥有资源
     */
    private List<Resources> resourcesList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
    
    public List<Role> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                '}';
    }
    
    public List<Resources> getResourcesList() {
        for(Role role : getRoleList()){
            resourcesList.addAll(role.getResourcesList());
        }
        return resourcesList;
    }
    
    public void setResourcesList(List<Resources> resourcesList) {
        this.resourcesList = resourcesList;
    }
    
    public String getSalt() {
        return this.username + this.salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
}