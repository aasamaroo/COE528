
package coe528.lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.*;

public class Record {
    //Name of the associated file
    private  String filename;
    private static Record instance;
    private Record(String n){
        filename = n;
    }
 public void setFileName(String n){
     filename = n;
 }   

public String getFileName(){
    return filename;
} 

public static Record getInstance(){
    if(instance == null)
        instance = new Record("record.txt");
    return instance;
}

//Effects: Reads and prints the contents of the associated
//file to the standard output
public void read()  { 
    try{
        //write code here
try(BufferedReader br = new BufferedReader(new FileReader("record.txt"))){
    String str;
    while((str = br.readLine()) != null){
        out.println(str + "\n");
    } 
    br.close();
}
        
    } catch (IOException e) {
        System.out.println("An Error Occured.");
        e.printStackTrace();
    }
}    
    
//Effects: Appends the specified message, msg, to the 
//associated file.
public void write(String msg)  {
    try {
        //write code here
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("record.txt", true))){
        bw.write(msg);
        bw.newLine();
        bw.close();
    }
          
    } catch (IOException e) {
        System.out.println("An Error Occurred");
        e.printStackTrace();
    }
}


public static void main(String[] args) {
    //Fill in the blank below that obtains the sole instance
    //of the record class
    //DO NOT ATTEMPT TO INVOKE THE RECORD CONSTRUCTOR
    Record r = Record.getInstance();
    
    
//Do not modify the code below    
r.write("Hello-1\n");
r.write("Hello-2\n");

    System.out.println("Currently the file record.txt contains the following lines:");
    r.read();
    
    
 
    
}
    
}
