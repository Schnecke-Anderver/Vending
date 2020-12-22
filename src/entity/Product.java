/*
 * в сущности должны присудствовать анотации и необходимые члены класса:
- поля, в которых хранится состояние сущности
- пустой конструктор
- геттеры и сеттеры для всех полей
- переопределение equals & hashCode
- переопределение метода toString()

 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author User
 */
@Entity
public class Product implements Serializable { // implements Serializable - список продуктов будет сохраняться в отдельном файле 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    
     public Product(){    // пустой конструктор 
    }
    
    public Product(String name, Integer price, Integer quantity) { // сделали конструктор через Insert code - Konstruktor
        this.name = name;
        this.price = price;
        this.setQuantity(quantity); //это часть проверки, сразу сверяемся с количеством товара
    }
    
     public Product(String name, Integer price, String quantity) { 
        this.name = name;
        this.price = price;
        setQuantity(quantity); 
    }
    
    
       public String getName() { // создали конструкцию getter-setter через Insert code
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    
    public void setQuantity(Integer quantity) {
        if(quantity <= 0){ // proverka на правильность введенного количества товара. 
            return;       // Пригодиться, когда буду писать операцию добавления не товара целиком, а только его количества.
        }
        this.quantity = quantity;
    }    
    
     public void setQuantity(String quantity) {
      try {
          Integer quantityInt = Integer.parseInt(quantity);
          this.quantity = quantityInt;
          System.out.println("Строка "+quantity+" успешно преобразована в число.");
      } catch (Exception e) {
          System.out.println("Введены не цифры. Поле не изменено");
      }

    }
    
    @Override  //метод переопределения родительского метода в тот, что нам нужен.
    public String toString() {
        return "Product{" 
                + "name = " + name
                +  "  price = " + price 
                +  "  quantity = " + quantity 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.price);
        hash = 19 * hash + Objects.hashCode(this.quantity);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        return true;
    }
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
