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
public abstract class Status {
    
    public abstract void updateStatus(Customer c);
    public abstract void downgradeStatus(Customer c);
}
