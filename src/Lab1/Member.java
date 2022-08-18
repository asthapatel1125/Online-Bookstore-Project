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
public class Member extends Passenger{
    private int yearsOfMembership;
    
    public Member(int yearsOfMembership,String name,int age)
    {
        super(name,age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    public int getyearsOfMembership()
    {return this.yearsOfMembership;}
    
    public void setYearsOfMembership(int y)
    { this.yearsOfMembership = y;}
    
    @Override
    public double applyDiscount(double p)
    { if(this.yearsOfMembership>5)
        return (0.5*p);
     else if(this.yearsOfMembership <=5)
        return (0.1*p);
      else return p;}
    
}
