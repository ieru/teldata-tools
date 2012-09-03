/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.DiscussionMoodleDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class DiscussionMoodleDAO  extends DAO {
    
    public DiscussionMoodleDAO(Connection connection){
        super(connection);
    }
    
    /**
     * 
     * @param idForum
     * @return 
     */
    public List<DiscussionMoodleDTO> selectDiscussions(String idForum){
        DiscussionMoodleDTO discussion;
        List<DiscussionMoodleDTO> threads = new ArrayList<DiscussionMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id,course,forum,name,userid,groupid FROM mdl_forum_discussions WHERE forum ='"+idForum+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionMoodleDTO();
    
                discussion.setIdThread(rs.getString("id"));
                discussion.setIdCourse(rs.getString("course"));
                discussion.setIdForum(rs.getString("forum"));
                discussion.setIdGroup(rs.getString("groupid"));                
                discussion.setIdUser(rs.getString("userid"));
                discussion.setTitle(rs.getString("name"));
                System.out.println(sqlOrder);
                threads.add(discussion);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return threads;
    }
    
    
    /**
     * 
     * @return 
     */
    public List<DiscussionMoodleDTO> selectDiscussions(){
        DiscussionMoodleDTO discussion;
        List<DiscussionMoodleDTO> threads = new ArrayList<DiscussionMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id,course,forum,name,userid,groupid FROM mdl_forum_discussions";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionMoodleDTO();
    
                discussion.setIdThread(rs.getString("id"));
                discussion.setIdCourse(rs.getString("course"));
                discussion.setIdForum(rs.getString("forum"));
                discussion.setIdGroup(rs.getString("groupid"));                
                discussion.setIdUser(rs.getString("userid"));
                discussion.setTitle(rs.getString("name"));
                System.out.println(sqlOrder);
                threads.add(discussion);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return threads;
    }
    
    /**
     * 
     * @return 
     */
    public DiscussionMoodleDTO selectDiscussionsById(String idDiscussion){
        DiscussionMoodleDTO discussion = new DiscussionMoodleDTO();
                
        try {
            String sqlOrder = "SELECT id,course,forum,name,userid,groupid FROM mdl_forum_discussions WHERE id='"+idDiscussion+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                discussion = new DiscussionMoodleDTO();
    
                discussion.setIdThread(rs.getString("id"));
                discussion.setIdCourse(rs.getString("course"));
                discussion.setIdForum(rs.getString("forum"));
                discussion.setIdGroup(rs.getString("groupid"));                
                discussion.setIdUser(rs.getString("userid"));
                discussion.setTitle(rs.getString("name"));
                System.out.println(sqlOrder);                        
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return discussion;
    }
    
}
