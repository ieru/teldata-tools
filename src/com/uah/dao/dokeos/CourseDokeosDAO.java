/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.dokeos;


import com.uah.dao.DAO;
import com.uah.dto.dokeos.CourseDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class CourseDokeosDAO extends DAO{
    
    /**
     * 
     * @param connection 
     */
    public CourseDokeosDAO(Connection connection){
        super(connection);
    }
    
    /**
     * 
     * @param idCourse
     * @return 
     */
    public CourseDokeosDTO selectCourse(String idCourse){
        CourseDokeosDTO course = new CourseDokeosDTO();
        
        try {
            String sqlOrder = "SELECT code, db_name, title, description, course_language, db_name FROM dokeos_main.course WHERE code='"+idCourse+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            if(rs.next()){              
                course.setCode(rs.getString("code"));
                course.setDb_name(rs.getString("db_name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));    

            }   else{
                System.out.println("Course with ID="+idCourse+" doesn`t exist.");
                return null;
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return course;
    }
    
    
    public List<CourseDokeosDTO>selectCourses(){
        List<CourseDokeosDTO> courses = new ArrayList();
        CourseDokeosDTO course;
        
        try {
            String sqlOrder = "SELECT code, db_name, title, description, course_language, db_name FROM dokeos_main.course";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            if(rs.next()){    
                course = new CourseDokeosDTO();
                course.setCode(rs.getString("code"));
                course.setDb_name(rs.getString("db_name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));    
                
                
                courses.add(course);
            }   else{
                return null;
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return courses;
    }
    
}
