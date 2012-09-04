/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.PostRatingMoodleDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class PostRatingMoodleDAO  extends DAO{
    
     public PostRatingMoodleDAO(Connection connection){
        super(connection);
    }
     
     /**
      * 
      * @return 
      */
     public List<PostRatingMoodleDTO> selectPostRating(){
         PostRatingMoodleDTO rating;
        List<PostRatingMoodleDTO> ratings = new ArrayList<PostRatingMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT mdl_rating.itemid, mdl_rating.scaleid, mdl_rating.rating, mdl_rating.userid, mdl_forum_discussions.course, mdl_forum_discussions.forum, mdl_role.id roleid, mdl_role.name, mdl_forum.name "
                    + " FROM mdl_rating, mdl_forum_posts,mdl_forum_discussions, mdl_user, mdl_role_assignments, mdl_role,mdl_forum "
                    + " WHERE mdl_rating.ratingarea = 'post'"
                    + " AND mdl_rating.itemid = mdl_forum_posts.id"
                    + " AND mdl_forum_posts.discussion = mdl_forum_discussions.id"
                    + " AND mdl_rating.userid = mdl_user.id"
                    + " AND mdl_role_assignments.userid = mdl_user.id"
                    + " AND mdl_role_assignments.roleid = mdl_role.id"
                    + " AND mdl_forum.id = mdl_forum_discussions.forum";        
            System.out.println(sqlOrder);
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                rating = new PostRatingMoodleDTO();
    
                rating.setCourseid(rs.getString("mdl_forum_discussions.course")) ;
                rating.setForumid(rs.getString("mdl_forum_discussions.forum"));
                rating.setPostid(rs.getString("mdl_rating.itemid"));
                rating.setRating(rs.getString("mdl_rating.rating"));                
                rating.setRoleid(rs.getString("roleid"));
                rating.setRolename(rs.getString("mdl_role.name"));
                rating.setScaleid(rs.getString("mdl_rating.scaleid"));
                rating.setUserid(rs.getString("mdl_rating.userid"));
                rating.setForumName(rs.getString("mdl_forum.name"));
                
                ratings.add(rating);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return ratings;
     }
     
    
     /**
      * 
      * @param idPostRating
      * @return 
      */
     public List<PostRatingMoodleDTO> selectPostRating(String idPostRating){
         PostRatingMoodleDTO rating;
        List<PostRatingMoodleDTO> ratings = new ArrayList<PostRatingMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT mdl_rating.itemid, mdl_rating.scaleid, mdl_rating.rating, mdl_rating.userid, mdl_forum_discussions.course, mdl_forum_discussions.forum, mdl_role.id roleid, mdl_role.name, mdl_forum.name "
                    + " FROM mdl_rating, mdl_forum_posts,mdl_forum_discussions, mdl_user, mdl_role_assignments, mdl_role,mdl_forum "
                    + " WHERE mdl_rating.ratingarea = 'post'"
                    + " AND mdl_rating.itemid = mdl_forum_posts.id"
                    + " AND mdl_forum_posts.id ='"+idPostRating+"'"
                    + " AND mdl_forum_posts.discussion = mdl_forum_discussions.id"
                    + " AND mdl_rating.userid = mdl_user.id"
                    + " AND mdl_role_assignments.userid = mdl_user.id"
                    + " AND mdl_role_assignments.roleid = mdl_role.id"
                    + " AND mdl_forum.id = mdl_forum_discussions.forum";        
            System.out.println(sqlOrder);
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                rating = new PostRatingMoodleDTO();
    
                rating.setCourseid(rs.getString("mdl_forum_discussions.course")) ;
                rating.setForumid(rs.getString("mdl_forum_discussions.forum"));
                rating.setPostid(rs.getString("mdl_rating.itemid"));
                rating.setRating(rs.getString("mdl_rating.rating"));                
                rating.setRoleid(rs.getString("roleid"));
                rating.setRolename(rs.getString("mdl_role.name"));
                rating.setScaleid(rs.getString("mdl_rating.scaleid"));
                rating.setUserid(rs.getString("mdl_rating.userid"));
                rating.setForumName(rs.getString("mdl_forum.name"));
                
                ratings.add(rating);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return ratings;
     }
}
