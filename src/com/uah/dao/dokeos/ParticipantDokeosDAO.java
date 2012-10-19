package com.uah.dao.dokeos;

import com.uah.dao.DAO;
import com.uah.dto.dokeos.ParticipantDokeosDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class ParticipantDokeosDAO  extends DAO{
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public ParticipantDokeosDAO(Connection connection){
        super(connection);
    }
    
    
    /**
     * 
     * @param idParticipant
     * @return 
     */
    public ParticipantDokeosDTO selectParticipant(String idParticipant){
        ParticipantDokeosDTO participant = new ParticipantDokeosDTO();
               
        try {
            String sqlOrder = "SELECT user_id, lastname, firstname, username, email, language FROM dokeos_main.user WHERE user_id="+idParticipant;            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            if(rs.next()){
                participant = new ParticipantDokeosDTO();
    
                participant.setId(rs.getString("user_id"));
                participant.setEmail(rs.getString("email"));
                participant.setFirstname(rs.getString("firstname"));                
                participant.setLanguage(rs.getString("language"));
                participant.setLastname(rs.getString("lastname"));
                participant.setUsername(rs.getString("username"));
                                             
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return participant;
    }
    
    
    
    /**
     * 
     * @return 
     */
    public List<ParticipantDokeosDTO> selectParticipants(){
        ParticipantDokeosDTO participant;
        List<ParticipantDokeosDTO> participants = new ArrayList<ParticipantDokeosDTO>();
        
        try {
            String sqlOrder = "SELECT user_id, lastname, firstname, username, email, language FROM dokeos_main.user;";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                participant = new ParticipantDokeosDTO();
    
                participant.setId(rs.getString("id"));
                participant.setEmail(rs.getString("email"));
                participant.setFirstname(rs.getString("firstname"));                
                participant.setLanguage(rs.getString("language"));
                participant.setLastname(rs.getString("lastname"));
                participant.setUsername(rs.getString("username"));
                
                participants.add(participant);
              
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return participants;
    }
    
}
