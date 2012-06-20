/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.PostMoodleDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class PostMoodleDAO  extends DAO{
    
    public PostMoodleDAO(Connection connection){
        super(connection);
    }
    
    public List<PostMoodleDTO> selectPosts(String idThread){
        PostMoodleDTO post;
        List<PostMoodleDTO> posts = new ArrayList<PostMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id, discussion, parent, userid, subject, message,created FROM mdl_forum_posts WHERE discussion ='"+idThread+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                post = new PostMoodleDTO();
    
                post.setIdThread(rs.getString("discussion"));
                post.setIdPost(rs.getString("id"));
                post.setIdPostParent(rs.getString("parent"));                
                post.setIdUser(rs.getString("userid"));
                post.setMessage(rs.getString("message"));
                post.setSubject(rs.getString("subject"));
                post.setCreated(rs.getString("created"));
        
                posts.add(post);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return posts;
    }
    
    
     public List<PostMoodleDTO> selectPosts(){
        PostMoodleDTO post;
        List<PostMoodleDTO> posts = new ArrayList<PostMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id, discussion, parent, userid, subject, message FROM mdl_forum_posts";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                post = new PostMoodleDTO();
    
                post.setIdThread(rs.getString("discussion"));
                post.setIdPost(rs.getString("id"));
                post.setIdPostParent(rs.getString("parent"));                
                post.setIdUser(rs.getString("userid"));
                post.setMessage(rs.getString("message"));
                post.setSubject(rs.getString("subject"));
                posts.add(post);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return posts;
    }
}
