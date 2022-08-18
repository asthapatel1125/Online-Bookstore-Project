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
}