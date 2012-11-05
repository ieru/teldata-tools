/*
Copyright 2008-2012 Gephi
Authors : Pablo Sicilia <pablo.sicilia@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2012 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

 Portions Copyrighted 2011 Gephi Consortium.
 */
package Mavsel;

import com.uah.graph.MavselEdge;
import com.uah.graph.MavselVertex;
import com.uah.items.Course;
import com.uah.items.LMS;
import com.uah.main.dokeos.DokeosLMS;
import com.uah.main.moodle.MoodleLMS;
import edu.uci.ics.jung.graph.Graph;
import javax.swing.JOptionPane;
import org.gephi.io.importer.api.ContainerLoader;
import org.gephi.io.importer.api.Report;
import org.gephi.io.importer.spi.SpigotImporter;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.ProgressTicket;

/**
 *
 * @author Pablo Sicilia
 * @version Gephi Mavsel module 1.0
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
          
        
        try {
            //Configure MAVSEL and connect with data base
            myLMS.configureLMS(url, port, platform, user, password);
            course = myLMS.getCourse(course_id);
            
            //Generate graph
            Graph<MavselVertex, MavselEdge> graph = myLMS.getParticipantForumGraph(course);
            GraphGenerator graphGenerator = new GraphGenerator();
            graphGenerator.setGraph(graph);
            graphGenerator.generate(container);
        
        } catch (Exception e) {
            System.out.println("-error incorrect data-");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed. Please, check your MAVSEL database configuration parameters", "Connection error", JOptionPane.ERROR_MESSAGE);
            cancel = true;
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
