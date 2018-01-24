package com.ryan.shiroauth.model;

import java.io.Serializable;

public class RoleResources implements Serializable{
    private static final long serialVersionUID = -8559867942708057891L;
    
    private Integer roleid;

    private String resourcesid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getResourcesid() {
        return resourcesid;
    }

    public void setResourcesid(String resourcesid) {
        this.resourcesid = resourcesid;
    }
}