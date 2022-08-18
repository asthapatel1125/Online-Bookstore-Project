/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author astha
 */
public class Manager {
    private static ArrayList<Flight> flight = new ArrayList<>();
    private static ArrayList<Ticket> issuedTicket = new ArrayList<>();
    private static int ticketNum =0;
    
    //ask for user input.
    public void createFlights()
    {   
        Scanner flightInfo = new Scanner(System.in);
        System.out.println("Enter flight info as follows:");
            
            System.out.println("Flight number: ");
            int flightNum = Integer.parseInt(flightInfo.nextLine());
            System.out.println("Origin:");
            String origin = flightInfo.nextLine();
            System.out.println("Destination:");
            String destination = flightInfo.nextLine();
            System.out.println("Departure time:");
            String departureTime = flightInfo.nextLine();
            System.out.println("Capacity:");
            int capacity = flightInfo.nextInt();
            System.out.println("Original price:");
            double OgPrice = flightInfo.nextDouble();
            
            //create flight
            Flight f = new Flight(flightNum,origin,destination,departureTime,capacity,OgPrice);
            flight.add(f);  
            
            //ask user if they want to create another flight
            Scanner addFlight = new Scanner(System.in);
            System.out.println("Enter 'Y' to add another flight, otherwise 'N':");
            String yOrN = addFlight.next();
                switch(yOrN)
                        {
                        case "Y":
                        case "y":
                            createFlights();
                            break;
                        case "N":
                        case "n":
                            break;
                        default :
                            break; 
                        }
    }
    
    
    public void displayAvailableFlights(String origin, String destination)
    {
        for(Flight f: flight)
        {       //search for flight based on the origin and destination
                if(f.getOrigin().equals(origin) && f.getDestination().equals(destination))
                { if((f.getNumberOfSeatsLeft() > 0))
                    { System.out.println("Available Flights: " + "\n" + f.toString());}
                }
               
        }   
                //ask user if they would like to check for another flight.
                Scanner checkFlight = new Scanner(System.in);
                System.out.println("Enter 'Y' to add check for another avaliable flight, otherwise 'N':");
                String yOrN = checkFlight.nextLine();
                switch(yOrN)
                    {
                        case "Y":
                        case "y":
                            Scanner avaFlight = new Scanner(System.in);
                            System.out.println("Enter origin:");
                            String org = avaFlight.nextLine();
                            System.out.println("Enter destination:");
                            String des = avaFlight.nextLine();
                            displayAvailableFlights(org,des);
                            break;
                        case "N":
                        case "n":
                            break;
                        default :
                            break; 
                    }
       
            
            
    }
    
    
    public Flight getFlight(int flightNumber)
    {   
        for(Flight flight:flight)
        {   
            //return flight information based on the flight number
            if(flight.getFlightNumber() == flightNumber)
                return flight;
        }

        return null;
    }
    
    
    public void bookSeat(int flightNumber, Passenger p)
    {
        //calling the previous method, so we can check for available flights
        Flight f = getFlight(flightNumber);
        if(f != null)
            {
                if(f.bookASeat())
                {
                     //if there are available flights then we check if there are any seats available, if so then book the tricket
                    double price = p.applyDiscount(f.getOriginalPrice());
                     issuedTicket.add(new Ticket(p,f,price));
                     System.out.println(issuedTicket.get(this.ticketNum).toString());
                     this.ticketNum++;
                }
                else System.out.println("There aren't any seats available.");
            }
     
    }
    
    
    
    //MAIN 
    public static void main(String[] args)
    {
        //create a Manager
        Manager rm = new Manager();
        
        //create a flight.
        rm.createFlights();
        System.out.println();
        
   
        
        
        //Check if the displayAvailableFlights() method works.
        Scanner flightsAvail = new Scanner(System.in);
        System.out.println("Available flights");
        System.out.println("Enter the origin:");
        String org = flightsAvail.nextLine();
        System.out.println("Enter the destination:");
        String des = flightsAvail.nextLine();
        rm.displayAvailableFlights(org, des);
        System.out.println();
        
        //Check if the getFlight() method works.
        Scanner flightNumber = new Scanner(System.in);
        System.out.println("Flight information based on its flight number");
        System.out.println("Enter a flight number:");
        int fNum = flightNumber.nextInt();
        System.out.println(rm.getFlight(fNum)); 
        System.out.println();
        
        
        //Check if the bookASeat() works
        Scanner ticket = new Scanner(System.in);
        System.out.println("How many tickets would you like to book? ");
        int numTickets = ticket.nextInt();
  
        for(int i=0 ; i<numTickets;i++)
        {
            Scanner passenger = new Scanner(System.in);
            System.out.println("To book a seat please provide information as follows:");
            System.out.println("Passenger name:");
            String name = passenger.nextLine();
            System.out.println("Passenger's age:");
            int age= passenger.nextInt();
            System.out.println("Years of membership:");
            int membership = passenger.nextInt();
            System.out.println("Enter flight number:");
            int fnum = passenger.nextInt();
            Passenger p;
                  
                if(membership > 5 )
                    p = new Member(membership,name,age);
                else 
                    p = new NonMember(name,age);
            rm.bookSeat(fnum, p);
        }
    
    }
}