/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.ForumMoodleDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class ForumMoodleDAO extends DAO{
 
    public ForumMoodleDAO(Connection connection){
        super(connection);
    }
    
    
    /**
     * 
     * @param idCourse
     * @return 
     */
    public List<ForumMoodleDTO> selectForums(String idCourse){
        ForumMoodleDTO forum;
        List<ForumMoodleDTO> forums = new ArrayList<ForumMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id, type, name, course, intro FROM moodle.mdl_forum WHERE course ='"+idCourse+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                forum = new ForumMoodleDTO();
                forum.setId(rs.getString("id"));
                forum.setType(rs.getString("type"));
                forum.setName(rs.getString("name"));
                forum.setIntro(rs.getString("intro"));
                forum.setCourseId(rs.getString("course"));
                
                forums.add(forum);
                
            }   
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return forums;
    }
    
    
    /**
     * 
     * @return 
     */
    public List<ForumMoodleDTO> selectForums(){
        ForumMoodleDTO forum;
        List<ForumMoodleDTO> forums = new ArrayList<ForumMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id, type, name, course, intro FROM moodle.mdl_forum";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            
            while(rs.next()){   
                forum = new ForumMoodleDTO();
                forum.setId(rs.getString("id"));
                forum.setType(rs.getString("type"));
                forum.setName(rs.getString("name"));
                forum.setIntro(rs.getString("intro"));
                forum.setCourseId(rs.getString("course"));
                
                forums.add(forum);                
            }               
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return forums;
    }
    
}
