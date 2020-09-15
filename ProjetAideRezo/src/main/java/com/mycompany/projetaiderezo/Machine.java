package com.mycompany.projetaiderezo;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xadriraxor
 */
public class Machine extends javax.swing.JPanel {

    /**
     * Creates new form machine
     */

    public Machine() {
        initComponents();
    }

    private static int countMatches(final String str, final char ch) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        // We could also call str.toCharArray() for faster look ups but that
        // would generate more garbage.
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cette méthode permet de savoir à quelle classe appartient l'adresse IP
     * saisie De plus si le premier champs de l'adresse IP n'est pas rempli une
     * erreur ce produit demandant de vérifiez les champs
     *
     * @return LaClasseAdresseIp
     */
    public String classeAdresseIp() {
        if (jTextFieldIp1Field1.getText().isEmpty()) {
            return errorMSG();
        } else if (Integer.parseInt(jTextFieldIp1Field1.getText()) < 128) {
            return "Classe --> A";
        } else if (Integer.parseInt(jTextFieldIp1Field1.getText()) < 192) {
            return "Classe --> B";
        } else if (Integer.parseInt(jTextFieldIp1Field1.getText()) < 224) {
            return "Classe --> C";
        } else if (Integer.parseInt(jTextFieldIp1Field1.getText()) < 240) {
            return "Classe --> D";
        } else if (Integer.parseInt(jTextFieldIp1Field1.getText()) > 240) {
            return "Classe --> E";
        }
        return null;
    }

    /**
     * Permet de connaître toutes les informations supplémentaires du réseau saisie à partir de l'adresse IP et du masque de sous réseau.
     * Cette méthode affiche : le réseau de l'IP, le nombre d'IP / Machines disponibles sur le réseau, ainsi que la plage de machine disponibles en prenant la première et dernière machines
     * Pour afficher le réseau de l'IP --> Conversion du masque de sous réseau en binaire et grâce à countMatches() nous allons récupérer le nombre de bits à 0, puis conversion de binaire à décimale et nous trouvons l'ip du réseau.
     * Pour afficher le nombre d'ip/ Machines dissponibles sur le réseau --> Calcul 2^leNombreDeBitsAZero - 2 = Nombre IP dispo sur le réseau
     * Pour afficher l'ip MIN --> Trouver le minimum et le maximum de la plage IP a partir de l'IP réseau qui à été trouvé
     * @author Adrien FIGUERES
     * @return ReseauIP
     */
    public String reseauIP() {
        
        
        //Déclaration variable IpField et MasqueField qui prend tous les champs de saisies (IP et Masque)
        String IpField = jTextFieldIp1Field1.getText() + jTextFieldIp1Field2.getText() + jTextFieldIp1Field3.getText() + jTextFieldIp1Field4.getText();
        String MasqueField = jTextFieldMasqueSR1Field1.getText() + jTextFieldMasqueSR1Field2.getText() + jTextFieldMasqueSR1Field3.getText() + jTextFieldMasqueSR1Field4.getText();
        
        if(!IpField.isEmpty() & !MasqueField.isEmpty()){
        
        //Conversion IP Masque ---> binaire et comptage des zéros a partir du masque 
        Integer zeros_ = 0;
        String[] addrOctetArray = new String[4];
        addrOctetArray[0] = jTextFieldMasqueSR1Field1.getText();
        addrOctetArray[1] = jTextFieldMasqueSR1Field2.getText();
        addrOctetArray[2] = jTextFieldMasqueSR1Field3.getText();
        addrOctetArray[3] = jTextFieldMasqueSR1Field4.getText();
        String binMasqueAddr = "";

        for (String string : addrOctetArray) {
            int octet = Integer.parseInt(string);
            String binaryOctet = String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0');
            binMasqueAddr = binMasqueAddr + binaryOctet;

            zeros_ = zeros_ + countMatches(binaryOctet, '0');
        }

        
        //Conversion IP machine ---> binaire
        String[] addrOctetArrayBis = new String[4];
        addrOctetArrayBis[0] = jTextFieldIp1Field1.getText();
        addrOctetArrayBis[1] = jTextFieldIp1Field2.getText();
        addrOctetArrayBis[2] = jTextFieldIp1Field3.getText();
        addrOctetArrayBis[3] = jTextFieldIp1Field4.getText();
        String binIPAddr = "";
        for (String string : addrOctetArrayBis) {
            int octet = Integer.parseInt(string);
            String binaryOctet = String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0');
            binIPAddr = binIPAddr + binaryOctet;
        }

        //Et Logique pour trouver l'IP réseau : IP machine Binaire ET Ip Masque Binaire
        Integer oct_1 = Integer.parseInt(binIPAddr.substring(0, 8), 2) & Integer.parseInt(binMasqueAddr.substring(0, 8), 2);
        Integer oct_2 = Integer.parseInt(binIPAddr.substring(8, 16), 2) & Integer.parseInt(binMasqueAddr.substring(8, 16), 2);
        Integer oct_3 = Integer.parseInt(binIPAddr.substring(16, 24), 2) & Integer.parseInt(binMasqueAddr.substring(16, 24), 2);
        Integer oct_4 = Integer.parseInt(binIPAddr.substring(24, 32), 2) & Integer.parseInt(binMasqueAddr.substring(24, 32), 2);

        //AFFICHAGES Résultat IP réseau
        String IPRESULTAT = oct_1 + "." + oct_2 + "." + oct_3 + "." + oct_4;
        //Calcul fonction du nombre de zéros dans l'IP binaire du masque --> 2^leNombreDeBitsAZero - 2 = Nombre IP dispo sur le réseau 
        Integer NBREIP = (int) Math.pow(2, zeros_) - 2;

        //Trouver le minimum et le maximum de la plage IP a partir de l'IP réseau qui à été trouvé
        String[] ipAddrOctetArray = IPRESULTAT.split("\\.");
        String minRangeVal = ipAddrOctetArray[0] + "." + ipAddrOctetArray[1] + "." + ipAddrOctetArray[2] + "." + (Integer.parseInt(ipAddrOctetArray[3]) + 1);
        String maxRangeVal = ipAddrOctetArray[0] + "." + ipAddrOctetArray[1] + "." + ipAddrOctetArray[2] + "." + NBREIP;
        
       
        //retour resultat sous forme decriptable 
        return (IPRESULTAT + "/" + NBREIP + "/" + minRangeVal + "/" + maxRangeVal);
         
        }else{
        return errorMSG();
        }
    }

    
    /**
     * Affiche une erreur si l'addresse n'est pas correctement saisie
     *
     * @return ErrorMessage si l'addresse n'a pas été correctement saisie
     */
    public String errorMSG() {
        return "Erreur : Verifiez que vous avez correctement saisie l'addresse IP ou/et le masque de sous réseaux ";
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIp1Field4 = new javax.swing.JTextField();
        jTextFieldIp1Field3 = new javax.swing.JTextField();
        jTextFieldMasqueSR1Field4 = new javax.swing.JTextField();
        jTextFieldIp1Field2 = new javax.swing.JTextField();
        jTextFieldIp1Field1 = new javax.swing.JTextField();
        jTextFieldMasqueSR1Field2 = new javax.swing.JTextField();
        jTextFieldMasqueSR1Field1 = new javax.swing.JTextField();
        jTextFieldMasqueSR1Field3 = new javax.swing.JTextField();

        jTextFieldIp1Field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIp1Field3ActionPerformed(evt);
            }
        });

        jTextFieldIp1Field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIp1Field2ActionPerformed(evt);
            }
        });

        jTextFieldMasqueSR1Field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMasqueSR1Field2ActionPerformed(evt);
            }
        });

        jTextFieldMasqueSR1Field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMasqueSR1Field3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIp1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldIp1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldMasqueSR1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMasqueSR1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIp1Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldIp1Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldMasqueSR1Field3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMasqueSR1Field4)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIp1Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIp1Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIp1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIp1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMasqueSR1Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMasqueSR1Field2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMasqueSR1Field3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMasqueSR1Field4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMasqueSR1Field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMasqueSR1Field3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMasqueSR1Field3ActionPerformed

    private void jTextFieldIp1Field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIp1Field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIp1Field2ActionPerformed

    private void jTextFieldIp1Field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIp1Field3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIp1Field3ActionPerformed

    private void jTextFieldMasqueSR1Field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMasqueSR1Field2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMasqueSR1Field2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextFieldIp1Field1;
    private javax.swing.JTextField jTextFieldIp1Field2;
    private javax.swing.JTextField jTextFieldIp1Field3;
    private javax.swing.JTextField jTextFieldIp1Field4;
    private javax.swing.JTextField jTextFieldMasqueSR1Field1;
    private javax.swing.JTextField jTextFieldMasqueSR1Field2;
    private javax.swing.JTextField jTextFieldMasqueSR1Field3;
    private javax.swing.JTextField jTextFieldMasqueSR1Field4;
    // End of variables declaration//GEN-END:variables

    private void AND(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
