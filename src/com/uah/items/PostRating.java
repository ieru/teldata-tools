package com.uah.items;

import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class PostRating {    
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String postid;
    private String scaleid;
    private String rating;
    private String userid;
    private String courseid;
    private String forumid;
    private String roleid;
    private String rolename;
    private String forumname;    
    private List<String> fields;
    
    
    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    public PostRating(){
                
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getForumid() {
        return forumid;
    }

    public void setForumid(String forumid) {
        this.forumid = forumid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getScaleid() {
        return scaleid;
    }

    public void setScaleid(String scaleid) {
        this.scaleid = scaleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getForumname() {
        return forumname;
    }

    public void setForumname(String forumname) {
        this.forumname = forumname;
    }

    public List<String> getFields() {
        return fields;
    }
    
    
}
