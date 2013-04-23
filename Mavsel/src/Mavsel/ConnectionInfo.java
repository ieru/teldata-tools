/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

/**
 *
 * @author ie
 */
public class ConnectionInfo {    
    private String url;
    private String port ;
    private String user ;
    private String platform;
    private String password;
    private String course_id;

    public ConnectionInfo() {
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
        
        
    
}
