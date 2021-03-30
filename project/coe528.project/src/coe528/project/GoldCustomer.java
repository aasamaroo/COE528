
package coe528.project;

public class GoldCustomer extends Customer {
    
    private String username;
        
    private String password;
    
    private int balance;
    
    /**
     * OVERVIEW: creates Gold customer
     * REQUIRES:  username, password, and balance not be null
     * EFFECTS: sets username, password, and balance of customer
    */
    public GoldCustomer(String username, String password, int balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
        
        /**
         * OVERVIEW: same as above
         * REQUIRES: username, password, and balance are not null
         * EFFECTS: sets username, password, and balance
        */
    }

    @Override
    public boolean login(String username, String password) {
        /**
         * REQUIRES: username and password cannot be null
         * EFFECTS: if username and password match, returns true
        */
        return(this.username.equals(username)&&this.password.equals(password));
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public boolean deposit(int amount) {
        
       /**
        * MODIFIES: balance of customer
        * EFFECTS: adds the amount to balance and returns true
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
         * MODIFIES: balance of customer when a purchase of over $50 is made
         * EFFECTS: subtracts price of purchase plus a $10 Gold member fee from customer's balance
        */
        
        if (price >=50 && (price +10) <= balance){
            balance = balance - price -10;
            return true;
        }
        return false;          
    }
    
    public boolean repOk(){
        /**
        *REQUIRES: username and password to be null 
        *EFFECTS: returns false if balance > 10000
        */
        if(username.equals("")||password.equals("")||balance< 10000 || balance>= 20000){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        /**
         * REQUIRES: the customer to be Gold client
         * EFFECTS: returns the string rep of a Gold object        
        */
        return "Username: " + username + "\nPassword: "+ password + "\nBalance: "+ balance + "Level: Gold";
    }
}
