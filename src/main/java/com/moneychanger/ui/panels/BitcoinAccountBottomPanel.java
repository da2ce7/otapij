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

package com.moneychanger.ui.panels;

import com.wrapper.core.BitcoinAccount;
import com.wrapper.core.dataobjects.BitcoinDetails;
import com.moneychanger.ui.dialogs.BitcoinTrnDetailsDialog;
import com.moneychanger.ui.model.BitcoinReceivedTableModel;
import com.moneychanger.ui.model.BitcoinReceivingAddrTableModel;
import com.moneychanger.ui.model.BitcoinSentTableModel;
import java.util.Map;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Vicky C
 */
public class BitcoinAccountBottomPanel extends javax.swing.JPanel {

    private static Map sentBoxMap;
    private static Map receivedBoxMap;
    private static Map receivedAddressBoxMap;
    private static String serverID;

    /** Creates new form BitcoinAccountBottomPanel */
    public BitcoinAccountBottomPanel() {
        initComponents();
        initvalues();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable5 = new com.moneychanger.ui.custom.CustomTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable6 = new com.moneychanger.ui.custom.CustomTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable7 = new com.moneychanger.ui.custom.CustomTable();
        jButton1 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane12.setName("jScrollPane12"); // NOI18N

        jTable5.setModel(new com.moneychanger.ui.model.BitcoinSentTableModel());
        jTable5.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable5.setName("jTable5"); // NOI18N
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("SENT", jPanel1);

        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane13.setName("jScrollPane13"); // NOI18N

        jTable6.setModel(new com.moneychanger.ui.model.BitcoinReceivedTableModel());
        jTable6.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable6.setName("jTable6"); // NOI18N
        jTable6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("RECEIVED", jPanel3);

        jScrollPane14.setName("jScrollPane14"); // NOI18N

        jTable7.setModel(new com.moneychanger.ui.model.BitcoinReceivingAddrTableModel());
        jTable7.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable7.setName("jTable7"); // NOI18N
        jTable7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(jTable7);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.moneychanger.app.ApplicationLauncher.class).getContext().getResourceMap(BitcoinAccountBottomPanel.class);
        jTabbedPane1.addTab(resourceMap.getString("jScrollPane14.TabConstraints.tabTitle"), jScrollPane14); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setToolTipText(resourceMap.getString("jButton1.toolTipText")); // NOI18N
        jButton1.setName("jButton1");
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jButton1)
                .addContainerGap(330, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        System.out.println("Count:" + evt.getClickCount());
        if (evt.getClickCount() == 2) {
            String key = (String) jTable5.getModel().getValueAt(jTable5.getSelectedRow(), 5);
            System.out.println("In Sent box double clcik, key:" + key);
            System.out.println("sentBoxMap keys:"+sentBoxMap);
            String[] row = (String[]) sentBoxMap.get(key);
            if (row != null) {
                new BitcoinTrnDetailsDialog(null, true,new BitcoinAccount(serverID).getLabel(row[3]),key,row[4]).setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        System.out.println("Count:" + evt.getClickCount());
        if (evt.getClickCount() == 2) {
            String key = (String) jTable6.getModel().getValueAt(jTable6.getSelectedRow(), 5);
            System.out.println("In Received box double clcik, key:" + key);
            System.out.println("receivedBoxMap keys:"+receivedBoxMap);
            String[] row = (String[]) receivedBoxMap.get(key);
            if (row != null) {
                new BitcoinTrnDetailsDialog(null, true,new BitcoinAccount(serverID).getLabel(row[3]),key,row[4]).setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        JTabbedPane pane = (JTabbedPane) evt.getSource();
        int sel = pane.getSelectedIndex();
        System.out.println("State changed:" + sel);
        if (sel == 1) {
            jButton1.setVisible(true);
            repaint();
        } else {
            jButton1.setVisible(false);
            repaint();
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        receivedBoxMap = new BitcoinAccount(serverID).getReceivedBoxData("");
        ((BitcoinReceivedTableModel) jTable6.getModel()).setValue(receivedBoxMap,jTable6);

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTable jTable5;
    private static javax.swing.JTable jTable6;
    private static javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables

    public static void clearPanel() {
        if (jTable5 != null && jTable6 != null && jTable7 != null) {
            ((BitcoinSentTableModel) jTable5.getModel()).clearValue();
            ((BitcoinReceivedTableModel) jTable6.getModel()).clearValue();
            ((BitcoinReceivingAddrTableModel) jTable7.getModel()).clearValue();
        }
    }

    public static void populateBitcoinDetails(BitcoinDetails details) {
        System.out.println("populateBitcoinDetails");
        if (details != null) {
            sentBoxMap = details.getSentboxData();
            receivedBoxMap = details.getReceivedboxData();
            receivedAddressBoxMap = details.getReceivedAddrboxData();
            serverID = details.getServerID();
            ((BitcoinSentTableModel) jTable5.getModel()).setValue(sentBoxMap, jTable5);
            ((BitcoinReceivedTableModel) jTable6.getModel()).setValue(receivedBoxMap,jTable6);
            ((BitcoinReceivingAddrTableModel) jTable7.getModel()).setValue(receivedAddressBoxMap,jTable7);
        }
    }

    public static void setReceivingAddrTable(String account){
        receivedAddressBoxMap = new BitcoinAccount(serverID).getRecevingAddrBoxData(account);
        ((BitcoinReceivingAddrTableModel) jTable7.getModel()).setValue(receivedAddressBoxMap,jTable7);
    }

    public static void setSentBoxTable(String account){
        sentBoxMap = new BitcoinAccount(serverID).getSentBoxData(account);
        ((BitcoinSentTableModel) jTable5.getModel()).setValue(sentBoxMap, jTable5);
    }

    private void initvalues() {

        jTable5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumn col = jTable5.getColumnModel().getColumn(0);

        col.setPreferredWidth(120);

        col = jTable5.getColumnModel().getColumn(1);
        col.setPreferredWidth(160);

        col = jTable5.getColumnModel().getColumn(2);
        col.setPreferredWidth(50);

        col = jTable5.getColumnModel().getColumn(3);
        col.setPreferredWidth(240);

        col = jTable5.getColumnModel().getColumn(4);
        col.setPreferredWidth(200);

        col = jTable6.getColumnModel().getColumn(0);

        col.setPreferredWidth(120);

        col = jTable6.getColumnModel().getColumn(1);
        col.setPreferredWidth(180);

        col = jTable6.getColumnModel().getColumn(2);
        col.setPreferredWidth(50);

        col = jTable6.getColumnModel().getColumn(3);
        col.setPreferredWidth(240);

        col = jTable6.getColumnModel().getColumn(4);
        col.setPreferredWidth(220);

        col = jTable7.getColumnModel().getColumn(0);
        col.setPreferredWidth(360);

        col = jTable7.getColumnModel().getColumn(1);
        col.setPreferredWidth(255);

        col = jTable7.getColumnModel().getColumn(2);
        col.setPreferredWidth(60);


    }
}
