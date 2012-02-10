/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app;

import com.moneychanger.app.controlers.PrefsController;
import com.moneychanger.app.main.Concierge;
import com.moneychanger.app.main.ConfigBean;
import com.moneychanger.app.main.MainFrameController;
import com.moneychanger.app.main.Start;
import javax.swing.SwingUtilities;

/**
 *
 * @author cameron
 */
public class Main {

    public static void main(String[] argv) throws Exception {

        final Concierge concierge = new Concierge(new ConfigBean());

        try {
            SwingUtilities.invokeLater(new Runnable() {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Start.main(null, concierge);
                    }
                });

                @Override
                public void run() {
                    concierge.setStarter(t);
                }
            });


            SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    new MainFrameController(concierge).buildAndShow();

                    if (!concierge.getConfig().isConfigComplete()) {
                        new PrefsController(concierge).show();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.runFinalization();
            System.exit(1);
        }
    }
}
