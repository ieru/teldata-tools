/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.converters;

import com.uah.dto.modle.*;
import com.uah.items.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class MoodleConverter {
    
    /**
     * 
     * @param courseDTO
     * @return 
     */
   public Course getMoodleCourseItemFromCourseDTO(CourseMoodleDTO courseDTO){

        Course courseItem = new Course();   

        courseItem.setId(courseDTO.getId());
        courseItem.setFullname(courseDTO.getFullname());
        courseItem.setShortname(courseDTO.getShortname());
        courseItem.setSummary(courseDTO.getSummary());

        return courseItem;
   }
    
   
   /**
    * 
    * @param forumsDTO
    * @return 
    */
   public List<Forum> getMoodleForumsItemFromForumsDTO(List<ForumMoodleDTO> forumsDTO){

        Forum forumItem;  
        
        List<Forum> forums = new ArrayList<Forum>();

        for(ForumMoodleDTO dto : forumsDTO){  
            forumItem = new Forum();  
            
            forumItem.setDescription(dto.getIntro());
            forumItem.setIdCourse(dto.getCourseId());
            forumItem.setId(dto.getId());           
            forumItem.setTitle(dto.getName());
            forumItem.setType(dto.getType());
            
            forums.add(forumItem);
                    
        }
        
        return forums;
   }
   
   
   /**
    * 
    * @param discussionsDTO
    * @return 
    */
   public List<Discussion> getMoodleDiscussionsItemFromDiscussionsDTO(List<DiscussionMoodleDTO> discussionsDTO){

        Discussion discussionItem;  
        
        List<Discussion> discussions = new ArrayList<Discussion>();

        for(DiscussionMoodleDTO dto : discussionsDTO){  
            discussionItem = new Discussion();  
            
            discussionItem.setIdCourse(dto.getIdCourse());
            discussionItem.setIdForum(dto.getIdForum());
            discussionItem.setIdGroup(dto.getIdGroup());           
            discussionItem.setId(dto.getIdThread());
            discussionItem.setIdParticipant(dto.getIdUser());            
            discussionItem.setTitle(dto.getTitle());
            
            discussions.add(discussionItem);
                    
        }
        
        return discussions;
   }
   
   
   
   /**
    * 
    * @param postsDTO
    * @return 
    */
      public List<Post> getMoodlePostsItemFromPostsDTO(List<PostMoodleDTO> postsDTO){

        Post postItem;  
        
        List<Post> discussions = new ArrayList<Post>();

        for(PostMoodleDTO dto : postsDTO){  
            postItem = new Post();  
            
            postItem.setId(dto.getIdPost());
            postItem.setIdPostParent(dto.getIdPostParent());
            postItem.setIdDiscussion(dto.getIdThread());           
            postItem.setIdParticipant(dto.getIdUser());
            postItem.setMessage(dto.getMessage());            
            postItem.setSubject(dto.getSubject());
            
            discussions.add(postItem);                    
        }
        
        return discussions;
   }
      
            
     
      /**
       * 
       * @param participantsDTO
       * @return 
       */
      public List<Participant> getMoodleParticipantsItemFromParticipantsDTO(List<ParticipantMoodleDTO> participantsDTO){

        Participant participantItem;          
        List<Participant> participants = new ArrayList<Participant>();

        for(ParticipantMoodleDTO dto : participantsDTO){  
            
            participantItem = getMoodleParticipantItemFromParticipantDTO(dto);
                        
            participants.add(participantItem);                    
        }
        
        return participants;
   }


      
/**
 * 
 * @param participantDTO
 * @return 
 */
   public Participant getMoodleParticipantItemFromParticipantDTO(ParticipantMoodleDTO participantDTO){

        Participant participantItem;

        participantItem = new Participant();

        participantItem.setId(participantDTO.getId());
        participantItem.setAddress(participantDTO.getAddress());
        participantItem.setCity(participantDTO.getCity());
        participantItem.setCountry(participantDTO.getCountry());
        participantItem.setEmail(participantDTO.getEmail());
        participantItem.setFirstname(participantDTO.getFirstname());        
        participantItem.setLanguage(participantDTO.getLanguage());
        participantItem.setLastname(participantDTO.getLastname());
        participantItem.setUsername(participantDTO.getUsername());

        return participantItem;
   }
}
