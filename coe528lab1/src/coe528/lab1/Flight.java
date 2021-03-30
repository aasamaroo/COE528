package coe528.lab1;



public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
    
    
    if(flightNumber < 0){
        throw new IllegalArgumentException("Flight Number cannot be a negative number.");
    }
    
   
    this.flightNumber=flightNumber;
    
    this.origin=origin;
    
    this.destination=destination;
    
    this.departureTime=departureTime;
    
    
    if(capacity < 0){
        throw new IllegalArgumentException("Capacity cannot be negative.");
    }
    this.capacity=capacity;
    
    
    if(originalPrice<0){
        throw new IllegalArgumentException("A negative price means we have to give them money. Come on now we're a business. We want to MAKE money not PAY!");
    }
    this.originalPrice=originalPrice;
}    
    
public void setFlightNumber(int flightNumber){
     if(flightNumber < 0){
        throw new IllegalArgumentException("Flight Number cannot be a negative number.");
    }
    this.flightNumber=flightNumber;
}

public void setOrigin(String origin){
    this.origin=origin;
}
   
public void setDestination(String destination){
    this.destination=destination;
}

public void setDepartureTime(String departureTime){
this.departureTime=departureTime;    
}

public void setCapacity(int capacity){
      if(capacity < 0){
        throw new IllegalArgumentException("Capacity cannot be negative.");
    }
    this.capacity=capacity;
}

 public void setOriginalPrice(int originalPrice){
      if(originalPrice<0){
        throw new IllegalArgumentException("A negative price means we have to give them money. Come on now we're a business. We want to MAKE money not PAY!");
    }
    this.originalPrice=originalPrice;
}
 
public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
    this.numberOfSeatsLeft=numberOfSeatsLeft;
} 

public int getFlightNumber(){

    return this.flightNumber;
}
 
public String getOrigin(){
    return this.origin;
} 
 
public String getDestination(){
    return this.destination;
} 
 
public String getDepartureTime(){
    return this.departureTime;
} 
 
public int getCapacity(){
 
    return this.capacity;
}

public double getOriginalPrice(){
  
    return this.originalPrice;
}

public int getNumberOfSeatsLeft(){
    return this.numberOfSeatsLeft;
}

public void bookASeat(){
    if(numberOfSeatsLeft==capacity){
        throw new IllegalArgumentException("Flight is fully booked");
    }
}

@Override
public String toString(){
    return("Flight: " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", Original Price: $" + originalPrice);
}
}