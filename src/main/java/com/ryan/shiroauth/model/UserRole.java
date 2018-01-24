package com.ryan.shiroauth.model;

import java.io.Serializable;

public class UserRole implements Serializable{
    
    private static final long serialVersionUID = -916411139749530670L;
    
    private Integer userid;

    private String roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}