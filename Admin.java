package logon;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;  
    
/**
ArrayList of Users, and variables to store the current user
(a reference to a User in the ArrayList), the UID of the current user (an int, the position
of the user in the User collection), a menu, a Scanner for the keyboard, a Scanner for the
user-file, and a PrintWriter for the user file.
 */

public class Admin {
    
private static String[] menu = {"1. New User","2. Log in",
"3. Change Password","4. Log off","5. List users","6. Quit"}; 

ArrayList<User> userList = new ArrayList();
String currentUser;
int UID;
Scanner sc = new Scanner(System.in);
PrintWriter pw = new PrintWriter(System.out); 


public Admin() throws FileNotFoundException, IOException
{
    doMenu();
    newUser();
    try{
        File userFile = new File("Users.txt");
        // Create a file of Users and prepare to read some values from it
        //Scanner reads then saves pointer to proper data members
        Scanner input = new Scanner(userFile);
        while (input.hasNext())
            {
        newUser();
        if(input.hasNext()) (userList.get(userList.size())).setrealName (input.next());
        if(input.hasNext()) (userList.get(userList.size())).setidName (input.next());
        if(input.hasNext()) (userList.get(userList.size())).setpassword (input.next());
             }
        input.close(); //close stream
        }
    catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException: File Users.txt does not exist " + e);
                                    }
    try{
        File userFile = new File("Users.txt");
        // open the input files as an output file
        PrintWriter output = new PrintWriter(userFile);
        //print the data from it
        output.print(userFile);
        output.close(); //close stream
        }
    catch(IOException io) {
    System.out.println("IOException: Problem reading file Users.txt. Throw to main " + io);
    throw io;
                          }
}
    //saves user information to "Users.txt" which will be called in the finally block after choice
    public void writeUsers()
    {
        try{
            FileWriter userFile = new FileWriter("Users.txt",true);
            BufferedWriter output = new BufferedWriter(userFile);
           // File userFile = new File("Users.txt");
           // PrintWriter output = new PrintWriter(userFile);
            for(User i: userList) {
            output.write("    ");
            output.append("Name:");    
            output.write(i.getrealName() + " ");
            output.append("UID:");
            output.write(i.getidName() + " ");
            output.append("Password:");
            output.write(i.getpassword() + " ");
            
            }
            output.flush();
            output.close();
            System.out.print("Information has been saved to Users.txt\n");
            
            
        }
        catch(FileNotFoundException fnf) {
            System.err.println("FileNotFoundException: File Users.txt does not exist " + fnf);
        }
        catch(IOException eyeoh) {
            System.err.println("IOException: Error writing to Users.txt " + eyeoh);
        }
        
    } 

 
public void doMenu() throws IOException 
{
/**
Break out of both the switch and the for(;;) statement if the user selects “Quit”. Leaving
the loop will end the try block, which will send control directly to the finally block
*/
    try {
        for(;;){
            System.out.println("LOGON MENU");
            System.out.println("-------------------------------------");
                 for(int i = 0; i < menu.length; i++) {
                    System.out.println(menu[i] +" ");
                 }
            System.out.println("Please select option 1,2,3,4,5 or 6 from the menu");
            int choice = sc.nextInt();
                if(choice < 1 || choice > 6) {
                     System.out.printf("Invalid Choice: %s\n", choice);
                     break;
            }
                
    
    switch(choice) {
        
        case 1:
        newUser();
	break;
            
        case 2: //not implemented for this project
	break;
            
        case 3: //not implemented for this project
	break;
            
	case 4: //not implemented for this project
	break;
            
        case 5:
        displayUsers();
        break;
            
        case 6: 
        break;
            
                    }
    if(choice == 6) { //quits the loop
        break;
    }
    
               }
            }
    finally { //users written to "Users.txt" via the  writeUsers()
         writeUsers(); //calls the function that writes the information to a .txt
         System.exit(0); //aborts program
                    }
   
    }
   
   

     /**getPassword() prompts the user to enter a password twice and compares the two Strings.
    When an equal pair is entered, it returns the validated password */
    private String getPassword()
    {
        System.out.println("Please enter your password. Password must be one string of characters:");
        String password = sc.next();
        System.out.println("Please re-enter password:");
        String password1 = sc.next();
            if(password.equals(password1)) {
                return password;
            }
                else {
                     System.out.println("INVALID PASSWORD!");
                     }
        return "";
    }
  
    /**newUser(): Create a new user (about 20 lines of code, including whitespace and comments).
    Prompt for and read the user’s full name (assume that it contains space characters) and the
    logon name (no whitespace). Call the getPassword() function to get a password. Make a
    new User and put it into the ArrayList of Users.*/
    public void newUser() 
    {
        System.out.println("Please input your full name:");
        sc.nextLine();
        String realName = sc.nextLine();
        System.out.println("Plese input a user id. UID must be one string of characters:");
        String idName = sc.next();
        String password = getPassword();
        User newUser = new User(realName, idName, password);
        userList.add(newUser);
    }
    
    /**displayUsers(): Use a for-each loop to display the Users in the users-collection. Let the
    toString() function in the User class format the user data.
    No function is needed for the “Quit” menu item. Just break out of the loop. */

    public void displayUsers()
    {
        
        for(Object i: userList) {
            String toString = i.toString();
            System.out.println(toString);
        }
      
    }
    
 }

