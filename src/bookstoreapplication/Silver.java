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
public class Silver extends Status {
   private String s="Silver";
   @Override
   public  void updateStatus(Customer c)
   {
       c.setStatus(new Gold());
   }
   
   @Override
   public  void downgradeStatus(Customer c)
   {
        //DO NOTHING
   }
   
   @Override 
   public String toString(){
       return s;
   }
}