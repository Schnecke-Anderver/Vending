/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Client;
import entity.facade.ClientFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CreateClient {
    private ClientFacade clientFacade = FacadeFactory.getClientFacade();

    public Client createClient() {
       Client client = new Client();
        System.out.println("Регистрация клиента");
        System.out.println("----------------------------------------------");
        System.out.println("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        client.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        client.setLastname(scanner.nextLine());
        System.out.println("Введите телефон: ");
        client.setPhone(scanner.nextLine()); 
        
           int hardCash;
        do{
            System.out.println("Количество наличных?");
            String strCash = scanner.nextLine();
            try {
                hardCash = Integer.parseInt(strCash);
                break;
            } catch (Exception e) {
                System.out.println("Введите только цифры!");
            }
        }while(true);
        client.setCash(hardCash);

       
        clientFacade.create(client);
        return client;
    }  
    
    
     public void printListClients() {
        List<Client> listClients = clientFacade.findAll();
        if(listClients == null){
            System.out.println("Записи о клиентах отсутствуют");
            return;
        }
        for (Client v : listClients) {
            if(v != null){
                System.out.println(v.getId()+". "+v.toString());
            }
        }
    }
    
}
