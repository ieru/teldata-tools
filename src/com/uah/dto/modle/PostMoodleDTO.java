/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dto.modle;

/**
 *
 * @author Pablo
 */
public class PostMoodleDTO {
    
    private String idPost;
    private String idThread;
    private String idPostParent;
    private String idUser;
    
    private String subject;
    private String message;

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getIdPostParent() {
        return idPostParent;
    }

    public void setIdPostParent(String idPostParent) {
        this.idPostParent = idPostParent;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
}
