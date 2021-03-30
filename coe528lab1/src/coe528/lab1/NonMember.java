
package coe528.lab1;


public class NonMember extends Passenger {

    public NonMember(String name, int age) {
        super(name, age);
    }
    
    


    
    
    @Override
    public double applyDiscount(double p){
        if(age>65){
            return 0.9;  //10% discount = 90% of original price or 0.9 * original price
        }
        else return 1; //no discount = 100% of original price or 1*original price
    }
    
}
