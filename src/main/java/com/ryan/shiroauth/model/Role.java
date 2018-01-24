package com.ryan.shiroauth.model;

import java.io.Serializable;

public class Role implements Serializable{
    
    private static final long serialVersionUID = -6140090613812307452L;
    
    private Integer id;

    private String roledesc;
    
    private Integer selected;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}