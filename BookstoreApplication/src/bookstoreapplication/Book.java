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

import javafx.beans.property.*;
import javafx.scene.control.*;

public class Book {
    private SimpleDoubleProperty bookPrice;
    private SimpleStringProperty bookName;
    private CheckBox selection;

    public Book(String n, double p)
    {
        bookName = new SimpleStringProperty(n);
        bookPrice = new SimpleDoubleProperty(p);
        this.selection = new CheckBox();
    }
    
    public double getBookPrice()
    {return bookPrice.get();}
    
   public String getBookName()
   {return bookName.get();}
   
   public void setBookName(String bookname)
   {
       bookNameProperty().set(bookname);
   }
   
   public void setBookPrice(double bookprice)
   {
       bookPriceProperty().set(bookprice);
   }
   
   public StringProperty bookNameProperty()
   {
       if(bookName == null)
           bookName = new SimpleStringProperty(this, "bookName");
       return bookName;
   }
   
   public DoubleProperty bookPriceProperty()
   {
       return bookPrice;
   }
   
   public CheckBox getSelection()
   {
       return selection;
   }
   public void setSelection(CheckBox c)
   {
       this.selection = c;
   }
}
