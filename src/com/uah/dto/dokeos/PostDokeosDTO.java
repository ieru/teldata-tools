package com.uah.dto.dokeos;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class PostDokeosDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String id;
    private String idThread;
    private String postParentId;
    private String idUser;    
    private String title;
    private String postText;    
    private String db_name;
    private String post_date;

    
    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPostParentId() {
        return postParentId;
    }

    public void setPostParentId(String postParentId) {
        this.postParentId = postParentId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }


   
    
}
