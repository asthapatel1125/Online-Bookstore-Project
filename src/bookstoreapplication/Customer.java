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
    public double totalPrice;
    public Customer(String username, String password, int p)
    {
        this.username = username;
        this.password = password;
        points = p;
        if(p>=1000){
            status=new Gold();
        }else{
            status=new Silver();
        }
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
    
    public ArrayList getShopping(){
        return shoppingCart;
    }
   
    public void setPoints(int p){
        points=p;
    }
    
    public double buyBook()
    {  
        
        double totalPrice = 0.0;
        int pointsEarned =0;
        
       //buy selected books
        for(Book book : shoppingCart)
        {
            totalPrice += book.getBookPrice();
            pointsEarned += calculatePoints(book);
            Owner.getBookList().remove(book);
        }
        deselectBooks();
        this.points =+ pointsEarned;
        if(this.points >= 1000)  
                this.status = new Gold();
            else this.status = new Silver();
        return totalPrice;
    }
    
    public void selectBook(Book b)
    {
        shoppingCart.add(b);
    }
    
    public void deselectBooks()
    {
        shoppingCart.clear();
    }
    
    public int calculatePoints(Book b)
    {
        int pointsPerBook =0;
        
        pointsPerBook = ((int) b.getBookPrice())*10;
        
        return pointsPerBook;
    }
    
    public double redeemPointsAndBuy()
    {
        double totalPrice,orgPrice,deductPrice;
        
        deductPrice = (int)(this.points*0.01);//1 CAD per 100 points
        orgPrice = buyBook(); 
        totalPrice = orgPrice - deductPrice;
        
        if(totalPrice <0)
        {
            this.points = (-1)*(int)(totalPrice * 100);
            
            if(this.points >= 1000)  
                this.status = new Gold();
            else this.status = new Silver();
            
            return 0.0;
        }
        else return totalPrice;
    }
   
    public void setStatus(Status s)
    {this.status =s;}
    
    public Status getStatus()
    {return this.status; }
}
