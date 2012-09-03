/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.dokeos;

import com.uah.dao.DAO;
import com.uah.dto.dokeos.DiscussionDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class DiscussionDokeosDAO  extends DAO{
    
    public DiscussionDokeosDAO(Connection connection){
        super(connection);
    }
    
    
    public List<DiscussionDokeosDTO> selectDiscussions(String db_name, String idForum){
        DiscussionDokeosDTO discussion;
        List<DiscussionDokeosDTO> threads = new ArrayList<DiscussionDokeosDTO>();
        
        try {
            String sqlOrder = "SELECT thread_id, thread_title, forum_id, thread_poster_id FROM "+db_name+".forum_thread WHERE forum_id="+idForum;            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionDokeosDTO();
    
                discussion.setId(rs.getString("thread_id"));
                discussion.setForum_id(rs.getString("forum_id"));
                discussion.setThread_title(rs.getString("thread_title"));          
                discussion.setDb_name(db_name);
                discussion.setUser_id("thread_poster_id");
                
                threads.add(discussion);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return threads;
    }
    
    
    /**
     * 
     * @param db_name
     * @return 
     */
    public List<DiscussionDokeosDTO> selectDiscussions(String db_name){
        DiscussionDokeosDTO discussion;
        List<DiscussionDokeosDTO> threads = new ArrayList<DiscussionDokeosDTO>();
        
        try {
            String sqlOrder = "SELECT thread_id, thread_title, forum_id, thread_poster_id FROM "+db_name+".forum_thread";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionDokeosDTO();
    
                discussion.setId(rs.getString("thread_id"));
                discussion.setForum_id(rs.getString("forum_id"));
                discussion.setThread_title(rs.getString("thread_title"));    
                discussion.setDb_name(db_name);
                discussion.setUser_id("thread_poster_id");
                
                threads.add(discussion);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return threads;
    }
    
    
    /**
     * 
     * @param db_name
     * @return 
     */
    public DiscussionDokeosDTO selectDiscussionsById(String db_name, String idDiscussion){
        DiscussionDokeosDTO discussion = new DiscussionDokeosDTO();
        
        try {
            String sqlOrder = "SELECT thread_id, thread_title, forum_id, thread_poster_id FROM "+db_name+".forum_thread WHERE thread_id='"+idDiscussion+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionDokeosDTO();
    
                discussion.setId(rs.getString("thread_id"));
                discussion.setForum_id(rs.getString("forum_id"));
                discussion.setThread_title(rs.getString("thread_title"));    
                discussion.setDb_name(db_name);
                discussion.setUser_id("thread_poster_id");
                            
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return discussion;
    }
}
