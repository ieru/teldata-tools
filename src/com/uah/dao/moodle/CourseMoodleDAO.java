/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.CourseMoodleDTO;
import java.sql.Connection;

/**
 *
 * @author Pablo
 */
public class CourseMoodleDAO extends DAO{
    
    /**
     * 
     * @param connection 
     */
    public CourseMoodleDAO(Connection connection){
        super(connection);
    }
    
    /**
     * 
     * @param idCourse
     * @return 
     */
    public CourseMoodleDTO selectCourse(String idCourse){
        CourseMoodleDTO course = new CourseMoodleDTO();
        
        try {
            String sqlOrder = "SELECT id,fullname,shortname,summary FROM mdl_course WHERE id='"+idCourse+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            if(rs.next()){              
                course.setId(rs.getString("id"));
                course.setFullname(rs.getString("fullname"));
                course.setShortname(rs.getString("shortname"));
                course.setSummary(rs.getString("summary"));               
            }   else{
                System.out.println("Course with ID="+idCourse+" doesn`t exist.");
                return null;
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return course;
    }
    
    
    
}
