
package coe528.lab1;


public abstract class Passenger {
    
    protected String name;

    
    protected int age;
    
    public Passenger(String name, int age){
    this.name=name;
    this.age=age;
}
    public void setName(String name){
        this.name=name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public abstract double applyDiscount(double p);
    
}
