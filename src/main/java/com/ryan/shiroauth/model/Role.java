package com.ryan.shiroauth.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    
    private static final long serialVersionUID = -6140090613812307452L;
    
    private Integer id;

    private String roledesc;
    
    private Integer selected;
    
    private List<Resources> resourcesList;
   
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
    
    public List<Resources> getResourcesList() {
        return resourcesList;
    }
    
    public void setResourcesList(List<Resources> resourcesList) {
        this.resourcesList = resourcesList;
    }
}