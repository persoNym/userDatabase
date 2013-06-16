/**
@file                LogOn.java
@description        log on simulator part 1
@author              Victoria C
@version             2.0
@revised             2/7/13

 */
package logon;

import java.io.*;
import java.util.Scanner.*;
import java.util.Date.*;
     
public class LogOn {
    
 /**
 * Print an identifying line (program name and your name), 
 * instantiate an Admin object and call its doMenu() function. 
 * Surround the code with a try block and catch IOExceptions. 
 * When caught, print a comment, a stack trace, and abort.
 */
    public static void main(String[] args){
       System.out.println("LogOn.java program by Victoria");
       java.util.Date date = new java.util.Date();
       System.out.println("Last revised:" + date.toGMTString());
       try{
       Admin AdminInstance = new Admin();
            AdminInstance.doMenu();
           } 
      catch (IOException io) { 
        System.out.println("General I/O exception: " + io.getMessage() );
        io.printStackTrace();
        System.exit(-1);
      }
      
    }
}
   

