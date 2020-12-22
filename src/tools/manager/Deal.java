
package tools.manager;

import entity.Client;
import entity.Journal;
import entity.Product;
import java.util.Scanner;
import java.util.List;
import entity.facade.ProductFacade;
import entity.facade.JournalFacade;
import entity.facade.ClientFacade;
import factory.FacadeFactory;
import vending.App;
import security.SecureManager;


/**
 *
 * @author Dilerom
 */

public class Deal {    // здесь совершается сделка
    
    private Scanner scanner = new Scanner(System.in);    
    
    private Seller seller = new Seller();
    private CreateClient createClient = new CreateClient();
    private ProductFacade productFacade = FacadeFactory.getProductFacade();
    private ClientFacade clientFacade = FacadeFactory.getClientFacade();
    private JournalFacade journalFacade = FacadeFactory.getJournalFacade();
     
    
    public void checkOutProduct() {
        System.out.println("Каталог чудес");
        Long numrProduct;
        do{
            if(!seller.printListProducts()){
                return;
            };
            System.out.print("Введите номер чуда: ");    
            String numrProductStr = scanner.nextLine();
            try {
                numrProduct = Long.parseLong(numrProductStr);
                break;
            } catch (Exception e) {
                System.out.println("Выберите номер чуда.");
            }
        }while(true);
        Product product = productFacade.find(numrProduct);
        Client client = null;
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            Long numrClient;
            do{
                System.out.println("Список клиентов");
                createClient.printListClients();
                System.out.print("Выберите номер клиента: ");    
                String numrClientStr = scanner.nextLine();
                try {
                    numrClient = Long.parseLong(numrClientStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Выберите номер клиента: ");
                }
            }while(true);
            client = clientFacade.find(numrClient);
        }else if(SecureManager.role.CLIENT.toString().equals(App.loggedInUser.getRole())){
            client = App.loggedInUser.getClient();
        }
        Journal journal = new Journal(product, client);
        journalFacade.create(journal);
    }
    
    public boolean printListReadProducts() {
        
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            List<Journal> listJournals = journalFacade.findAll(true);
            if(listJournals == null){
                System.out.println("Совершенных сделок нет");
                return false;
            }
            for (int i = 0; i < listJournals.size(); i++) {
                System.out.printf("Список выменянных чудес: "
                        ,listJournals.get(i).getId()
                        ,listJournals.get(i).getProduct().getName()
                        ,listJournals.get(i).getClient().getFirstname()
                        ,listJournals.get(i).getClient().getLastname()
                );
            }
        }else if(SecureManager.role.CLIENT.toString().equals(App.loggedInUser.getRole())){
            List<Journal> listJournals = journalFacade.findAll(App.loggedInUser.getClient());
            if(listJournals == null){
                System.out.println("Совершенных сделок нет");
                return false;
            }
            for (int i = 0; i < listJournals.size(); i++) {
                System.out.printf("Список выменянных чудес: "
                        ,listJournals.get(i).getId()
                        ,listJournals.get(i).getProduct().getName()
                        ,listJournals.get(i).getClient().getFirstname()
                        ,listJournals.get(i).getClient().getLastname()
                );
            }
        }
        return true;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
