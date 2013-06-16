/*
 User class
 * 
 */
package logon;

/**
*  A User will have three data members, all type String. The real name and logon name are
* both final variables. The password can be changed.
* Provide a constructor with three parameters that initializes all three data members.
* Implement get functions for all three. (accessors)
* Implement a set function for the password. (mutator)
* Implement a toString() function that will print the real name and logon name. P4 should
* display the password also, but this will be dropped from P5. Put each user on a single line
* of the output. The format should be readable but does not need to line up in neat columns.
 */
public class User 
{
    
       private String realName;
       private String idName;
       private String password;
        
 public User(String _realName,String _idName,String _password) //constructor
    {   
     
     
    this.realName = _realName;
    
    this.idName = _idName;
     
    this.password = _password;
     
    }
   
    public String getrealName()
   {
     return realName;
   }
    
     public void setrealName(String _realName)
   {
        realName = _realName;
   }
 
   //Accessor for idName
   public String getidName()
   {
     return idName;
   }
   
    public void setidName(String _idName)
   {
        idName = _idName;
   }
 
   //Accessor and mutator for password
   public String getpassword()
   {
     return password;
   }
   public void setpassword(String _password)
   {
        password = _password;
   }
   
    @Override
   public String toString()
   {
       return "[" + " Password is: " + password + " User ID is: " + idName + " Name is: " + realName + "]";
   }
           
} 


