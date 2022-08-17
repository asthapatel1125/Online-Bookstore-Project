/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

/**
 *
 * @author astha
 */
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

public class Customer {
    private int points;
    private Status status;
    private String username;
    private String password;
    private CheckBox select;
    private ArrayList<Book> shoppingCart = new ArrayList<>();
    public Customer(String username, String password, int p)
    {
        this.username = username;
        this.password = password;
        points = p;
        this.select = new CheckBox();
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public int getPoints(){
        return points;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void loginInstance()
    {  }
    
    public void logout()
    { }
    
    public double buyBook()
    {  
        
        double totalPrice = 0.0;
        int pointsEarned =0;
        
       //buy selected books
        for(Book book : shoppingCart)
        {
            totalPrice =+ book.getBookPrice();
            pointsEarned =+ calculatePoints(book);
        }
        
        this.points =+ pointsEarned;
        
        return totalPrice;
    }
    
    public void selectBook(Book b)
    {
        shoppingCart.add(b);
    }
    
    public void deselectBook(Book b)
    {
        shoppingCart.remove(b);
    }
    
    public int calculatePoints(Book b)
    {
        int pointsPerBook =0;
        
        pointsPerBook = ((int) b.getBookPrice())*10;
        
        return pointsPerBook;
    }
    
    public Book redeemPoints(Book b)
    {
        return null;
    }
   
    public void setStatus(Status s)
    {this.status =s;}
    
    public Status getStatus()
    {return this.status; }
}
