/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author astha
 */
public class Owner {
   
    private static ArrayList<Customer> customerList = new ArrayList();
    private static ArrayList<Book> bookList = new ArrayList();
    private static int instance;
    
   public static void setInstance(int i){
       instance=i;
   }
   
   public static int getInstance(){
       return instance;
   }
    
    public void deleteCustomer(Customer c)
    {
        customerList.remove(c);
    }
    
    public void deleteBook(Book b)
    {
        bookList.remove(b);
    }
    
  public static ArrayList getBookList()
  {
      return bookList;
  }
  
  public static ArrayList<Customer> getCustomerList(){
      return customerList;
  }
  
  public void fillBookList()
  {
       try
        {
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            String readInput;
            while((readInput=br.readLine())!=null)
            {
               
                String[] split = readInput.split(", ");
                bookList.add(new Book(split[0], Double.parseDouble(split[1])));
                
                
            }
            
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
  }
  public void readCustomerList()
  {
       try
        {
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));
            String readInput;
            while((readInput=br.readLine())!=null)
            {
                String[] split = readInput.split(", ");
                customerList.add(new Customer(split[0],split[1],Integer.parseInt(split[2])));
                
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
  }
  
  public static void updateBookList()
  {
      try
      {
          BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt", false));
          for(int i = 0; i<bookList.size();i++)
          {
            bw.write(bookList.get(i).getBookName()+", "+bookList.get(i).getBookPrice());
            bw.newLine();  
          }
            
            
            
            bw.close();
      }
      catch(IOException e)
      {
          
      }
  }
  
  public static void updateCustomerList(){
      try
      {
        BufferedWriter bw = new BufferedWriter(new FileWriter("customer.txt", false));
        for(Customer c: customerList){
            {
                bw.write(c.getUsername()+ ", " +c.getPassword()+", "+c.getPoints());
                bw.newLine();
            }
        } 
            bw.close();
      }
      catch(IOException e)
      {
          
      }
  }
                  
    
  
    
    
}
