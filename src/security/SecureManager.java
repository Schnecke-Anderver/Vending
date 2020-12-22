/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.User;
import factory.FacadeFactory;
import java.util.Scanner;
import tools.manager.CreateClient;
import tools.manager.UserManager;

/**
 *
 * @author Dilerom
 */
public class SecureManager {
private Scanner scanner = new Scanner(System.in);
private UserManager userManager = new UserManager();
private CreateClient createClient = new CreateClient();


public static enum role {CLIENT, MANAGER};

    public User checkInLogin() {
        do{
            System.out.println("Выберите операцию: ");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход");
            System.out.print("Введите номер операции: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("Приходите еще! :)");
                    System.exit(0);
                    break;
                case "1":
                    User user = userManager.createUser();
                    FacadeFactory.getUserFacade().create(user);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser();
                    if(checkInUser == null) break;
                    return checkInUser;
                default:
                    System.out.println("Операция не найдена.");;
            }
        }while(true);
    }
    
}
