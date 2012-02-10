/************************************************************
-----BEGIN PGP SIGNED MESSAGE-----
Hash: SHA256

 *                 M O N E Y C H A N G E R
 *
 *  Open Transactions:
 *       Financial Cryptography and Digital Cash
 *       Library, Protocol, API, Server, and GUI
 *
 *    	 -- Anonymous Numbered Accounts.
 *    	 -- Untraceable Digital Cash.
 *    	 -- Triple-Signed Receipts.
 *    	 -- Cheques, Vouchers, Transfers, Inboxes.
 *    	 -- Basket Currencies, Markets, Payment Plans.
 *    	 -- Signed, XML, Ricardian-style Contracts.
 *
 *  Copyright (C) 2010-2012 by "Fellow Traveler" (A pseudonym)
 *
 *  EMAIL:
 *  FellowTraveler@rayservers.net
 *
 *  FINGERPRINT:
 *  9DD5 90EB 9292 4B48 0484  7910 0308 00ED F951 BB8E
 *
 *  BITCOIN:  1NtTPVVjDsUfDWybS4BwvHpG2pdS9RnYyQ
 *
 *  OFFICIAL PROJECT WIKI:
 *  https://github.com/FellowTraveler/Moneychanger
 *  https://github.com/FellowTraveler/Open-Transactions/wiki
 *
 *  WEBSITE:
 *  http://www.OpenTransactions.org/
 *
 *  Components and licensing:
 *   -- Moneychanger..A Java client GUI.....LICENSE:.....GPLv3
 *   -- OTLib.........A class library.......LICENSE:...LAGPLv3
 *   -- OT-API........A client API..........LICENSE:...LAGPLv3
 *   -- testwallet....Command-line client...LICENSE:...LAGPLv3
 *   -- OT-Server.....Server Application....LICENSE:....AGPLv3
 *  Github.com/FellowTraveler/Open-Transactions/wiki/Components
 *
 *  All of the above OT components were designed and written by
 *  Fellow Traveler, with the exception of Moneychanger, which
 *  was contracted out to Vicky C (livewire_3001@yahoo.com).
 *
 *  -----------------------------------------------------
 *
 *   LICENSE:
 *   This program is free software: you can redistribute it
 *   and/or modify it under the terms of the GNU General
 *   Public License as published by the Free Software
 *   Foundation, either version 3 of the License, or (at your
 *   option) any later version.
 *
 *   You should have received a copy of the GNU General
 *   Public License along with this program.  If not, see:
 *   http://www.gnu.org/licenses/
 *
 *   If you would like to use this software outside of the free
 *   software license, please contact FellowTraveler.
 *   (Unfortunately many will run anonymously and untraceably,
 *   so who could really stop them?)
 *
 *   DISCLAIMER:
 *   This program is distributed in the hope that it will be
 *   useful, but WITHOUT ANY WARRANTY; without even the implied
 *   warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *   PURPOSE.  See the GNU General Public License for more
 *   details.

-----BEGIN PGP SIGNATURE-----
Version: GnuPG v1.4.11 (Darwin)

iQIcBAEBCAAGBQJOj7gfAAoJEAMIAO35UbuOs3sP/2rrjSdYu/AsXcgLK9/9CP4a
lIJfw3KLvybKZjZW5r5j+4xUlCYIqPZSI66PGDChGPMPFcZQN6M4Ddpn9kbctymS
sdTXvbdFhpbV6k2wSa1Fz97ygfXJc/7MDTmHYbZ53hVV8AoUBrCHWtVttkQD31o3
Pn/qGmy+jOgTvjEXhjEpV66pDkMWze1SiI1MArHUziCYoxItuM45x0EfzwQIqlo3
ku2R7rRTtqm47Dgea12psWrjbPS5XRL1Q8Hs38Z1J0JdFlfn6cJYe52Iiluzof6M
kCLhy6FH8QfIADfrKkFP48EIhnVquDlkV9AlJ1r217K3cpK2jEjlZUnGBECMAMEo
pSXXk1BLNgxsa4yaXCgHY92/MhgtcdCMLkcCq6MWUTGZsLGiWIiQGmO9mwBfNIlY
SawlIviuS5DiE/D16A290Byxhha/5e144cIiKm27fSQra8eogUXNfZdZeuv6n69v
t8QjeBjoLhe5/KnRNoGLpSXhPphsWLRSJBru77ZU2msHfmkNfcP2UoEUCfNTfTbE
XpyRfeyRVowVKeKunV9KUSHgdD5wa6RUeyodAbaHvWrFpIpNkaFIP9OwhRULpjx0
arwVNYucbX1qb2I8HBm2u+IRWQTONp74TFFjU0/CVAXu2DeJKY5mL4zDej35c5j9
AK+ZirdWhhoHeWR1tAkN
=RcXP
-----END PGP SIGNATURE-----
 **************************************************************/



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CashPurseAccountBottomPanel.java
 *
 * Created on 18 Mar, 2011, 7:01:51 PM
 */
package com.moneychanger.ui.panels;

import com.moneychanger.core.CashPurseAccount;
import com.moneychanger.core.dataobjects.CashPurseDetails;
import com.moneychanger.core.util.Utility;
import com.moneychanger.ui.MainPage;
import com.moneychanger.ui.dialogs.CashPurseDepositDialog;
import com.moneychanger.ui.dialogs.CashPurseExportDetails;
import com.moneychanger.ui.dialogs.CashPurseTokenDetails;
import com.moneychanger.ui.dialogs.ExportCashToDialog;
import com.moneychanger.ui.model.CashPurseTableModel;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicky C
 */
public class CashPurseAccountBottomPanel extends javax.swing.JPanel {

    private static CashPurseDetails details;

    /** Creates new form CashPurseAccountBottomPanel */
    public CashPurseAccountBottomPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane12 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jScrollPane12.setName("jScrollPane12"); // NOI18N

        jTable5.setModel(new com.moneychanger.ui.model.CashPurseTableModel());
        jTable5.setName("jTable5"); // NOI18N
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable5);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.moneychanger.app.LaunchMoneychanger.class).getContext().getResourceMap(CashPurseAccountBottomPanel.class);
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed1(evt);
            }
        });

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        System.out.println("Count:" + evt.getClickCount());
        if (evt.getClickCount() == 2) {
            String key = (String) jTable5.getModel().getValueAt(jTable5.getSelectedRow(), 6);
            System.out.println("In Cash Purse Grid double clcik, key:" + key);
            new CashPurseTokenDetails(null, true, key).setVisible(true);
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
            ArrayList selectedIndices = new ArrayList();
            for (int i = 0; i < jTable5.getRowCount(); i++) {
                String id = (String) jTable5.getModel().getValueAt(i, 3);
                if ((Boolean) jTable5.getModel().getValueAt(i, 5)) {
                    selectedIndices.add(id);
                }
            }
            System.out.println("selectedIndices:" + selectedIndices);
            if(selectedIndices.isEmpty()){
                int selected = JOptionPane.showConfirmDialog(this, "This will deposit all of the tokens in the purse", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(selected==2)
                    return;
            }
            new CashPurseDepositDialog(null, true, details, selectedIndices).setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {

            ArrayList selectedIndices = new ArrayList();
            for (int i = 0; i < jTable5.getRowCount(); i++) {
                String id = (String) jTable5.getModel().getValueAt(i, 3);
                if ((Boolean) jTable5.getModel().getValueAt(i, 5)) {
                    selectedIndices.add(id);
                }
            }
            System.out.println("selectedIndices:" + selectedIndices);

            if(selectedIndices.isEmpty()){
                int selected = JOptionPane.showConfirmDialog(this, "This will export all of the tokens in the purse", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(selected==2)
                    return;
            }
            new ExportCashToDialog(null, true, details,selectedIndices).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            setCursor(Cursor.getDefaultCursor());

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed1

        try {
            if(true){
              JOptionPane.showMessageDialog(null, "Exchange is currently not supported","Error",JOptionPane.ERROR_MESSAGE);
              return;
            }

            CashPurseAccount cashPurseAccount = new CashPurseAccount();
            ArrayList selectedIndices = new ArrayList();
            for (int i = 0; i < jTable5.getRowCount(); i++) {
                String id = (String) jTable5.getModel().getValueAt(i, 3);
                if ((Boolean) jTable5.getModel().getValueAt(i, 5)) {
                    selectedIndices.add(id);
                }
            }
            System.out.println("selectedIndices:" + selectedIndices);

            if(selectedIndices.isEmpty()){
                int selected = JOptionPane.showConfirmDialog(this, "This will exchange all of the tokens in the purse", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(selected==2)
                    return;
            }

            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            boolean isSuccess = cashPurseAccount.exchangeCashPurse(details.getServerID(), details.getAssetID(), details.getNymID(), details.getPurse(), selectedIndices);
            if (isSuccess) {
                JOptionPane.showMessageDialog(this, "Cash exchanged successfully", "Exchange Success", JOptionPane.INFORMATION_MESSAGE);
                CashPurseDetails cashDetails = new CashPurseAccount().getCashPurseDetails(details.getServerID()+":"+details.getAssetID()+":"+details.getNymID());
                CashPurseAccountBottomPanel.populateCashPurseDetails(cashDetails);
                CashPurseAccountTopPanel.populateCashPurseDetails(cashDetails, cashDetails.getBalance());
                MainPage.reLoadAccount();
                //((CashPurseTableModel) jTable5.getModel()).setValue(cashPurseAccount.refreshGridData(details.getServerID(), details.getAssetID(), details.getNymID()), jTable5);
            } else {
                if(Utility.getObj()!=null){
                  new CashPurseExportDetails(null, true,(String)Utility.getObj(),false).setVisible(true);
                }else
                JOptionPane.showMessageDialog(this, "Error in cash purse exchange", "Server Error", JOptionPane.ERROR_MESSAGE);
    }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            setCursor(Cursor.getDefaultCursor());

        }
    }//GEN-LAST:event_jButton2ActionPerformed1

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane12;
    private static javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables

    public static void clearPanel() {
        if (jTable5 != null) {
            ((CashPurseTableModel) jTable5.getModel()).clearValue();
        }
    }

    public static void populateCashPurseDetails(CashPurseDetails cashDetails) {
        ((CashPurseTableModel) jTable5.getModel()).setValue(cashDetails.getPurseGrid(), jTable5);
        details = cashDetails;
    }
    public static void refreshGrid(Map data){
        ((CashPurseTableModel) jTable5.getModel()).setValue(data, jTable5);
    }
}
