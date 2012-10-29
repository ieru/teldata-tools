/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mavsel;

import java.awt.Component;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

/**
 *
 * @author ie
 */
public class MavselWizardPanel2 implements WizardDescriptor.Panel{
    private Component component;
    
 
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
    }
 
    @Override
    public void storeSettings(Object settings) {
     /*   ((WizardDescriptor) settings).putProperty("name", ((MavselWizardSwing1)getComponent()).getTextFieldURL().getText());
        ((WizardDescriptor) settings).putProperty("address", ((MavselWizardSwing1)getComponent()).getTextFieldPort().getText());
        ((WizardDescriptor) settings).putProperty("address", ((MavselWizardSwing1)getComponent()).getTextFieldUser().getText());
        ((WizardDescriptor) settings).putProperty("address", ((MavselWizardSwing1)getComponent()).getjPasswordFieldPassword().getText());*/
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
