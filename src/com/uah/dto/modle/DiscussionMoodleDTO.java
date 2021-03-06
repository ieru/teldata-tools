
package com.uah.dto.modle;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class DiscussionMoodleDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String idCourse;
    private String idForum;
    private String idThread;
    private String idGroup;
    private String idUser;    
    private String title;
    

    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdForum() {
        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getIdThread() {
        return idThread;
    }

    public void setIdThread(String idThread) {
        this.idThread = idThread;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
        
}
