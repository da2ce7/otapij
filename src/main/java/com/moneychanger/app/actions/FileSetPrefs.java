/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.actions;


import com.moneychanger.app.controlers.PrefsController;
import com.moneychanger.app.main.Concierge;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author cameron
 */
/**
 *  Displays the Preferences dialog.
 */
public class FileSetPrefs extends AbstractAction
{
    private static final long serialVersionUID = 1L;


    private Concierge _concierge;


    public FileSetPrefs(Concierge concierge)
    {
        super("Preferences...");
        _concierge = concierge;
    }

//----------------------------------------------------------------------------
//  ActionListener
//----------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e)
    {
        new PrefsController(_concierge).show();
    }
}
