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
public class Gold extends Status{
   private String s="Gold";
   @Override
   public  void updateStatus(Customer c)
   {
       //DO NOTHING
   }
   
   @Override
   public  void downgradeStatus(Customer c)
   {
        c.setStatus(new Silver());
   }
   
   @Override
   public String toString(){
        return s;
   }
}