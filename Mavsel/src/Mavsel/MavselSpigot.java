/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import com.uah.graph.MavselVertex;
import com.uah.graph.PajekAdapter;
import com.uah.graph.SoniaAdapter;
import com.uah.items.*;
import com.uah.main.dokeos.DokeosLMS;
import com.uah.main.moodle.MoodleLMS;
import edu.uci.ics.jung.graph.Graph;
import java.util.List;
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

    @Override
    public boolean execute(ContainerLoader loader) {
        this.container = loader;
        this.report = new Report();

        System.out.println("MAVSEL url-" + url);
        System.out.println("MAVSEL port-" + port);
        System.out.println("MAVSEL user-" + user);
        System.out.println("MAVSEL password-" + password);
        //Import done here

        System.out.println("----------------------------");
        System.out.println("----Moodle Course-----------");
        System.out.println("----------------------------");


        System.out.println("--1--------------------------");

        LMS miLMSmoodle = new MoodleLMS();
        LMS miLMSdokeos = new DokeosLMS();
            
        try {
            
            miLMSmoodle.configureLMS("localhost", "3306", "moodle", "root", "root");
        } catch (Exception e) {
            System.out.println("-error MOODLE-");
            e.printStackTrace();
        }

        System.out.println("--2--------------------------");

          Course courseMoodle = miLMSmoodle.getCourse("2");

        
        System.out.println("getFullname" + courseMoodle.getFullname());
        System.out.println("getShortname" + courseMoodle.getShortname());
        System.out.println("getSummary" + courseMoodle.getSummary());
        System.out.println("--3--------------------------");
        
        
        System.out.println("----------------------------");
        System.out.println("---------GRAPH--------------");
        System.out.println("----------------------------");



        System.out.println("----------------------------");
        System.out.println("---------soniaAdapter-------");
        System.out.println("----------------------------");
        Graph<MavselVertex, String> graphMoodle = miLMSmoodle.getParticipantForumGraph(courseMoodle);
        SoniaAdapter.export("C:/Pruebaspajek/soniaGraphMoodle.txt", graphMoodle);

        System.out.println("----------------------------");
        System.out.println("-------- R File ------------");
        System.out.println("----------------------------");
      
        try {
        miLMSmoodle.getForumRaitingInRFile("C:/Pruebaspajek/ratingsMoodle.dat");
        } catch (Exception e) {
            System.out.println("-error MOODLE-");
            e.printStackTrace();
        }



        System.out.println("----------------------------");
        System.out.println("----DOKEOS Course-----------");
        System.out.println("----------------------------");
  
        try {
            miLMSdokeos.configureLMS("localhost", "3306", "dokeos_main", "root", "root");
        } catch (Exception e) {
            System.out.println("-error DOKEOS-");
            e.printStackTrace();
        }

        Course courseDokeos = miLMSdokeos.getCourse("CURSODEPRUEBADOS");

        System.out.println("Course2::");
        System.out.println("" + courseDokeos.getFullname());
        System.out.println("" + courseDokeos.getShortname());
        System.out.println("" + courseDokeos.getSummary());
        System.out.println("----------------------------");

        List<Forum> forumsDokeos = miLMSdokeos.getForums(courseDokeos);

        for (Forum forum : forumsDokeos) {
            System.out.println("Forum title[" + forum.getTitle() + "]");
            List<Discussion> discussionsDokeos = miLMSdokeos.getDiscussions(forum);

            for (Discussion discussion : discussionsDokeos) {
                System.out.println("----Discussion title[" + discussion.getTitle() + "]");

                List<Post> postsDokeos = miLMSdokeos.getPosts(discussion);

                for (Post post : postsDokeos) {
                    System.out.println("--------Post message[" + post.getMessage() + "]");
                    Participant participantDokeos = miLMSdokeos.getParticipant(post.getIdParticipant());
                    System.out.println("--------Writen by participant-username[" + participantDokeos.getUsername() + "]");
                }
            }
            System.out.println("----------------------------");
            
            System.out.println("----------------------------");
            System.out.println("---------GRAPH--------------");
            System.out.println("----------------------------");
            Graph<MavselVertex, String> graphDokeos = miLMSdokeos.getParticipantForumGraph(courseDokeos);
            PajekAdapter.export("C:/Pruebaspajek/pajekGraphDokeos.txt", graphDokeos);
            
            
            
            System.out.println("----------------------------");
            System.out.println("---------soniaAdapter-------");
            System.out.println("----------------------------");       
            SoniaAdapter.export("C:/Pruebaspajek/soniaGraphDokeos.txt", graphDokeos);
            
            
            /*******************************************************************/
            /*******************************************************************/
            /*******************************************************************/
            /*******************************************************************/
            /*******************************************************************/
            /*******************************************************************/
            GraphGenerator graphGenerator = new GraphGenerator();
            graphGenerator.setGraph(graphMoodle);
            graphGenerator.generate(container);
        }


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
}
