/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import com.uah.graph.MavselVertex;
import com.uah.graph.MavselEdge;
import com.uah.graph.PajekAdapter;
import com.uah.graph.SoniaAdapter;
import com.uah.items.*;
import com.uah.main.dokeos.DokeosLMS;
import com.uah.main.moodle.MoodleLMS;
import edu.uci.ics.jung.graph.Graph;
import org.gephi.io.importer.api.ContainerLoader;
import org.gephi.io.importer.api.Report;
import org.gephi.io.importer.spi.SpigotImporter;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.ProgressTicket;

/**
 *
 * @author ie
 */
public class MavselSpigot implements SpigotImporter, LongTask {

    private ContainerLoader container;
    private Report report;
    private ProgressTicket progressTicket;
    private boolean cancel = false;
    private String url;
    private String port;
    private String user;
    private String password;
    private String platform;
    private String course_id;

    @Override
    public boolean execute(ContainerLoader loader) {
        this.container = loader;
        this.report = new Report();

        System.out.println("MAVSEL url-" + url);
        System.out.println("MAVSEL port-" + port);
        System.out.println("MAVSEL user-" + user);
        System.out.println("MAVSEL password-" + password);
        System.out.println("MAVSEL platform-" + platform);
        System.out.println("MAVSEL course_id-" + course_id);
        

        
        //Select the e-learning platform
        LMS myLMS = null;
        Course course = null;
        if(platform.equalsIgnoreCase("moodle")){
            myLMS = new MoodleLMS();
        }else if(platform.equalsIgnoreCase("doekos")){
            myLMS = new DokeosLMS();
        }
          
        //Configure MAVSEL and connect with data base
        try {
            myLMS.configureLMS(url, port, platform, user, password);
            course = myLMS.getCourse(course_id);
        } catch (Exception e) {
            System.out.println("-error incorrect data-");
            e.printStackTrace();
        }
       
        
        Graph<MavselVertex, MavselEdge> graph = myLMS.getParticipantForumGraph(course);


        /*******************************************************************/
        /*******************************************************************/
        /*******************************************************************/
        /*******************************************************************/
        /*******************************************************************/
        /*******************************************************************/
        GraphGenerator graphGenerator = new GraphGenerator();
        graphGenerator.setGraph(graph);
        graphGenerator.generate(container);
        


        return !cancel;
    }

    @Override
    public ContainerLoader getContainer() {
        return container;
    }

    @Override
    public Report getReport() {
        return report;
    }

    @Override
    public boolean cancel() {
        cancel = true;
        return true;
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

        
}
