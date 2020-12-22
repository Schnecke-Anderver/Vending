/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

import entity.User;
import security.SecureManager;
import ui.UserInterface;


/**
 *
 * @author Dilerom
 */
public class App {
    public static enum storageFile{PRODUCTS, CLIENTS, USERS, JOURNALS};
    public static User loggedInUser;
    
    public App() {
    }
    
    public void run() {
      
            System.out.println("--Лавка чудес--");
            SecureManager secureManager = new SecureManager();
            App.loggedInUser = secureManager.checkInLogin();
            UserInterface userInterface = new UserInterface();
            if(App.loggedInUser == null){
                System.out.println("У вас нет прав доступа");
                return;
            }
            if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
               userInterface.printManagerUI();
            }else if(SecureManager.role.CLIENT.toString().equals(App.loggedInUser.getRole())){
                userInterface.printClientUI();
            }
        
    }

}
