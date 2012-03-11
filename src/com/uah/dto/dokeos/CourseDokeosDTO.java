/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dto.dokeos;


/**
 *
 * @author Pablo
 */
public class CourseDokeosDTO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    String code;
    String db_name;
    String title;
    String description;
   

    /**************************************************************************
    *                              getters & setters
    **************************************************************************/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
