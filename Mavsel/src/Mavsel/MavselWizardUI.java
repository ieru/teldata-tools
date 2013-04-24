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
 * @author Pablo Sicilia
 * @version Gephi Mavsel module 1.0
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
        return "This connector imports data from an e-learning platform using the MAVSEL extractor library.\nAlso transforms the imported data into a Gephi graph.";
    }
 
    @Override
    public Panel[] getPanels() {
        if (panels == null) {
            panels = new WizardDescriptor.Panel[]{
                        new MavselWizardPanel1(),
                        new MavselWizardPanel2()                        
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
    
 
    @Override
    public void setup(Panel panel) {
        //Before opening the wizard
    }
    
    @Override
    public void unsetup(SpigotImporter importer, Panel panel) {
        //When the wizard has been closed     
        try{
        System.out.println(panels.length);
        //MavselWizardSwing2 
        ((MavselWizardSwing1) ((Panel) panels[0]).getComponent()).unsetup((MavselSpigot)importer);        
        ((MavselWizardSwing2) ((Panel) panels[1]).getComponent()).unsetup((MavselSpigot)importer);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        panels = null;
    }
 
    @Override
    public boolean isUIForImporter(Importer importer) {
        return importer instanceof MavselSpigot;
    }
}
