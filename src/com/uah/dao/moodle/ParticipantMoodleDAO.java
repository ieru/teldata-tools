/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao.moodle;

import com.uah.dao.DAO;
import com.uah.dto.modle.ParticipantMoodleDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class ParticipantMoodleDAO extends DAO{
    
    public ParticipantMoodleDAO(Connection connection){
        super(connection);
    }
    
    
    public ParticipantMoodleDTO selectParticipant(String idParticipant){
        ParticipantMoodleDTO participant = new ParticipantMoodleDTO();
               
        try {
            String sqlOrder = "SELECT id, username, firstname, lastname, email, address, city,country, lang FROM mdl_user  WHERE id ='"+idParticipant+"'";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            if(rs.next()){
                participant = new ParticipantMoodleDTO();
    
                participant.setId(rs.getString("id"));
                participant.setAddress(rs.getString("address"));
                participant.setCity(rs.getString("city"));                
                participant.setCountry(rs.getString("country"));
                participant.setEmail(rs.getString("email"));
                participant.setFirstname(rs.getString("firstname"));                
                participant.setLanguage(rs.getString("lang"));
                participant.setLastname(rs.getString("lastname"));
                participant.setUsername(rs.getString("username"));
                                             
            }               
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return participant;
    }
    
    
    
    public List<ParticipantMoodleDTO> selectParticipants(){
        ParticipantMoodleDTO participant;
        List<ParticipantMoodleDTO> participants = new ArrayList<ParticipantMoodleDTO>();
        
        try {
            String sqlOrder = "SELECT id, username, firstname, lastname, email, address, city,country, lang FROM mdl_user";            
            statement = connection.createStatement();
            rs = statement.executeQuery( sqlOrder );
            
            while(rs.next()){   
                participant = new ParticipantMoodleDTO();
    
                participant.setId(rs.getString("id"));
                participant.setAddress(rs.getString("address"));
                participant.setCity(rs.getString("city"));                
                participant.setCountry(rs.getString("country"));
                participant.setEmail(rs.getString("email"));
                participant.setFirstname(rs.getString("firstname"));                
                participant.setLanguage(rs.getString("lang"));
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
