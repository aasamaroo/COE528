
package coe528.project;

public class SilverCustomer extends Customer {
    private String username;
    private String password;
    private int balance;
    
    /**
     * OVERVIEW: Create Silver Customer
     * REQUIRES: a username, password, and a balance
     * EFFECTS: sets the username password and balance to that of the customer
    */
    public SilverCustomer(String username, String password, int balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
        
        /**
         * OVERVIEW: same as above
         * REQUIRES: username, password, and balance not null
         * EFFECTS: sets username, password, and balance to specified input values
        */
    }

    @Override
    public boolean login(String user, String pass) {
        /**
         * REQUIRES: user and pass cannot be null
         * EFFECTS: returns true is user and pass inputs match username and password
         * otherwise returns false
        */
        return(username.equals(user)&&password.equals(pass));
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public boolean deposit(int amount) {
        /**
         * MODIFIES: balance of user
         * EFFECTS: adds the amount to balance
        */
        
        if(amount<0){
            return false;
        }else  balance = balance + amount;
        return true;
    }

    @Override
    public boolean withdraw(int amount) {
        /**
         * EFFECTS: subtracts amount from balance and returns true
        */
        if(amount > balance || amount < 0){
           
            return false;
        } else 
            balance = balance - amount;
        return true;
    }

    @Override
    public String getUsername() {
        /**
         * REQUIRES: a username input
         * EFFECTS: returns the username
        */
        return username;
    }

    @Override
    public String getPassword() {
        /**
         * REQUIRES: a password input
         * EFFECTS: returns the password
        */
        return password;
    }

    @Override
    public int getBalance() {
        /**
         * EFFECTS: returns the balance
        */
        return balance;
    }

    @Override
    public boolean purchase(int price) {
        
       /**
        * MODIFIES: balance of Customer
        * EFFECTS: subtracts price of purchase plus $20 Silver fee from balance
        */
       
        if (price >= 50 && (price+20) <= balance){
            balance = balance - price - 20;
            return true;
        }
        return false;          
    }
    
    
    
    
    /**
     * AF(c) = a Silver customer sc
     * sc.getUsername = username;
     * sc.getPassword = password;
     * sc.getBalance = balance;
     * 
     * 
     * RI(c) = true if username, password, and balance is not null.
     */
    public boolean repOk(){
        /**
         * REQUIRES: username and password to be null 
         * EFFECTS: returns false if bal > 10000
        */
        if(username.equals("")||password.equals("")||balance>= 10000){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        /**
         * REQUIRES: the customer to be a silver client
         * EFFECTS: returns the string rep of a silver object        
        */
        return "Username: " + username + "\nPassword: "+ password + "\nBalance: "+ balance + "Level: Silver";
    }
}
