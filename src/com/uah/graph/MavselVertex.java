
package com.uah.graph;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class MavselVertex {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String id;
    private String description;
    private boolean type;
    public static boolean IS_USER = true;
    public static boolean IS_FORUM = false;
    public static String USER_TOSTRING_INIT = "Vertex-UserId[";
    public static String FORUM_TOSTRING_INIT = "Vertex-ForumId[";
    public static String USER_LABEL = "] UserLabel:: ";
    public static String FORUM_LABEL = "] ForumLabel:: ";

    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
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
            return USER_TOSTRING_INIT + id + USER_LABEL + description;
        } else {
            return FORUM_TOSTRING_INIT + id + FORUM_LABEL + description;
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
