
package coe528.lab2;

public class Palindrome {
    //Requires: args.length != null
    //Modifies: args.length 
    //Effects: counts length of command line args[0], and checks for palindrome of corresponding word
    public static boolean isPalindrome(String a) {
        
        //pointers for beginning and end of string
        int i = 0; 
        int j = a.length() -1;
        
        
        //while there are characters to compare
        while (i < j){  
            
            //if there happens to be a mismatch resulting in not a palindrome
            if(a.charAt(i) != a.charAt(j))
                return false;
            
            //increment first pointer while decrementing second pointer
            i++;
            j--;
        }
        
        //string is a palindrome
        return true;
    }
    
    public static void main(String[] args){
        
//check isPalindrome() method without using command line arguments        
if(args.length == 0){
    System.out.println(isPalindrome("tacocat")); //should return true because tacocat is my favourite palindrome
}        
        
 //copied code for main method
 if(args.length == 1) {
    if (args[0].equals("1"))
        System.out.println(isPalindrome(null));
    else if (args[0].equals("2")) 
         System.out.println(isPalindrome("")); 
    else if (args[0].equals("3"))
        System.out.println(isPalindrome("deed"));
    else if (args[0].equals("4")) 
        System.out.println(isPalindrome("abcd"));
        }
    }       
}
