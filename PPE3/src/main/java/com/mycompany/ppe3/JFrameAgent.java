/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FIGUERES Adrien
 */
public class JFrameAgent extends javax.swing.JFrame {

    /**
     * Creates new form JFrameAgent
     */
    public JFrameAgent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneOngletAgent = new javax.swing.JTabbedPane();
        jPanelClientConf = new javax.swing.JPanel();
        jButtonCreerClient = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmailClient = new javax.swing.JTextField();
        jTextFieldPrenomClient = new javax.swing.JTextField();
        jTextFieldTelClient = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomClient = new javax.swing.JTextField();
        jLabelEtatInsertionClient = new javax.swing.JLabel();
        jPanelCategorieProduit = new javax.swing.JPanel();
        jPanelVenteProduit = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneOngletAgent.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jButtonCreerClient.setText("Création du Client");
        jButtonCreerClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreerClientActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom client : ");

        jLabel2.setText("Adresse email client : ");

        jLabel3.setText("numéro téléphone client : ");

        jTextFieldEmailClient.setText("Bernad.test@gmail.com");

        jTextFieldPrenomClient.setText("Bernard");

        jTextFieldTelClient.setText("0626248056");

        jLabel4.setText("Prenom client :");

        jTextFieldNomClient.setText("Test");

        javax.swing.GroupLayout jPanelClientConfLayout = new javax.swing.GroupLayout(jPanelClientConf);
        jPanelClientConf.setLayout(jPanelClientConfLayout);
        jPanelClientConfLayout.setHorizontalGroup(
            jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientConfLayout.createSequentialGroup()
                .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClientConfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientConfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPrenomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientConfLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButtonCreerClient, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClientConfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmailClient, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelClientConfLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabelEtatInsertionClient, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(718, Short.MAX_VALUE))
        );
        jPanelClientConfLayout.setVerticalGroup(
            jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClientConfLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPrenomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmailClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelClientConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTelClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonCreerClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEtatInsertionClient, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        jTabbedPaneOngletAgent.addTab("Client Configuration", jPanelClientConf);

        javax.swing.GroupLayout jPanelCategorieProduitLayout = new javax.swing.GroupLayout(jPanelCategorieProduit);
        jPanelCategorieProduit.setLayout(jPanelCategorieProduitLayout);
        jPanelCategorieProduitLayout.setHorizontalGroup(
            jPanelCategorieProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        jPanelCategorieProduitLayout.setVerticalGroup(
            jPanelCategorieProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        jTabbedPaneOngletAgent.addTab("Catégorie Produits", jPanelCategorieProduit);

        javax.swing.GroupLayout jPanelVenteProduitLayout = new javax.swing.GroupLayout(jPanelVenteProduit);
        jPanelVenteProduit.setLayout(jPanelVenteProduitLayout);
        jPanelVenteProduitLayout.setHorizontalGroup(
            jPanelVenteProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        jPanelVenteProduitLayout.setVerticalGroup(
            jPanelVenteProduitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        jTabbedPaneOngletAgent.addTab("Vente Produit", jPanelVenteProduit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneOngletAgent)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneOngletAgent, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public void requeteInsertionClient(){
        
            bddSQL bdd = new bddSQL();
            bdd.connexionBdd();
            
            
        try {
            Statement requete = bdd.connexion.createStatement();    
            String sql = ("INSERT INTO client VALUES (null, '" + jTextFieldNomClient.getText() +"', '" + jTextFieldPrenomClient.getText() + "','" + jTextFieldEmailClient.getText() + "'," + jTextFieldTelClient.getText() +")");
            requete.executeUpdate(sql);
            jLabelEtatInsertionClient.setText("Insertion Réussi du client : " + jTextFieldNomClient.getText());
            
            

        } catch (SQLException ex) {
            Logger.getLogger(bddSQL.class.getName()).log(Level.SEVERE, null, ex);
            jLabelEtatInsertionClient.setText("Insertion échoué du client !");
        }
             
    }
    
    private void jButtonCreerClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreerClientActionPerformed
        // TODO add your handling code here:    
        this.requeteInsertionClient();
        
    }//GEN-LAST:event_jButtonCreerClientActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAgent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreerClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEtatInsertionClient;
    private javax.swing.JPanel jPanelCategorieProduit;
    private javax.swing.JPanel jPanelClientConf;
    private javax.swing.JPanel jPanelVenteProduit;
    private javax.swing.JTabbedPane jTabbedPaneOngletAgent;
    private javax.swing.JTextField jTextFieldEmailClient;
    private javax.swing.JTextField jTextFieldNomClient;
    private javax.swing.JTextField jTextFieldPrenomClient;
    private javax.swing.JTextField jTextFieldTelClient;
    // End of variables declaration//GEN-END:variables
}