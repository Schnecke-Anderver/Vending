/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

import factory.ConnectSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pupil
 */
public class Vending {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();        
        try{
            app.run();
        } finally {
            ConnectSingleton connect = ConnectSingleton.getInstance();
            EntityManager em = connect.getEntityManager();
            EntityManagerFactory emf = connect.getEntityManagerFactory();
            if(em != null) {
                em.close();
            }
            if(emf != null){
                emf.close();
            }
            
        }
    }
    
}
