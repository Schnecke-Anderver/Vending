/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.Product;
import entity.Journal;
import entity.Client;
import entity.User;
import entity.facade.ProductFacade;
import entity.facade.JournalFacade;
import entity.facade.ClientFacade;
import entity.facade.UserFacade;

/**
 *
 * @author Dilerom
 */
public class FacadeFactory {
    public static ProductFacade getProductFacade(){
        return new ProductFacade();
    }
    public static UserFacade getUserFacade(){
        return new UserFacade();
    }
    public static ClientFacade getClientFacade(){
        return new ClientFacade();
    }
    public static JournalFacade getJournalFacade(){
        return new JournalFacade();
    }
}
