/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Client;
import entity.User;
import entity.facade.ClientFacade;
import entity.facade.UserFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;

/**
 *
 * @author Dilerom
 */
public class UserManager {
    private Scanner scanner = new Scanner(System.in);
    private ClientFacade clientFacade = FacadeFactory.getClientFacade();
    private UserFacade userFacade = FacadeFactory.getUserFacade();

    public User createUser() {
        CreateClient createClient = new CreateClient();
        Client client = createClient.createClient();
        User user = new User();
        System.out.println("Добавить покупателя");
        System.out.println("Логин:");
        user.setLogin(scanner.nextLine());
        System.out.println("Пароль:");
        user.setPassword(scanner.nextLine());
        int modelRole;
        do{
            System.out.println("Доступные роли:");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                        ,i+1
                        ,SecureManager.role.values()[i].toString()
                );
            }
            System.out.println("Введите номер роли:");
            String modelRoleStr = scanner.nextLine();
            try {
                modelRole = Integer.parseInt(modelRoleStr);
                break;
            } catch (Exception e) {
                System.out.println("Введите число.");
            }
        }while(true);
        user.setRole(SecureManager.role.values()[modelRole-1].toString());
        user.setClient(client);
        userFacade.create(user);
        return user;
    }
  
    public User getCheckInUser() {
        System.out.println("Войти");
        System.out.print("Логин: ");
        String login = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        List<User> listUsers = userFacade.findAll();
        if(listUsers == null){
            System.out.println("Нет пользователей. Зарегистрируйтесь!");
            return null;
        }
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i) != null && listUsers.get(i).getLogin().equals(login)){
                for (int x = 0; x < 2; x++) {
                   if(listUsers.get(i).getPassword().equals(password)){
                       return listUsers.get(i);
                   }else{
                       System.out.println("Неверный логин или пароль.");
                       password = scanner.nextLine();
                   }
                }
                System.out.println("Такой учетной записи нет.");
                return null;
            }
        }
        System.out.println("Такой учетной записи нет. Зарегистрируйтесь!");
        return null;
    }
    
}
