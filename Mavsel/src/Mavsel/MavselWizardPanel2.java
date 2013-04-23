/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import com.uah.graph.MavselEdge;
import com.uah.graph.MavselVertex;
import com.uah.items.Course;
import com.uah.items.LMS;
import com.uah.main.dokeos.DokeosLMS;
import com.uah.main.moodle.MoodleLMS;
import edu.uci.ics.jung.graph.Graph;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

/**
 *
 * @author ie
 */
public class MavselWizardPanel2 implements WizardDescriptor.Panel{
    
    private Component component = new MavselWizardSwing2();
    
 
    @Override
    public Component getComponent() {
        if (component == null) {
            component = new MavselWizardSwing2();
        }
        return component;
    }
 

   
    @Override
    public HelpCtx getHelp() {
        return HelpCtx.DEFAULT_HELP;
    }
 
    /*
     * You can use a settings object to keep track of state. Normally the
     * settings object will be the WizardDescriptor, so you can use
     * WizardDescriptor.getProperty & putProperty to store information entered
     * by the user.
     */
    @Override
    public void readSettings(Object settings) {
        ConnectionInfo connectionInfo = new ConnectionInfo();
        try {
            connectionInfo.setUrl((String)((WizardDescriptor) settings).getProperty("name"));
            connectionInfo.setPort((String)((WizardDescriptor) settings).getProperty("port"));
            connectionInfo.setUser((String)((WizardDescriptor) settings).getProperty("user"));
            connectionInfo.setPlatform((String)((WizardDescriptor) settings).getProperty("platform"));
            connectionInfo.setPassword((String)((WizardDescriptor) settings).getProperty("password"));

            //Select the e-learning platform
            LMS myLMS = null;

            if(connectionInfo.getPlatform().equalsIgnoreCase("moodle")){
                myLMS = new MoodleLMS();
            }else if(connectionInfo.getPlatform().equalsIgnoreCase("doekos")){
                myLMS = new DokeosLMS();            
            }
            List<Course> courses= null;
        
            //Configure MAVSEL and connect with data base
            myLMS.configureLMS(connectionInfo.getUrl(), connectionInfo.getPort(), connectionInfo.getPlatform(), connectionInfo.getUser(), connectionInfo.getPassword());
            courses = myLMS.getCourse();
                        
            ((MavselWizardSwing2)component).setComboBoxValues(courses);
                  
        } catch (Exception e) {               
            
            JOptionPane.showMessageDialog(null, "Connection failed. Please, check your MAVSEL database configuration parameters", "Connection error", JOptionPane.ERROR_MESSAGE);

        }
        
    }
 
    
    @Override
    public void storeSettings(Object settings) {

        ((WizardDescriptor) settings).putProperty("courseName", ((MavselWizardSwing2)getComponent()).getCourseName());
     
    }
 
    @Override
    public boolean isValid() {
        return true;
    }
 
    @Override
    public final void addChangeListener(ChangeListener l) {
    }
 
    @Override
    public final void removeChangeListener(ChangeListener l) {
    }
}
