
package coe528.lab1;

import java.util.ArrayList;

public class Manager  {
          private final ArrayList <Flight> flightList;
         
public Manager(){
    flightList = new ArrayList<>();
}      
    public void createFlights(Flight f){
   flightList.add(f);
    }
    
    public void displayAvailableFlights(String origin, String destination){
   for(int x = 0; x<flightList.size(); x++){
       Flight fl = flightList.get(x);
       if(fl.getOrigin().equals(origin) && fl.getDestination().equals(destination)){
           if(fl.getNumberOfSeatsLeft()>0){
               System.out.println("Flight " + fl.getFlightNumber() + " From: " + fl.getOrigin() + " To: " + fl.getDestination() + " Is available for: " + fl.getOriginalPrice());
           } else System.out.println("This flight is unavailable");
       } else System.out.println("Flight does not exist");
       break;
   }
   }
    
    public Flight getFlight(int flightNumber){
     Flight x = new Flight(0, "Origin", "Destination", "Depart", 0, 0); //creates some new flight variable x
        for(int y = 0; y<flightList.size(); y++){  //checks entire array for flight with specified flight number
            Flight fli = flightList.get(y);
            if(fli.getFlightNumber() == flightNumber)
            x = fli; //sets x to the flight with the specified flight number
        }
        return x;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
         for(int y = 0; y<flightList.size(); y++){ //searches array of flights
            Flight fli = flightList.get(y);
            if(fli.getFlightNumber() == flightNumber){//finds flight that matches specified flight number
                if(fli.getNumberOfSeatsLeft()>0){ //checks if there are seats available
                   Ticket t = new Ticket(p, fli, fli.getOriginalPrice()); //creates new ticket for the flight
                   t.setPrice(fli.getOriginalPrice() * p.applyDiscount(y)); //sets price depending on discount
                    System.out.println("A Ticket has been booked for " + p.getName() + " for " + fli.toString() + " Discount applied: $" + t.getPrice());
                   fli.setNumberOfSeatsLeft(fli.getNumberOfSeatsLeft()-1); //one less seat left after ticket booked
                }
            }
    }
    }
    
    
    
    public static void main(String[] args){
    
     Manager m = new Manager();
     
     Flight f0 = new Flight(1030, "Toronto", "Katowice", "03/02/2020 19:00", 300, 1000);
     
     f0.setNumberOfSeatsLeft(f0.getCapacity()); //initially set the number of seats left to the capacity of the flight
     
     Flight f1 = new Flight(1169, "Paris", "London", "05/06/2020 11:30", 400, 750); 
     
     f1.setNumberOfSeatsLeft(f1.getCapacity()); //initially set the number of seats left to the capacity of the flight
             
     m.createFlights(f0); //store in array
     
     m.createFlights(f1); //store in array
     
    System.out.println(f0.toString()); 
    
    System.out.println(f1.toString());
    
    
  Member mem1 = new Member("John Price", 43, 7); //member with more than 5 years of membership; 50% discount
  
  m.bookSeat(1030, mem1);
  
 NonMember nonMem1 = new NonMember("Jason Todd", 23); //nonmember under age of 65; no discount
 
 m.bookSeat(1169, nonMem1);
 
 Member mem2 = new Member("Eliza Cohen", 36, 3); //member with less than 5 years of membership; will get 10% discount
 
 m.bookSeat(1169, mem2);
 
 NonMember nonMem2 = new NonMember("Thor Odinson", 1000); //nonmember over age of 65; will get 10% discount
 
 m.bookSeat(1030, nonMem2);
  
 m.displayAvailableFlights("Berlin", "Moscow"); //tries to display a flight with origin and destination that does not exist
  
 m.displayAvailableFlights("Toronto", "Katowice"); //tries to display flight with an existing origin and matchiing destination
 
 m.displayAvailableFlights("Toronto", "Los Angeles"); //tries to display flight with an existing origin, but not matching destination
 
    
        
        
        
        
        
        
        
        
    }
}
