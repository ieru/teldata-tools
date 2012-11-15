/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.graph;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class MavselEdge {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String created_time;
    private MavselVertex user;
    private MavselVertex forum;
    public static String USER  = "UserId";
    public static String FORUM = "ForumId";
    
    public MavselEdge(){
                       
    }
    
    public MavselEdge(String created_time, MavselVertex user, MavselVertex forum){
        this.created_time = created_time;
        this.user = user;
        this.forum = forum;                        
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public MavselVertex getForum() {
        return forum;
    }

    public void setForum(MavselVertex forum) {
        this.forum = forum;
    }

    public MavselVertex getUser() {
        return user;
    }

    public void setUser(MavselVertex user) {
        this.user = user;
    }


        
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer message = new StringBuffer();
        
        message.append(USER);
        message.append("[");
        message.append(user.getId());        
        message.append("]");
        message.append("-");
        
        message.append(FORUM);
        message.append("[");
        message.append(forum.getId());        
        message.append("]");
        
        return message.toString();
    }
    
}
