/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author astha
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
 @Test
    public void testConstructor()
    {
        System.out.println("Test constructor");
        Flight f = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        assertEquals(1030, f.getFlightNumber());
        assertEquals("Toronto",f.getOrigin());
        assertEquals("Kolkata",f.getDestination());
        assertEquals("03/02/99 7:50 pm", f.getDepartureTime());
        assertEquals(500, f.getCapacity());
        assertEquals(1000.0,f.getOriginalPrice(),2);
    }
    
    @Test
    public void testInvalidConstructor()
    {
        System.out.println("Test invalid constructor");
        Flight f=new Flight(1111,"Toronto","Ottawa","22/01/24 7:50 pm",50,10.0);
    }
    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        int expResult = 1030;
        int result = instance.getFlightNumber();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int flightNum = 1111; //the set method must set this new value.
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setFlightNumber(flightNum);
        assertEquals(flightNum,instance.getFlightNumber());
 
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Flight instance =new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        String expResult = "Toronto";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String o = "Ottawa";
        Flight instance =new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setOrigin(o);
        assertEquals(o,instance.getOrigin());
   
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        String expResult = "Kolkata";
        String result = instance.getDestination();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String d = "Quebec";
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setDestination(d);
        assertEquals(d,instance.getDestination());
        
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        String expResult = "03/02/99 7:50 pm";
        String result = instance.getDepartureTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String dep = "01/24/22";
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setDepartureTime(dep);
        assertEquals(dep,instance.getDepartureTime());
     
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        int expResult = 500;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getNumberOfSeats method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeats");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        int expResult = 500;
        int result = instance.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int numOfSeatsLeft = 600;
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setNumberOfSeatsLeft(numOfSeatsLeft);
        assertEquals(600,instance.getNumberOfSeatsLeft());
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        double expResult = 1000.0;
        double result = instance.getOriginalPrice();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double ogPrice = 200.0;
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        instance.setOriginalPrice(ogPrice);
        assertEquals(200.0,instance.getOriginalPrice(),0.0);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm",500,1000.0);
        String expResult = "Flight 1030, Toronto to Kolkata departing 03/02/99 7:50 pm, original price: 1000.0$.";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}