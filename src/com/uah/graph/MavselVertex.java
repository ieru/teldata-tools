/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.graph;

/**
 *
 * @author Pablo
 */
public class MavselVertex {
    private String id;
    private String description;
    private boolean type;
    public static boolean IS_USER = true;
    public static boolean IS_FORUM = false;

    
    /**
     *
     * @param description
     * @param type
     * @param id
     */
    public MavselVertex(String description, boolean type, String id) {
        this.description = description;
        this.type = type;
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (type) {
            return "User " + id + ": " + description;
        } else {
            return "Forum " + id + ": " + description;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public boolean getType() {
        return type;
    }
}
