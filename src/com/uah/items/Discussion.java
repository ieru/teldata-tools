/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.items;

/**
 *
 * @author Pablo
 */
public class Discussion {
    private String id;
    private String idCourse;
    private String idForum;    
    private String idGroup;
    private String idParticipant;
    
    private String title;
    
    private String configExtraData;

    
    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(String idParticipant) {
        this.idParticipant = idParticipant;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigExtraData() {
        return configExtraData;
    }

    public void setConfigExtraData(String configExtraData) {
        this.configExtraData = configExtraData;
    }
           
    
}
