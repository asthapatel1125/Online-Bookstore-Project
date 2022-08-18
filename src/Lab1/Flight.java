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
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int flightNumber,String origin, String destination, String departureTime,int capacity,double originalPrice)
    {
        try{
      if(origin.equals(destination))
          throw new IllegalArgumentException("Your origin and destination must be different.");
      this.flightNumber = flightNumber;
      this.origin = origin;
      this.destination = destination;
      this.departureTime = departureTime;
      this.capacity = capacity;
      this.numberOfSeatsLeft = capacity;
      this.originalPrice = originalPrice;}
        catch(IllegalArgumentException e)
        {System.out.println(e.toString());} //what is this used for?
        
      
    }
    
    public int getFlightNumber()
    {return this.flightNumber;}
    
    public void setFlightNumber(int flightNum)
    {this.flightNumber = flightNum;}
    
    public String getOrigin()
    {return this.origin;}
    
    public void setOrigin(String o)
    {
        try{
            if(o.equals(this.destination))
                throw new IllegalArgumentException("Your origin and destination must be different.");
            else this.origin = o;
        }
        catch(IllegalArgumentException e)
        { System.out.println(e);}
    }
    
    public String getDestination()
    {return this.destination;}
    
    public void setDestination(String d)
    {
      try{
          if(d.equals(this.origin))
              throw new IllegalArgumentException("Your origin and destination must be different.");
          else this.destination = d;
         }
      catch(IllegalArgumentException e)
      {
          System.out.println(e);
      }
    }
    
    public String getDepartureTime()
    {return this.departureTime;}
    
    public void setDepartureTime(String dep)
    {this.departureTime = dep;}
    
    public int getCapacity()
    {return this.capacity;}
    
    public int getNumberOfSeatsLeft()
    {return this.numberOfSeatsLeft;}
    
    public void setNumberOfSeatsLeft(int numOfSeatsLeft)
    {this.numberOfSeatsLeft =  numOfSeatsLeft;}
    
    public double getOriginalPrice()
    {return this.originalPrice;}
    
    public void setOriginalPrice(double ogPrice)
    { this.originalPrice = ogPrice; }
    
    public boolean bookASeat()
    {
        if(this.numberOfSeatsLeft > 0)
            { this.numberOfSeatsLeft --;
              return true;}
        else return false;
    }
    
    @Override
    public String toString()
    {return "Flight " + this.flightNumber + ", " + this.origin + " to " +
            this.destination + " departing " + this.departureTime + ", original price: "+
            this.originalPrice + "$.";}
}