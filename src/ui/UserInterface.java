
package ui;

import entity.Product;
import entity.User;
import java.util.Scanner;
import tools.manager.Seller;
import tools.manager.CreateClient;
import tools.manager.Deal;
import tools.manager.UserManager;



/**
 *
 * @author Dilerom
 */
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Seller seller = new Seller(); 
    private CreateClient createClient = new CreateClient(); 
    private Deal deal = new Deal();
    
    public void printManagerUI(){
        boolean repeat = true;
        do{
            
            System.out.println("Вам доступны следующие операции:");
            System.out.println("1.Добавить чудо");
            System.out.println("2.Посмотреть каталог чудес"); 
            System.out.println("3.Внести данные клиента");
            System.out.println("4.Посмотреть список клиентов"); 
            System.out.println("5.Магическая сделка");             
            System.out.println("6.Список магических сделок");  
            System.out.println("0.Закрыть лавочку");
            System.out.println("============================================");
            System.out.print("Выберите желаемую операцию: ");          
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("----Ой, как поздно! Заходите завтра!----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("----Добавить чудо----");
                    Product product = seller.createProduct();
                    break;
                case "2":
                    System.out.println("----Посмотреть каталог чудес----");
                    seller.printListProducts();
                    break;
                case "3":
                    System.out.println("----Внести данные клиента----");
                    UserManager userManager = new UserManager();
                    User user = userManager.createUser();
                    break;
                case "4":
                    System.out.println("----Список клиентов----");
                    createClient.printListClients();
                    break;
                case "5":
                    System.out.println("--- Выдать чудо и получить неразменный рубль клиента ---");
                    deal.checkOutProduct();
                    break;
                case "6":  
                    System.out.println("-----Список выменянных чудес-----");
                    deal.printListReadProducts();
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }
    public void printClientUI(){
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Вам доступны следующие операции:");
            System.out.println("1.Посмотреть каталог чудес");            
            System.out.println("2.Магическая сделка");             
            System.out.println("3.Список магических сделок");  
            System.out.println("0.Закрыть лавочку");
            String task = scanner.nextLine();
            System.out.println("=============================");
            System.out.print("Выберите желаемую операцию: "); 
            switch (task) {
                case "0":
                    System.out.println("----Ой, как поздно! Заходите завтра!----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("Посмотреть каталог чудес");
                    seller.printListProducts();
                    break;
                case "2":
                    System.out.println("Магическая сделка");
                    deal.checkOutProduct();
                    break;
                case "3":  
                    System.out.println("Список магических сделок");
                    deal.printListReadProducts();
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }
}
