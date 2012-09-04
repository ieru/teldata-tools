/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.items;


import java.sql.Connection;
import com.uah.exceptions.OperationNotSupportedException;
import com.uah.graph.MavselVertex;
import edu.uci.ics.jung.graph.Graph;
import java.util.List;


/**
 *
 * @author Pablo
 */
public interface LMS{
             
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/       
    public abstract void configureLMS(String dataBaseURL, String dataBasePort, 
            String dataBaseName, String dataBaseUser, String dataBaseUserPass) throws Exception;      
    
    public abstract void configureLMS(Connection connection); 
    
    public abstract Course getCourse(String id);
    
    public abstract List<Course> getCourse();
    
    public abstract List<Forum> getForums();
    
    public abstract Forum getForum(String idForum);
    
    public abstract List<Forum> getForums(Course course);
    
    public abstract List<Discussion> getDiscussions();
    
    public abstract Discussion getDiscussion(String idDiscussion);
    
    public abstract List<Discussion> getDiscussions(Forum forum);      
    
    public abstract List<Post> getPosts();
    
    public abstract Post getPost(String idPost);
    
    public abstract List<Post> getPosts(Discussion discussion);
    
    public abstract List<Participant> getParticipants();
    
    public abstract Participant getParticipant(String idParticipant);

    public abstract Graph<MavselVertex, String> getParticipantForumGraph(Course course);

    public abstract Graph<MavselVertex, String> getParticipantForumGraph(List<Forum>forums);
     
    public abstract void getForumRaitingInRFile(String filename) throws OperationNotSupportedException;
    
    public abstract Connection getConnection();
    
    public List<PostRating> getPostRating();
             
    public List<PostRating> getPostRating(String idPost);

}
