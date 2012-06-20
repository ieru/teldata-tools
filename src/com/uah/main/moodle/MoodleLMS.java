/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.main.moodle;





import com.uah.commons.DataBaseConnectionParameters;
import com.uah.commons.DataBaseManagement;
import com.uah.commons.FileRProcessor;
import com.uah.converters.MoodleConverter;
import com.uah.dao.moodle.*;
import com.uah.dto.modle.*;
import com.uah.exceptions.ConnectionParametersException;
import com.uah.exceptions.OperationNotSupportedException;
import com.uah.graph.MavselGraphManager;
import com.uah.graph.MavselVertex;
import com.uah.items.*;
import edu.uci.ics.jung.graph.Graph;
import java.util.List;



/**
 *
 * @author Pablo
 */
public class MoodleLMS extends DataBaseManagement implements LMS {
    
    
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private MoodleConverter converter;
    private MavselGraphManager graphManager;

        
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
    /**
     * Constructor
     */
    public MoodleLMS(){      
        this.converter = new MoodleConverter();
        this.graphManager = new MavselGraphManager();
    }
        
    
    /**
     * Constructor
     * @param dataBaseURL
     * @param dataBasePort
     * @param dataBaseName
     * @param dataBaseUser
     * @param dataBaseUserPass 
     */
    public MoodleLMS(String dataBaseURL, String dataBasePort, 
            String dataBaseName, String dataBaseUser, String dataBaseUserPass){
        try{
            // Database parameters
            DataBaseConnectionParameters dbConnectionParams = new DataBaseConnectionParameters(dataBaseURL, dataBasePort, 
                    dataBaseName, dataBaseUser, dataBaseUserPass);
            // Checking database`s parameters
            dbConnectionParams.checkParams();
            
            // Configuring database and initializing connection
            initDataBaseConnection(dbConnectionParams);
            
            this.converter = new MoodleConverter();
            this.graphManager = new MavselGraphManager();
                                   
        }catch( Exception e ) {
            e.printStackTrace();
        }          
    }
        
    
    
        
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
    
    /**
     * 
     * @param dataBaseURL
     * @param dataBasePort
     * @param dataBaseName
     * @param dataBaseUser
     * @param dataBaseUserPass
     * @throws ConnectionParametersException
     */
    @Override
    public void configureLMS(String dataBaseURL, String dataBasePort, 
        String dataBaseName, String dataBaseUser, String dataBaseUserPass) throws ConnectionParametersException{

        // Saving database`s parameters
        DataBaseConnectionParameters dbConnectionParams = new DataBaseConnectionParameters(dataBaseURL, dataBasePort, 
                dataBaseName, dataBaseUser, dataBaseUserPass);

        // Checking database`s parameters
        dbConnectionParams.checkParams();

        // Configuring database and initializing connection
        initDataBaseConnection(dbConnectionParams);                                   
                
    }
    
       
    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Course getCourse(String id){
        Course course;
        CourseMoodleDAO courseDAO = new CourseMoodleDAO(connection);
        CourseMoodleDTO courseDTO = courseDAO.selectCourse(id);

        course = converter.getMoodleCourseItemFromCourseDTO(courseDTO);

        return course;       
    }
 

    /**
     *
     * @return
     */
    @Override
    public List<Forum> getForums(){
       List<ForumMoodleDTO> forumsDTO;
       List<Forum> forums;
       ForumMoodleDAO forumDAO = new ForumMoodleDAO(connection);
       forumsDTO = forumDAO.selectForums();

       forums = converter.getMoodleForumsItemFromForumsDTO(forumsDTO);
       
       return forums;      
   }
    
    

    /**
     *
     * @param idcourse
     * @return
     */
    @Override
   public List<Forum> getForums(Course course){
       List<ForumMoodleDTO> forumsDTO;
       List<Forum> forums;
       ForumMoodleDAO forumDAO = new ForumMoodleDAO(connection);
       forumsDTO = forumDAO.selectForums(course.getId());

       forums = converter.getMoodleForumsItemFromForumsDTO(forumsDTO);
       
       return forums;       
   }
   

    /**
     *
     * @return
     */
    @Override
    public List<Discussion> getDiscussions( ){
       List<DiscussionMoodleDTO> discussionsDTO;
       List<Discussion> discussions;
       DiscussionMoodleDAO discussionDAO = new DiscussionMoodleDAO(connection);
       discussionsDTO = discussionDAO.selectDiscussions();

       discussions = converter.getMoodleDiscussionsItemFromDiscussionsDTO(discussionsDTO);
       
       return discussions;       
   }  
    


    /**
     *
     * @param idForum
     * @return
     */
    @Override
    public List<Discussion> getDiscussions(Forum forum){
       List<DiscussionMoodleDTO> discussionsDTO;
       List<Discussion> discussions;
       DiscussionMoodleDAO discussionDAO = new DiscussionMoodleDAO(connection);
       discussionsDTO = discussionDAO.selectDiscussions(forum.getId());

       discussions = converter.getMoodleDiscussionsItemFromDiscussionsDTO(discussionsDTO);
       
       return discussions;       
   }
    

    /**
     *
     * @return
     */
     @Override
    public List<Post> getPosts(){
       List<PostMoodleDTO> postsDTO;
       List<Post> posts;
       PostMoodleDAO postDAO = new PostMoodleDAO(connection);
       postsDTO = postDAO.selectPosts();

       posts = converter.getMoodlePostsItemFromPostsDTO(postsDTO);
       
       return posts;       
   }
    
    
    /**
     *
     * @param idDiscussion
     * @return
     */
    @Override
    public List<Post> getPosts(Discussion discussion){
       List<PostMoodleDTO> postsDTO;
       List<Post> posts;
       PostMoodleDAO postDAO = new PostMoodleDAO(connection);
       postsDTO = postDAO.selectPosts(discussion.getId());

       posts = converter.getMoodlePostsItemFromPostsDTO(postsDTO);
       
       return posts;       
   }


    /**
     *
     * @return
     */
    @Override
    public List<Participant> getParticipants(){
       List<ParticipantMoodleDTO> participantsDTO;
       List<Participant> participants;
       ParticipantMoodleDAO participantDAO = new ParticipantMoodleDAO(connection);
       participantsDTO = participantDAO.selectParticipants();

       participants = converter.getMoodleParticipantsItemFromParticipantsDTO(participantsDTO);
       
       return participants;       
   }   


    /**
     *
     * @param idParticipant
     * @return
     */
    @Override
    public Participant getParticipant(String idParticipant){
       ParticipantMoodleDTO participantDTO;
       Participant participant;
       ParticipantMoodleDAO participantDAO = new ParticipantMoodleDAO(connection);
       participantDTO = participantDAO.selectParticipant(idParticipant);

       participant = converter.getMoodleParticipantItemFromParticipantDTO(participantDTO);
       
       return participant;
   }


    /**
     * 
     * @return 
     */
    @Override
    public void getForumRaitingInRFile(String filename)throws OperationNotSupportedException{
        List <PostRatingMoodleDTO> ratingsDTO;
        List <PostRating> ratingsItem;
        PostRatingMoodleDAO dao = new PostRatingMoodleDAO(connection);
        
        ratingsDTO = dao.selectPostRating();
        
        ratingsItem = converter.getMoodlePostRatingsFromPostRatingsDTO(ratingsDTO);
        
        FileRProcessor fileRProcessor = new FileRProcessor();
        fileRProcessor.printIntoFile(filename, ratingsItem);
                    
    }


    /**
     *
     * @param course
     * @return
     */
    @Override
    public Graph<MavselVertex, String> getParticipantForumGraph(Course course){
        graphManager = new MavselGraphManager();
        
        return graphManager.getParticipantForumGraph(course, this);
    }


    /**
     *
     * @param forums
     * @return
     */
    @Override
    public Graph<MavselVertex, String> getParticipantForumGraph(List<Forum>forums){
        graphManager = new MavselGraphManager();

        return graphManager.getParticipantForumGraph(forums, this);
    }
  

    
    /*
    private MavselVertex searchVertex (MavselVertex vertex){

        Collection<MavselVertex> vertices = graph.getVertices();
        Iterator iter = vertices.iterator();
    
        MavselVertex compareVertex = null;
        while(iter.hasNext()){
            compareVertex = (MavselVertex)iter.next();
            if (compareVertex.getId().equalsIgnoreCase(vertex.getId()) &&  vertex.getType() == compareVertex.getType()){

                //Vertex alredy exists
                return vertex;
            }
        }
        
        //Vertex does not exists
        return null;
    }
     * */
     
}
   
   
