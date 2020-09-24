/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package com.mycompany.ppe3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author FIGUERES Adrien
 */
public class bddSQL {
    
    
    Connection connexion;
    
    public void connexionBdd(){
        
        Formulaire form = new Formulaire();
        //Information(s) BDD
        String url = "jdbc:mysql://localhost/ppe3_logicielbdd_off"; 
        String logUser = "root";
        String logPass = "toor";
         
        //Connexion BDD
        try {
            this.connexion = (Connection) DriverManager.getConnection(url, logUser, logPass);
            System.out.println("Connexion Enabled with the DataBase");
            System.out.println("Interaction Enabled with the Database");
            
        } catch (SQLException ex) {
            Logger.getLogger(bddSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connexion Failed with the DataBase");
            System.out.println("Interaction Failed with the DataBase");
            
        }
       
        
    } 
}
