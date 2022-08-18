/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;
import java.util.ArrayList;

/**
 *
 * @author astha
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int ticketNum = 1;
    
    public Ticket(Passenger p,Flight flight, double price)
    {
        passenger = p;
        this.flight =flight;
        this.price = price;
    }
    
    //getter and setter methods for each variable
    
    public Passenger getPassenger()
    {return this.passenger;}
    
    public void setPassenger(Passenger p)
    {
        this.passenger = p;
    }
    
    public Flight getFlight()
    {return this.flight;}
   
    public void setFlight(Flight f)
    {
        this.flight = f;
    }
    
    public double getPrice()
    {return this.price;}
    
    public void setPrice(double price)
    {
        this.price = price;
    }        
    
    @Override 
    public String toString()
    {return " "+ this.passenger.getName() + ", Flight " + 
            this.flight.getFlightNumber()+", "+ this.flight.getOrigin()+ " to "+ 
            this.flight.getDestination()+ ", " + " departing " + 
            this.flight.getDepartureTime() + ", original price: " + 
            this.flight.getOriginalPrice()+ "$, "+" ticket price: " + 
            this.price + "$.";}
    
}