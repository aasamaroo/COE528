
package coe528.project;



public abstract class Customer {
    
    abstract public boolean login(String username, String password);
    
    abstract public boolean logout();
    
    abstract public boolean deposit(int amount);
    
    abstract public boolean withdraw(int amount);
    
    abstract public String getUsername();
    
    abstract public String getPassword();
    
    abstract public int getBalance();
    
    abstract public boolean purchase(int price);
   
    
}
    

