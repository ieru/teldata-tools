package com.uah.dto.modle;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class ForumMoodleDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String id;
    private String courseId;
    private String type;
    private String name;
    private String intro;

    
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
    
    

    /**************************************************************************
    *                              getters & setters
    **************************************************************************/


    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
        
}
