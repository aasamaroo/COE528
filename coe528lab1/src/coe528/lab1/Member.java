
package coe528.lab1;

public class Member extends Passenger {
   
    
    private final int yearsOfMembership;

    public Member(String name, int age, int years) {
        super(name, age);
        this.yearsOfMembership=years;
    }
    
    
   
    
    
    
    
    @Override
    public double applyDiscount(double p){
        if (yearsOfMembership>5){
            return 0.5; //50% discount = 0.5 * original price
        }
        if (yearsOfMembership<=5 || yearsOfMembership>1){
            return 0.9; //10% discount = 0.9 * original price
        }
        else return 1;
    }
    
}
