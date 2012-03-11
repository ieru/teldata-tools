/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.items;

/**
 *
 * @author Pablo
 */
public class Forum extends Object{
    private String id;
    private String idCourse;
    private String title;
    private String description;
    private String type;

    private String configExtraData;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfigExtraData() {
        return configExtraData;
    }

    public void setConfigExtraData(String configExtraData) {
        this.configExtraData = configExtraData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
}
