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
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;


/**
 *
 * @author Pablo Sicilia
 * @version Gephi Mavsel module 1.0
 */
public class MavselWizardPanel1 implements WizardDescriptor.Panel {
        
    
    
    
    private Component component;
    
 
    @Override
    public Component getComponent() {
        if (component == null) {
            component = new MavselWizardSwing1();
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
    }
 
    
    @Override
    public void storeSettings(Object settings) {
        ((WizardDescriptor) settings).putProperty("name", ((MavselWizardSwing1)getComponent()).getTextFieldURL().getText());
        ((WizardDescriptor) settings).putProperty("port", ((MavselWizardSwing1)getComponent()).getTextFieldPort().getText());
        ((WizardDescriptor) settings).putProperty("user", ((MavselWizardSwing1)getComponent()).getTextFieldUser().getText());
        ((WizardDescriptor) settings).putProperty("platform", ((MavselWizardSwing1)getComponent()).getPlatformComboBox().getSelectedItem());
        ((WizardDescriptor) settings).putProperty("password", ((MavselWizardSwing1)getComponent()).getjPasswordFieldPassword().getText());
  
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
