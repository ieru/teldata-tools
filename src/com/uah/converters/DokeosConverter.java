/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.converters;


import com.uah.dto.dokeos.*;
import com.uah.dto.modle.CourseMoodleDTO;
import com.uah.items.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class DokeosConverter {
    
    /**
     * 
     */
    public DokeosConverter(){
        
    }
    
    
    /**
     * 
     * @param courseDTO
     * @return 
     */
   public Course getDokeoseCourseItemFromCourseDTO(CourseDokeosDTO courseDTO){

        Course courseItem = new Course();   

        courseItem.setId(courseDTO.getCode());
        courseItem.setFullname(courseDTO.getTitle());
        courseItem.setShortname("");
        courseItem.setSummary(courseDTO.getDescription());
        courseItem.setConfigExtraData(courseDTO.getDb_name());

        return courseItem;
   }
   
   
   /**
    * 
    * @param coursesDTO
    * @return 
    */
   public List<Course> getDokeoseCourseItemFromCourseDTO(List<CourseDokeosDTO> coursesDTO){       
        Course courseItem = new Course();   
        List<Course> courses = new ArrayList<Course>();   

        for(CourseDokeosDTO courseDTO: coursesDTO){
            
            courseItem.setId(courseDTO.getCode());
            courseItem.setFullname(courseDTO.getTitle());
            courseItem.setShortname("");
            courseItem.setSummary(courseDTO.getDescription());
            courseItem.setConfigExtraData(courseDTO.getDb_name());
            
            courses.add(courseItem);
        }        

        return courses;
   }
   
   /**
    * 
    * @param forumsDTO
    * @return 
    */
   public List<Forum> getDokeosForumsItemFromForumsDTO(List<ForumDokeosDTO> forumsDTO){
       
       Forum forumItem;  
        
        List<Forum> forums = new ArrayList<Forum>();

        for(ForumDokeosDTO dto : forumsDTO){  
            forumItem = new Forum();  
                    
            forumItem.setIdCourse(dto.getCourseId());
            forumItem.setId(dto.getId());           
            forumItem.setTitle(dto.getTitle());
            forumItem.setType(dto.getPublicPrivate());
            forumItem.setConfigExtraData(dto.getDb_name());
            
            forums.add(forumItem);
                    
        }
        
        return forums;       
   }
   
   
   
   /**
    * 
    * @param discussionsDTO
    * @return 
    */
   public List<Discussion> getDokeosDiscussionsItemFromDiscussionsDTO(List<DiscussionDokeosDTO> discussionsDTO){
       Discussion discussionItem;  
        
        List<Discussion> discussions = new ArrayList<Discussion>();

        for(DiscussionDokeosDTO dto : discussionsDTO){  
            discussionItem = new Discussion();  
            
            discussionItem.setIdForum(dto.getForum_id());    
            discussionItem.setId(dto.getId());                   
            discussionItem.setTitle(dto.getThread_title());
            discussionItem.setConfigExtraData(dto.getDb_name());
            discussionItem.setIdParticipant(dto.getUser_id());
            discussions.add(discussionItem);
                    
        }
        
        return discussions;
   }
   
   

   /**
    * 
    * @param postsDTO
    * @return 
    */
      public List<Post> getDokeosPostsItemFromPostsDTO(List<PostDokeosDTO> postsDTO){

        Post postItem;  
        
        List<Post> discussions = new ArrayList<Post>();

        for(PostDokeosDTO dto : postsDTO){  
            postItem = new Post();  
            
            postItem.setId(dto.getId());
            postItem.setIdPostParent(dto.getPostParentId());
            postItem.setIdDiscussion(dto.getIdThread());           
            postItem.setIdParticipant(dto.getIdUser());
            postItem.setMessage(dto.getPostText());            
            postItem.setSubject(dto.getTitle());
            postItem.setCreatedTime(dto.getPost_date());
            
            
            discussions.add(postItem);                    
        }
        
        return discussions;
   }
      
      
      
      /**
       * 
       * @param participantsDTO
       * @return 
       */
      public List<Participant> getDokeosParticipantsItemFromParticipantsDTO(List<ParticipantDokeosDTO> participantsDTO){

        Participant participantItem;          
        List<Participant> participants = new ArrayList<Participant>();

        for(ParticipantDokeosDTO dto : participantsDTO){  
            participantItem = getDokeosParticipantItemFromParticipantDTO(dto);                        
            participants.add(participantItem);                    
        }
        
        return participants;
   }
      
      
      /**
       * 
       * @param participantDTO
       * @return 
       */
      public Participant getDokeosParticipantItemFromParticipantDTO(ParticipantDokeosDTO participantDTO){

        Participant participantItem;

        participantItem = new Participant();

        participantItem.setId(participantDTO.getId());
        participantItem.setEmail(participantDTO.getEmail());
        participantItem.setFirstname(participantDTO.getFirstname());        
        participantItem.setLanguage(participantDTO.getLanguage());
        participantItem.setLastname(participantDTO.getLastname());
        participantItem.setUsername(participantDTO.getUsername());

        return participantItem;
   }
   
}
