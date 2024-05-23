/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectp2;

import javax.swing.JOptionPane;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class Users 
{
    private String userName, password, nameFirst, nameLast;
    
    public Users(){}
    
    //Register a new user
    public boolean registerUser()
    {
        //create varibles to help chack if Username and Password are valid
        boolean userVal = false, passVal = false;
        
        //Input username for registration
        do
        {
        //Check Username
            //Input
            String temp = JOptionPane.showInputDialog("Please Enter Username To Register");
            setUsername(temp);
            
            //Ensure no null values
            if (userName == null)
                userName = "Invalid";
            
            //Print out for Username Check
            if (checkUserName(userName))
            {
                System.out.println(userName);       //Show Username for Dev
                output("Username Successfully Captured"); 
                userVal = true;
            }
            else //Username is incorrectly formatted
            {
                output("Username is not correctly formatted, "       
                        + "\nPlease ensure that your username contains \nan underscore"
                        + " and \nis no more than 5 characters in length");
            }
        }while(!userVal);
        
        //Input Password for registration
        do
        {
            //Check Password
            //Input
            String temp = JOptionPane.showInputDialog("Please Enter Username To Register");
            setPassword(temp);
            
            //Ensure no null values
            if (password == null)
                password = "Invalid";
            
            if (checkPasswordComplexity(password))
            {                
                System.out.println(password);       //Show Password for Dev
                output("Password Successfully captured");
                passVal = true;
            }
            else    //Password incorrectly formatted
            {
                output("Password is not correct "
                        + "please ensure that your Password contains atleast: \n8 Characters"
                        + ", \na capital letter, \na number and \na special character");
            }
        }while(!passVal);
        
        //Get First and Last Names
        nameFirst = JOptionPane.showInputDialog("Enter First Name\nCannt be Changed!!");
        nameLast = JOptionPane.showInputDialog("Enter Last Name\nCannt be Changed!!");
        
        if ((checkUserName(userName))&&checkPasswordComplexity(password))
        {
            output("Successfully Registered");
            //Return True if Username and Password are valid
            return true;
        }
        else 
            //Return False if Username and Password are valid
            return false;
    }
    //Check the Username is formatted correctly
    public boolean checkUserName(String s)
    {    
        //Check is Username is 5 or less characters long 
        //Check if Username contains "_"
        return (s.length() < 6) && (s.contains("_"));
    }
    //Check Password is complex enough 
    public boolean checkPasswordComplexity(String p)
    {
        //Declare varibles to check Password Complexity
        boolean len, cap = false, num = false, spec = false;
        //Set Constant to help check for special characters in Password
        final String specialCharacters = "!@#$%^&*()-_+=~`[]{}|;:,.<>?";    //Suggested by OpenAI 2024

        //Check Password is Atleast 8 Characters long 
        len = p.length() >= 8;                                       //(OpenAI 2024)
        System.out.println("Password Length: "+ p.length());     //Show Dev Password Length

        //Check Password Contains Capital Letter
        for (int i = 0; i < p.length(); i++) 
        {
            if (Character.isUpperCase(p.charAt(i)))
            {
                //If password has Capital Letter set cap to True and end FOR Loop
                cap = true;
                System.out.println("Password Has Upper Case");       //Show Dev Password has a Capital
                i = p.length();                                      //End FOR Loop
            }  
        }        
        //Check Password Contains a Number
        for (int i = 0; i < p.length(); i++) 
        {
            if (Character.isDigit(p.charAt(i)))
            {
                //If password has a Number set num to True and end FOR Loop
                num = true;
                System.out.println("Password Has Number");      //Show Dev Password has a Number
                i = p.length();                                      //End FOR Loop
            }  
        }
        //Check Password Contains Special Characters
        for (int i = 0; i < p.length(); i++) 
        {
            if (specialCharacters.contains(String.valueOf(p.charAt(i))))
            {
                //If password has a Special Charaacter set spec to True and end FOR Loop
                spec = true;
                System.out.println("Password Has Special Character");       //Show Dev Password has a Special Character
                i = p.length();                                      //End FOR Loop
            }   
        }
        //Return True or False if password is Complex enough
        return (len) && (cap) && (num) && (spec);
    }
    //Login existing user
    public boolean loginUser()
    {
        //Create local variables
        String userLogin, userPass;
        boolean loginCheck = false;
        int i = 0;
        
        do
        {
            //Input Username and Password
            userLogin = JOptionPane.showInputDialog("Please Enter Username to Login");
            userPass = JOptionPane.showInputDialog("Please Enter Password to Login");
            
            //Ensure no null values
            if (userLogin == null)
                userLogin = "Invalid";
            if (userPass == null)
                userPass = "Invalid";
            
        //Test if usernames and Passwords match
            if ((userLogin.equals(userName))&&(userPass.equals(password)))
            {
                output("Welcome "+nameFirst+", "+nameLast    
                        + " it is great to see you");        
                loginCheck = true;
            }
            else 
            {
                output("Usernsme or password incorrect please try again");
                i++;
            }
        }while ((!loginCheck)&&(i != 3));                                   //(W3Schools,2015)
        
        output(returnLoginStatus(loginCheck));
        return loginCheck;
    }
    
    public void output(String t){
        ProjectP2 p = new ProjectP2();
        p.output(t);
    }
    public String returnLoginStatus(boolean b){
        ProjectP2 p = new ProjectP2();
        return p.returnLoginStatus(b);
    }
    
    //Setters
    public void setUsername(String b){
        userName = b; 
        //JOptionPane.showInputDialog("Please Enter Username To Register");
    }
    public void setPassword(String b){
        password = b;
    }
    //Getters
    public String getUsername(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    
}
