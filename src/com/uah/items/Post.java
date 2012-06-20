/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.items;



/**
 *
 * @author Pablo
 */
public class Post {
    
    private String id;
    private String idDiscussion;
    private String idPostParent;
    private String idParticipant;
    
    private String subject;
    private String message;

    private String configExtraData;
    private String createdTime;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(String idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public String getIdPostParent() {
        return idPostParent;
    }

    public void setIdPostParent(String idPostParent) {
        this.idPostParent = idPostParent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(String idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getConfigExtraData() {
        return configExtraData;
    }

    public void setConfigExtraData(String configExtraData) {
        this.configExtraData = configExtraData;
    }
           
    public String getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
}
           
    
}
