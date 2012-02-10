/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.actions;

import com.moneychanger.app.main.Concierge;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author cameron
 */
/**
 *  Resets the Preferences.
 */
public class FileResetPrefs extends AbstractAction
{
    private static final long serialVersionUID = 1L;


    private Concierge _concierge;


    public FileResetPrefs(Concierge concierge)
    {
        super("Reset Preferences...");
        _concierge = concierge;
    }

//----------------------------------------------------------------------------
//  ActionListener
//----------------------------------------------------------------------------

    public void actionPerformed(ActionEvent e)
    {
        _concierge.getConfig().resetConfig();
    }
}
