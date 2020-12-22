/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Client;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author Dilerom
 */
public class ClientFacade extends AbstractFacade<Client>{
   
    public ClientFacade() {
        super(Client.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        ConnectSingleton connect = ConnectSingleton.getInstance();
        return connect.getEntityManager();
    }
    
}

