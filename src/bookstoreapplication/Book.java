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
    private double bookPrice;
    private String bookName;
    private CheckBox selection;

    public Book(String n, double p)
    {
        bookName = n;
        bookPrice = p;
        this.selection = new CheckBox();
    }
    
    public double getBookPrice()
    {return bookPrice;}
    
   public String getBookName()
   {return bookName;}
   
   public void setBookName(String bookname)
   {
       bookName=bookname;
   }
   
   public void setBookPrice(double bookprice)
   {
       bookPrice=bookprice;
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
