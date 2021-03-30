
package coe528.project;


public class PlatinumCustomer extends Customer {
    private String username;
    private String password;
    private int balance;
    
    /**
     * OVERVIEW: creates Platinum customer
     * REQUIRES: a username, password, and a balance
     * EFFECTS: sets the username password and balance to that of the customer
    */
    public PlatinumCustomer(String username, String password, int balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
        
        /**
        *OVERVIEW: same as above
        * REQUIRES: Username, Password and Balance are not NULL
        *EFFECTS: sets u pw and bal to the variables username password and bal 
        */
    }

    @Override
    public boolean login(String user, String pass) {
        /**
         * REQUIRES: user and pass cannot be NULL
         * EFFECTS: user and pass must match username and password to evaluate to true
         * otherwise evaluate as false
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
         * MODIFIES: balance of user
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
         * EFFECTS: returns the username
        */
        return username;
    }

    @Override
    public String getPassword() {
        /**
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
        * MODIFIES: balance of customer
        * EFFECTS: subtracts price of purchase from balance, no purchase fee for Platinum customers
        */
        if (price >=50 && price <= balance){
            balance = balance - price;
            return true;
        }
        return false;          
    }
    
    public boolean repOk(){
        /**
         * REQUIRES: username and password to be null 
         * EFFECTS: returns false if bal > 10000
        */
        if(username.equals("")||password.equals("")||balance< 20000){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        /**
         * REQUIRES: the customer to be a Platinum client
         * EFFECTS: returns the string rep of a silver object        
        */
        return "Username: " + username + "\nPassword: "+ password + "\nBalance: "+ balance + "Level: Platinum";
    }
}
