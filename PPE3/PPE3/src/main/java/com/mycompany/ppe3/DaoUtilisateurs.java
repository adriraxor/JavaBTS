/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.nadal
 */
public class DaoUtilisateurs{

    public DaoUtilisateurs() {
        
    }
    
    public void imprimerLesUtilisateurs(){
        
        //on récupère une connexion au serveur de BDD
        
        DaoSIO co=DaoSIO.getInstance();
       
        //On exécute la requete
        ResultSet lesResultats=co.requeteSelection("select * from utilisateurs");
        
        try {
            while(lesResultats.next()){
                System.out.println(lesResultats.getString("identifiant"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }
    
    
}