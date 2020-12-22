/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Journal;
import entity.Client;
import factory.ConnectSingleton;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Dilerom
 */
public class JournalFacade extends AbstractFacade<Journal>{
    

    public JournalFacade() {
        super(Journal.class);
    }
   
    @Override
    protected EntityManager getEntityManager() {
        ConnectSingleton connect = ConnectSingleton.getInstance();
        return connect.getEntityManager();
    }
  
    public List<Journal> findAll(boolean journalId) {
        try {
            return getEntityManager().createQuery("SELECT j FROM Journal j WHERE h.id = :id")
                    .setParameter("id", journalId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }   

    public List<Journal> findAll(Client client) {
        try {
            return getEntityManager().createQuery("SELECT j FROM Journal j WHERE j.client=:client")
                    .setParameter("client", client)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }    
}
