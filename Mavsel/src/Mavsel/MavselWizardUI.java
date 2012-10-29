/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import java.awt.Component;
import javax.swing.JComponent;
import org.gephi.io.importer.spi.Importer;
import org.gephi.io.importer.spi.ImporterWizardUI;
import org.gephi.io.importer.spi.SpigotImporter;
import org.openide.WizardDescriptor;
import org.openide.WizardDescriptor.Panel;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author ie
 */
@ServiceProvider(service = ImporterWizardUI.class)
public class MavselWizardUI implements ImporterWizardUI{
    private Panel[] panels = null;
 
    @Override
    public String getDisplayName() {
        return "Mavsel Importer";
    }
 
    @Override
    public String getCategory() {
        return "Mavsel";
    }
 
    @Override
    public String getDescription() {
        return "Mavsel imports very cool data";
    }
 
    @Override
    public Panel[] getPanels() {
        if (panels == null) {
            panels = new WizardDescriptor.Panel[]{
                        new MavselWizardPanel1()//,
                        //new MavselWizardPanel2()
                    };
        
        String[] steps = new String[panels.length];
            for (int i = 0; i < panels.length; i++) {
                Component c = panels[i].getComponent();
                // Default step name to component name of panel.
                steps[i] = c.getName();
                if (c instanceof JComponent) { // assume Swing components
                    JComponent jc = (JComponent) c;
                    // Sets step number of a component
                    // TODO if using org.openide.dialogs >= 7.8, can use WizardDescriptor.PROP_*:
                    jc.putClientProperty("WizardPanel_contentSelectedIndex", new Integer(i));
                    // Sets steps names for a panel
                    jc.putClientProperty("WizardPanel_contentData", steps);
                    // Turn on subtitle creation on each step
                    jc.putClientProperty("WizardPanel_autoWizardStyle", Boolean.TRUE);
                    // Show steps on the left side with the image on the background
                    jc.putClientProperty("WizardPanel_contentDisplayed", Boolean.TRUE);
                    // Turn on numbering of all steps
                    jc.putClientProperty("WizardPanel_contentNumbered", Boolean.TRUE);
                }
            }
        }
        
        return panels;
    }
    
    /*
    private WizardDescriptor.Panel[] getPanels() {
        if (panels == null) {
            panels = new WizardDescriptor.Panel[]{
                        new EmailWizardPanel1(),
                        new EmailWizardPanel2()
                    };
            String[] steps = new String[panels.length];
            for (int i = 0; i < panels.length; i++) {
                Component c = panels[i].getComponent();
                // Default step name to component name of panel.
                steps[i] = c.getName();
                if (c instanceof JComponent) { // assume Swing components
                    JComponent jc = (JComponent) c;
                    // Sets step number of a component
                    // TODO if using org.openide.dialogs >= 7.8, can use WizardDescriptor.PROP_*:
                    jc.putClientProperty("WizardPanel_contentSelectedIndex", new Integer(i));
                    // Sets steps names for a panel
                    jc.putClientProperty("WizardPanel_contentData", steps);
                    // Turn on subtitle creation on each step
                    jc.putClientProperty("WizardPanel_autoWizardStyle", Boolean.TRUE);
                    // Show steps on the left side with the image on the background
                    jc.putClientProperty("WizardPanel_contentDisplayed", Boolean.TRUE);
                    // Turn on numbering of all steps
                    jc.putClientProperty("WizardPanel_contentNumbered", Boolean.TRUE);
                }
            }
        }
        return panels;
    }*/
 
    @Override
    public void setup(Panel panel) {
        //Before opening the wizard
    }
 
    @Override
    public void unsetup(SpigotImporter importer, Panel panel) {
        //When the wizard has been closed
        
        ((MavselWizardSwing1) ((Panel) panels[0]).getComponent()).unsetup((MavselSpigot)importer);
        //((MavselWizardSwing2) ((Panel) panels[1]).getComponent()).unsetup((MavselSpigot)importer);
 
        panels = null;
    }
 
    @Override
    public boolean isUIForImporter(Importer importer) {
        return importer instanceof MavselSpigot;
    }
}
