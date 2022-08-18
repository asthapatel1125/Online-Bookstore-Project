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
public abstract class Passenger {
    private String name;
    private int age;
    
    public Passenger(String name,int age)
    {
        this.name = name;
      
        if(age<0)
            throw new IllegalArgumentException("Age must be greater than 0.");
        else 
            this.age =age;
    }

    
    public String getName()
    { return this.name; }
    
    public void setName(String n)
    { this.name = n; }
    
    public int getAge()
    {return this.age;}
    
    public void setAge(int a)
    { this.age =a; }
    
    public abstract double applyDiscount(double p);
}