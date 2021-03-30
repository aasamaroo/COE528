
package coe528.project;

import java.io.*;

public class Manager {
    
    private String username;
    private String password;
    private String dir = "customerFile";
    private int bal;
    private Customer current;
    
    //managers can add or delete a customer

    public boolean verify(String u, String pw) { //this makes it able to have customers log in 
        boolean verification;
        verification = false; //verification needs to be false until proven the file exists
        try{
            FileReader readFile = new FileReader(dir + u + ".txt");
            BufferedReader buffer1 = new BufferedReader(readFile);
            
            String line = buffer1.readLine();
            String info[] = line.split(", ");
            
            username = info[0];
            password = info[1];
            bal = Integer.parseInt(info[2]);
            
            Customer c1;
            if(bal < 10000){ //silver class verification
                c1 = new SilverCustomer(username, password, bal);
                if (c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else if(bal >= 10000 && bal < 20000){ //Gold class verification
                c1 = new GoldCustomer(username, password, bal);
                if(c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else if(bal > 20000){ //Platinum class verification
                c1 = new PlatinumCustomer(username, password, bal);
                if(c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else {
                System.out.println("No money");
            }
             
        } catch (Exception e){
            System.out.println("User doesn't exist");
        } return verification;
      
    }
    
    //method to add a customer
   // also creates a file for that customer
    public void addCustomer(String user, String pass) {
        String newDirectory = dir + user +  ".txt";
        File customerFile = new File(newDirectory);
        try {
            FileWriter writeToFile = new FileWriter(customerFile);
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(user + ", " + pass + ", " + 100);
        
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error creating new user file.");
        }
    }
    
    public void deleteCustomer(String user, String pass){
        File dFile = new File(dir + user + ".txt");
        try{
            if(dFile.delete()){
              System.out.println("deleted user");  
            } else{
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Error");
        }
    }
    
    public String level(){
        if(current instanceof SilverCustomer){
            return "Silver";
        } else if (current instanceof GoldCustomer){
            return "Gold";
        }
           else {
            return "Platinum";
        }
    }
    
    public boolean logout(){
        return current.logout();
    }
    
    
    //writes to the customer's file whenever there's an update to the balance
    //checks the level every time balance is updated
    public void updateCustomer(){
        try{
            FileWriter writeToFile = new FileWriter(dir + current.getUsername() +  ".txt");
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(current.getUsername() + ", " + current.getPassword() + ", " + current.getBalance());
        
            writer.close();
        }
        catch(Exception e){
            System.out.println("Cant update");
        }
        //this class is mostly the same as verify method just because it connects with the current account
        if(current.getBalance() < 10000){
            current = new SilverCustomer(current.getUsername(),current.getPassword(), current.getBalance());        
        }else if(current.getBalance() >= 10000 && current.getBalance() < 20000){
            current = new GoldCustomer(current.getUsername(),current.getPassword(), current.getBalance());
        }else if(current.getBalance() > 20000){
            current = new PlatinumCustomer(current.getUsername(),current.getPassword(), current.getBalance());
        }else
            System.out.println("No money");  
    }
    
    public boolean deposit(int amount){
        if(current.deposit(amount)){
        updateCustomer();          
        return true;
    }else{
            return false;
        }
        }
    
    public boolean withdraw(int amount){
        if(current.withdraw(amount)){
            updateCustomer();
            return true;
        }else{
            return false;
        }
    }
    
    public Customer getCurrent(){
        return current;
    }
    
    public int getBalance(){
        return current.getBalance();
    }
    
    public String getCustomerUserName(){
        return current.getUsername();
    }
    
    public boolean purchase(int price){
        if(current.purchase(price)){
            updateCustomer();
            return true;
        }else{
            return false;
        }
    }
}







