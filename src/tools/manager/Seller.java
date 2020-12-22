/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import java.util.Scanner;
import entity.Product;
import entity.facade.ProductFacade;
import factory.FacadeFactory;
import java.util.List;
/**
 *
 * @author Dilerom
 */
public class Seller {
    
    private ProductFacade productFacade = FacadeFactory.getProductFacade();
    
      public Product createProduct() {
        Product product = new Product();// инициализация
        Scanner scanner = new Scanner(System.in);// ч/з сканер вводим с помощью сеттеров название, цену, кол-во 
        System.out.println("---Внести чудо в реестр---");
        System.out.println("Введите название");        
        product.setName(scanner.nextLine());
        System.out.println("Введите цену"); // здесь позже нужно сделать проверку на корректность ввода символов ( do/while )
        product.setPrice(scanner.nextInt());
        System.out.println("Введите количество");// здесь позже нужно сделать проверку на корректность ввода символов ( do/while )
        product.setQuantity(scanner.nextInt());       
        
        int tagPrice;
        do{
            System.out.println("Введите стоимость чуда");
            String priceStr = scanner.nextLine();
            try {
                tagPrice = Integer.parseInt(priceStr);
                break;
            } catch (Exception e) {
                System.out.println("Введите только цифры!");
            }
        }while(true);
        product.setPrice(tagPrice);        
        
         int exactQuantity;
        do{
            System.out.println("Введите количество");
            String strQuantity = scanner.nextLine();
            try {
                exactQuantity = Integer.parseInt(strQuantity);
                break;
            } catch (Exception e) {
                System.out.println("Вводите только цифры!");
            }
        }while(true);
        product.setQuantity(exactQuantity);
        productFacade.create(product);
        return product;
        
    }
        public boolean printListProducts() {
        List<Product> listProducts = productFacade.findAll();
        if(listProducts == null || listProducts.size() < 1){
            System.out.println("На полках еще нет ни одного чуда");
            return false;
        }
        for (Product y : listProducts) {
            if(y != null){
                System.out.println(y.getId()+". "+y.toString());
            }
        }
        return true;
    }
      
}
   /*
     
    //создадим массивы товаров, в которых сохраним информацию о товаре (название, цена, количество)
    static ArrayList<String> name = new ArrayList<String>();
    static ArrayList<Double> price = new ArrayList<Double>();
    static ArrayList<Integer> quantity = new ArrayList<Integer>();
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        name.add("Фонтан чувственных искр. При использовании держите глаза открытыми. ");
        price.add(1.50);
        quantity.add(100);
        name.add("Вдохновенные брызги огня. Не открывать в замкнутом помещении. ");
        price.add(2.30);
        quantity.add(200);
        name.add("Лоскут радуги. Не больше 3 метров в одни руки. ");
        price.add(3.90);
        quantity.add(300);
        name.add("Пузырек радости. Гипоаллергенно. ");
        price.add(1.70);
        quantity.add(150);
        name.add("Микстура счастья. Реакция индивидуальна. ");
        price.add(5.80);
        quantity.add(480);
        name.add("Капля мудрости. Действие временно. ");
        price.add(20.00);
        quantity.add(10);
        name.add("Капля разума. Действие временно. ");
        price.add(20.00);
        quantity.add(10);
        name.add("Запахи соснового бора. Для достижения терапевтического эффекта вдыхать не менее 30 минут! ");
        price.add(0.70);
        quantity.add(100);
        
    }
*/