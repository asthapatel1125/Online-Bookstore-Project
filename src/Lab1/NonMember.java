/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author astha
 */
public class NonMember extends Passenger{
    
    public NonMember(String name,int age)
    {
        super(name,age);
    }
    
    @Override
    public double applyDiscount(double p)
    {
        if(this.getAge()>65)
            return (p*0.1);
        else return p;
    }
}