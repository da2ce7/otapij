/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moneychanger.app.main.helpers;

import com.moneychanger.app.main.Concierge;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import net.sf.swinglib.actions.ReturnAction;

/**
 *
 * @author Cameron Garnham
 */
public class GetSetClipboard {

    private static Concierge _concierge;
    private static ReturnAction _returnAction;

    public GetSetClipboard(Concierge concierge, ReturnAction returnAction) {
        _concierge = concierge;
        _returnAction = returnAction;
    }

    public void GetClipboard() {
        Transferable clipboardContent = _concierge.getDialogOwner().getToolkit().getSystemClipboard().getContents(this);
        String tempString;

        if ((clipboardContent != null)
                && (clipboardContent.isDataFlavorSupported(DataFlavor.stringFlavor))) {
            try {
                tempString = (String) clipboardContent.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                tempString = "";
                System.out.println("error with clipboard paste");
            }
            _returnAction.returnAction(tempString);
        }
    }
}
