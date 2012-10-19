package com.uah.dto.dokeos;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class ForumDokeosDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String id;
    private String publicPrivate;
    private String title;
    private String courseId;
    private String category;
    private String db_name;

    
    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(String publicPrivate) {
        this.publicPrivate = publicPrivate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    
        
    
}
