
package coe528.lab1;


public class Ticket {
    private double price;
    private int number;
    private Passenger passenger;
    private Flight flight;
    
    public Ticket(Passenger p, Flight flight, double price){
        this.passenger=p;
        this.flight=flight;
        this.price=price;
    }
    
public void setPrice(double price){
    this.price=price;
}

public void setNumber(int number){
    this.number=number;
}

public void setPassenger(Passenger p){
    this.passenger=p;
}

public void setFlight(Flight f){
    this.flight=f;
}

public double getPrice(){
    return price;
}

public int getNumber(){
    return number;
}

public Passenger getPassenger(){
    return passenger;
}

public Flight getFlight(){
    return flight;
}

}
