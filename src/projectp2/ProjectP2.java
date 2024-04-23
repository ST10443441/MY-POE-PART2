/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectp2;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
public class ProjectP2 {

    String getMessage;

    
    public ProjectP2()
    {

    }
    //Adding Variables to global 
    public String userName, password, nameFirst, nameLast;
    
    public String message;
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
    public boolean registerUser()
    {
        //create varibles to help chack if Username and Password are valid
        boolean userVal = false, passVal = false;
        
        do
        {
        //Check Username
            //Input
            userName = setUsername();
            
            //Ensure no null values
            if (userName == null)
                userName = "Invalid";
            
            //Print out for Username Check
            if (checkUserName(userName))
            {
                System.out.println(userName);                                 //Show Username for Dev
    //            System.out.println("Username Successfully Captured");
                output("Username Successfully Captured"); 
                userVal = true;
            }
            else 
            {
    //            System.out.println("Username is not correctly formatted, "
    //                    + "\nPlease ensure that your username contains \nan underscore"
    //                    + " and \nis no more than 5 characters in length");
                output("Username is not correctly formatted, "       
                        + "\nPlease ensure that your username contains \nan underscore"
                        + " and \nis no more than 5 characters in length");
            }
        }while(!userVal);
        
        
        do
        {
            //Check Password
            //Input
            password = setPassword();
            
            //Ensure no null values
            if (password == null)
                password = "Invalid";
            
            if (checkPasswordComplexity(password))
            {                
                System.out.println(password);                                 //Show Password for Dev
    //            System.out.println("Password Successfully captured");
                output("Password Successfully captured");
                passVal = true;
            }
            else         
            {
    //            System.out.println("\nPassword is not correct "
    //                    + "please ensure that your Password contains atleast: \n8 Characters"
    //                    + ", \na capital letter, \na number and \na special character");
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
//            System.out.println("Successfully Registered");
            output("Successfully Registered");
            //Return True if Username and Password are valid
            return true;
        }
        else 
            //Return False if Username and Password are valid
            return false;
    }
    
    public void output(String out)
    {
        BaseForm obj = new BaseForm();
        obj.setOutput(out);
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public String returnLoginStatus(boolean lC)
    {
        if (lC)
            return "A Successful Login";
        else
            return "A Failed Login";
        
    }
    
    public String setUsername() 
    {
        return JOptionPane.showInputDialog("Please Enter Username To Register");
    }

    public String setPassword() 
    {
        return JOptionPane.showInputDialog("Enter Password For Registation");
    }
    
    public boolean checkUserName(String s)
    {    
        //Check is Username is 5 or less characters long 
        //Check if Username contains "_"
        return (s.length() < 6) && (s.contains("_"));
    }
    
    public boolean checkPasswordComplexity(String p)
    {
        //Declare varibles to check Password Complexity
        boolean len, cap = false, num = false, spec = false;
        //Set Constant to help check for special characters in Password
        final String specialCharacters = "!@#$%^&*()-_+=~`[]{}|;:,.<>?";    //Suggested by OpenAI 2024

        //Check Password is Atleast 8 Characters long 
        len = p.length() >= 8;                                       //(OpenAI 2024)
//        System.out.println("Password Length: "+ password.length());       //Show Dev Password Length

        //Check Password Contains Capital Letter
        for (int i = 0; i < p.length(); i++) 
        {
            if (Character.isUpperCase(p.charAt(i)))
            {
                //If password has Capital Letter set cap to True and end FOR Loop
                cap = true;
//                System.out.println("Has Upper Case");                     //Show Dev Password has a Capital
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
//                System.out.println("Has Number");                         //Show Dev Password has a Number
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
//                System.out.println("Has Special Character");              //Show Dev Password has a Special Character
                i = p.length();                                      //End FOR Loop
            }   
        }
        //Return True or False if password is Complex enough
        return (len) && (cap) && (num) && (spec);
    }
    
    public boolean loginUser()
    {
        String /**userFirst ,userLast,*/ userLogin, userPass;
        boolean loginCheck = false;
        int i = 0;
        
        do
        {
            //Input
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
    //            System.out.println("Welcome "+nameFirst+", "+nameLast+" it is great to see you");
                
                output("Welcome "+nameFirst+", "+nameLast    
                        + " it is great to see you");        
                loginCheck = true;
            }
            else 
            {
    //            System.out.println("Usernsme or password incorrect please try again");
                output("Usernsme or password incorrect please try again");
                i++;
            }
        }while ((!loginCheck)&&(i != 3));                                   //(W3Schools,2015)
        
//        System.out.println(returnLoginStatus(loginCheck));
        output(returnLoginStatus(loginCheck));
        return loginCheck;
    }
    
    
}

//OpenAI. (2024). ChatGPT (Jun 21 version) [GPT-3.5 model]. https://chat.openai.com/ 
 
//Oracle Help Center. 1995. Java Tutorials writen of JDK 8,
// 21 July 2022. [Online]. Available at: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html [Accessed 1 April 2024].

//W3Schools. 1998. To Create simplified and interavtive learning experiences,
// 17 November 2015. [Online]. Available at: https://www.w3schools.com/java/java_while_loop.asp [Accessed 31 March 2024].
