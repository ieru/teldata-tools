/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dto.dokeos;

/**
 *
 * @author Pablo
 */
public class DiscussionDokeosDTO {
    private String id;
    private String thread_title;
    private String forum_id;
    private String user_id;
    
    private String db_name;

    public DiscussionDokeosDTO(){
        
    }

    public String getForum_id() {
        return forum_id;
    }

    public void setForum_id(String forum_id) {
        this.forum_id = forum_id;
    }


    public String getThread_title() {
        return thread_title;
    }

    public void setThread_title(String thread_title) {
        this.thread_title = thread_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    
}
