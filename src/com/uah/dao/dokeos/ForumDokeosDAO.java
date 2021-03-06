package com.uah.dao.dokeos;

import com.uah.dao.DAO;
import com.uah.dto.dokeos.ForumDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class ForumDokeosDAO  extends DAO{

    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public ForumDokeosDAO(Connection connection){
        super(connection);
    }
    
    /**
     * 
     * @param db_name
     * @return 
     */
    public List<ForumDokeosDTO> selectForums(String db_name){
        ForumDokeosDTO forum;
        List<ForumDokeosDTO> forums = new ArrayList<ForumDokeosDTO>();
        
        try {
            /*
                SELECT forum_id, forum_title, forum_group_public_private, forum_category, cat_title, cat_comment 
                FROM dokeos_CURSODEPRUEBADOS.forum_forum 
                LEFT JOIN dokeos_CURSODEPRUEBADOS.forum_category 
                ON dokeos_CURSODEPRUEBADOS.forum_forum.forum_category = dokeos_CURSODEPRUEBADOS.forum_category.cat_id 
             */
            String sqlOrder = "SELECT forum_id, forum_title, forum_group_public_private, forum_category, cat_title, cat_comment "
                +"FROM "+db_name+".forum_forum "
                +"LEFT JOIN "+db_name+".forum_category "
                +"ON "+db_name+".forum_forum.forum_category = "+db_name+".forum_category.cat_id";            
            statement = connection.createStatement();            
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                forum = new ForumDokeosDTO();
                forum.setId(rs.getString("forum_id"));
                forum.setPublicPrivate(rs.getString("forum_group_public_private"));
                forum.setTitle(rs.getString("forum_title"));               
                forum.setCategory(rs.getString("cat_title")+" "+rs.getString("cat_comment"));
                forum.setDb_name(db_name);
                
                forums.add(forum);
            }   
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return forums;
    }
    
    
/**
 * 
 * @param db_name
 * @param id
 * @return 
 */
    public ForumDokeosDTO selectForumsById(String db_name, String id){
        ForumDokeosDTO forum = new ForumDokeosDTO();
                
        try {

            String sqlOrder = "SELECT forum_id, forum_title, forum_group_public_private, forum_category, cat_title, cat_comment "
                +"FROM "+db_name+".forum_forum "
                +"LEFT JOIN "+db_name+".forum_category "
                +"ON "+db_name+".forum_forum.forum_category = "+db_name+".forum_category.cat_id"
                +"WHERE forum_id=='"+id+"'";     
            
            statement = connection.createStatement();            
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                forum = new ForumDokeosDTO();
                forum.setId(rs.getString("forum_id"));
                forum.setPublicPrivate(rs.getString("forum_group_public_private"));
                forum.setTitle(rs.getString("forum_title"));               
                forum.setCategory(rs.getString("cat_title")+" "+rs.getString("cat_comment"));
                forum.setDb_name(db_name);
               
            }               
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return forum;
    }
    
    
}
