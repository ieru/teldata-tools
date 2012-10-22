package com.uah.dao.dokeos;


import com.uah.dao.DAO;
import com.uah.dto.dokeos.CourseDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class CourseDokeosDAO extends DAO{
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
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
                
                return null;
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return course;
    }
    
    
    /**
     * 
     * @param idCourse
     * @return 
     */
    public List<CourseDokeosDTO>  selectCourse(){
        CourseDokeosDTO course = new CourseDokeosDTO();
         List<CourseDokeosDTO> courses = new ArrayList<CourseDokeosDTO>();
        try {
            String sqlOrder = "SELECT code, db_name, title, description, course_language, db_name FROM dokeos_main.course";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

             while(rs.next()){           
                course.setCode(rs.getString("code"));
                course.setDb_name(rs.getString("db_name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description")); 
                
                courses.add(course);
            }   
             
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return courses;
    }
    
    /**
     * 
     * @return 
     */
    public List<CourseDokeosDTO>selectCourses(){
        List<CourseDokeosDTO> courses = new ArrayList();
        CourseDokeosDTO course;
        
        try {
            String sqlOrder = "SELECT code, db_name, title, description, course_language, db_name FROM dokeos_main.course";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );

            while(rs.next()){    
                course = new CourseDokeosDTO();
                course.setCode(rs.getString("code"));
                course.setDb_name(rs.getString("db_name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));    
                                
                courses.add(course);
            }        
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return courses;
    }
    
}
