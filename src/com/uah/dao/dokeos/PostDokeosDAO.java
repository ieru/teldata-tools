package com.uah.dao.dokeos;

import com.uah.dao.DAO;
import com.uah.dto.dokeos.PostDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class PostDokeosDAO  extends DAO{
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public PostDokeosDAO(Connection connection){
        super(connection);
    }
    
    
    public List<PostDokeosDTO> selectPosts(String db_name, String idThread){
        PostDokeosDTO post;
        List<PostDokeosDTO> posts = new ArrayList<PostDokeosDTO>();
        
        try {
            String sqlOrder = "SELECT post_id, post_title, post_text, thread_id, forum_id, poster_id, post_parent_id, post_date FROM "+db_name+".forum_post WHERE thread_id ="+idThread;            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                post = new PostDokeosDTO();
    
                post.setId(rs.getString("post_id"));
                post.setIdThread(rs.getString("forum_id"));
                post.setPostParentId(rs.getString("post_parent_id"));                
                post.setIdUser(rs.getString("poster_id"));
                post.setPostText(rs.getString("post_text"));  
                post.setTitle(rs.getString("post_title"));  
                post.setDb_name(db_name);
                post.setPost_date(rs.getString("post_date"));
                
                posts.add(post);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return posts;
    }
    
    
    /**
     * 
     * @param db_name
     * @return 
     */
    public List<PostDokeosDTO> selectPosts(String db_name){
        PostDokeosDTO post;
        List<PostDokeosDTO> posts = new ArrayList<PostDokeosDTO>();
        
        try {
            String sqlOrder = "SELECT post_id, post_title, post_text, thread_id, forum_id, poster_id, post_parent_id FROM "+db_name+".forum_post";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                post = new PostDokeosDTO();
    
                post.setId(rs.getString("post_id"));
                post.setIdThread(rs.getString("forum_id"));
                post.setPostParentId(rs.getString("post_parent_id"));   
                post.setIdUser(rs.getString("poster_id"));
                post.setPostText(rs.getString("post_text"));  
                post.setTitle(rs.getString("post_title"));  
                post.setDb_name(db_name);
                                
                posts.add(post);                
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return posts;
    }
    
    /**
     * 
     * @param db_name
     * @return 
     */
    public PostDokeosDTO selectPostById(String db_name, String idPost){
        PostDokeosDTO post = new PostDokeosDTO();
               
        try {
            String sqlOrder = "SELECT post_id, post_title, post_text, thread_id, forum_id, poster_id, post_parent_id FROM "+db_name+".forum_post WHERE post_id='"+idPost+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            if(rs.next()){   
                post = new PostDokeosDTO();
    
                post.setId(rs.getString("post_id"));
                post.setIdThread(rs.getString("forum_id"));
                post.setPostParentId(rs.getString("post_parent_id"));   
                post.setIdUser(rs.getString("poster_id"));
                post.setPostText(rs.getString("post_text"));  
                post.setTitle(rs.getString("post_title"));  
                post.setDb_name(db_name);
                               
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return post;
    }
}
