/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.actions;


import com.moneychanger.app.controlers.PrefsController;
import com.moneychanger.app.main.Concierge;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author cameron
 */
/**
 * Tries to load MoneyChanger.
 */
public class LoadMenuAction extends AbstractAction {

    private static final long serialVersionUID = 1L;
    private Concierge _concierge;

    public LoadMenuAction(Concierge concierge) {
        super("Load...");
        _concierge = concierge;
    }

//----------------------------------------------------------------------------
//  ActionListener
//----------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!_concierge.getConfig().getConfigUpdated()) {
            JOptionPane.showMessageDialog(_concierge.getDialogOwner(), "Please Set Configuration First!", "Confiuration Not Ready!", JOptionPane.ERROR_MESSAGE);
            new PrefsController(_concierge).show();
        }
        if (_concierge.getConfig().getConfigUpdated()) {
            _concierge.getStarter().start();
        }
    }
}