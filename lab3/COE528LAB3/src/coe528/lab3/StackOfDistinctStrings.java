
package coe528.lab3;

import java.util.ArrayList; 
public class StackOfDistinctStrings {
//Overview: StacksOfDistinctStrings are mutable, bounded   
//collection of distinct strings that operate in
//LIFO (Last-In-First-Out)
//
//The abstraction function is:    
//    a) Write the abstraction function here
//    AF(c) = a stack of distinct strings p such that
//p = c.items;    
// p.top = c.items(items.size()-1);
//The rep invariant is:    
//b) Write the rep invariant here    
//    RI(c) = 3 conditions
//    c.items != null &&
//all elements of c.items are Strings
//there are no duplicates in c.items    
    
//the rep    
    
private ArrayList<String> items;
//constructor
public StackOfDistinctStrings() {
    
//EFFECTS: Creates a new StackOfDistinctStrings object
    
items = new ArrayList<String>();

}


public void push(String element) throws Exception {
//MODIFIES: this
//EFFECTS: Appends the element at the top of the stack
//           if the element is not in the stack
//           does nothing
if(element == null) throw new Exception();
if(false == items.contains(element))
    items.add(element);

}

public String pop() throws Exception {
//MODIFIES: this
//EFFECTS: Removes an element from the top of the stack
if(items.isEmpty()) throw new Exception();
return items.remove(items.size()-1);
}

public boolean repOK() {
//EFFECTS: Returns true if rep invariant holds for this
//       object; otherwise returns false

//c) Write code for repOK() here
if (items == null) return false;
for(int i = 0; i < items.size(); i++){
String x = items.get(i);    
if(!(x instanceof String)) return false;
for(int j = i+1; j<items.size(); j++){
    if(x.equals(items.get(j))) return false;
}
}
return true;
}

@Override
public String toString() {
//EFFECTS: Returns a string that contains the strings in the
//          stack and the top element. Implements the 
//       abstraction function
//d) Write the code for the toString() here
 String top = items.get(items.size()-1);
 String stackedStrings = null;
 for(int i = 0; i<items.size(); i++){
    stackedStrings = stackedStrings +  items.get(i);
}
    return ("The Strings are " + stackedStrings + " with the head of the stack being " + top);
}
}
