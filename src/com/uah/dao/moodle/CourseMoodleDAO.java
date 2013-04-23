package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.CourseMoodleDTO;
import com.uah.items.Course;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class CourseMoodleDAO extends DAO{
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
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
                
                return null;
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return course;
    }
    
    
    /**
     * 
     * @return 
     */
    public List<CourseMoodleDTO> selectCourse(){
        CourseMoodleDTO course;
        List<CourseMoodleDTO> courses = new ArrayList<CourseMoodleDTO>();
        try {
            String sqlOrder = "SELECT id,fullname,shortname,summary FROM mdl_course";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            while(rs.next()){
                course = new CourseMoodleDTO();
                course.setId(rs.getString("id"));
                course.setFullname(rs.getString("fullname"));
                course.setShortname(rs.getString("shortname"));
                course.setSummary(rs.getString("summary")); 
                
                courses.add(course);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return courses;
    }
}
