/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectp2;

import java.lang.reflect.Modifier;
import javax.swing.JOptionPane;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP2 {

    
    //For Adding Tasks
   
    
    int totDuration = 0;
    String[] status = {"To Do","Done","Doing"};
    
    public ProjectP2(){   }
    //Adding Variables to global 
    private String userName, password, nameFirst, nameLast;
    static BaseForm form = new BaseForm();
    static EasyKanBan kanBan = new EasyKanBan();
    static TaskClass taskClass = new TaskClass();

    
    public static void main(String[] args) 
    {
        form.setVisible(true);
        kanBan.setVisible(true);
    }
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
    //Out put the message to the User and developer
    public void output(String out)
    {
        form.setOutput(out);
        kanBan.setOutput(out);
        System.out.println(out);
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
    //Open input for user's Username to register
    public void setUsername(String b) 
    {
        userName = b; 
        JOptionPane.showInputDialog("Please Enter Username To Register");
    }
    public String getUsername() 
    {
        return userName;
    }
    
    
    //Open input for user's Password to register
    public void setPassword(String b) 
    {
        password = b;
    }
    public String getPassword() 
    {
        return password;
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
        System.out.println("Password Length: "+ password.length());     //Show Dev Password Length

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
    //Returns the Login Status
    public String returnLoginStatus(boolean lC)
    {
        if (lC)
            return form.getTextOut()+"\nA Successful Login";
        else
            return "A Failed Login";
        
    }
    //Changes Forms from login to KanBan Forms
    public void changeForms(int t)
    {
        //Changes forms from the base to the EasyKanBan Forms
        switch (t) {
            case 0:
                form.setVisible(false);
                kanBan.setVisible(true);
                break;
            case 1:
                form.setVisible(true);
                kanBan.setVisible(false);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    //ALlows Users to choose the action they want
    public int options()
    {
        //Gets the choice from user using JOptionPane
        int choice;
        String[] list = {"Add","Show Report","Quit"};
        choice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, list, list[0]);
        
        return choice;
    }
    //Acts on the User's Choice 
    public void OptionAct(int choice)
    {
        switch (choice) {
            case 0:
                //Inputs the Ammount of tasks User wants to add
                int t = Integer.parseInt(JOptionPane.showInputDialog("How many Tasks to Add?"));
                //Adds the Ammount of tasks user want to add
                addNew(t);
                break;
            case 1:
                //Displays Coming Soon message for User
                JOptionPane.showMessageDialog(null, "Coming Soon");
                break;
            case 2: 
                //Display end of action message to User
                JOptionPane.showMessageDialog(null, "Thank You Have A good Day");
                break;
            default:
                throw new AssertionError();
        }
    }
    //Adds Tasks based on user Input
    public void addNew(int t)
    {
        //Declare the Variables
        int last = kanBan.getLastID(),choice;
        //Adds an ammount of tasks based on User's choice 
        for (int i = 0; i < t; i++) 
        {
            String temp = JOptionPane.showInputDialog("Task Name");
            //Gets the Data from the User
            taskClass.settName(temp);
            temp = JOptionPane.showInputDialog("First and Last Name of Dev");
            taskClass.setDevDetails(temp);
            //MultiChoice for the Status of the Task being added
            choice = JOptionPane.showOptionDialog(null, "Choose an Option:", "Options", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, status, status[0]);
            
            taskClass.setStatus(choice,status);
            int tempInt = Integer.parseInt(JOptionPane.showInputDialog("How will it take in hours?"));
            taskClass.setDur(tempInt);
            taskClass.calcTotalHours();
            temp = JOptionPane.showInputDialog("Description Under 51 Characters");
            taskClass.settDes(temp);
            taskClass.settNum(i+ last);
            
            //Generates the Task Id 
            taskClass.settID();
            
            taskClass.printTaskDetails(kanBan);
        }
        JOptionPane.showMessageDialog(null, taskClass.returnTotalHours()+" Hours","Total Duration",1);
    }
    
    //Getters
    public String getStatus(int t) {
        return status[t];
    }
 
}

//OpenAI. (2024). ChatGPT (Jun 21 version) [GPT-3.5 model]. https://chat.openai.com/ 
 
//Oracle Help Center. 1995. Java Tutorials writen of JDK 8,
// 21 July 2022. [Online]. Available at: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html [Accessed 1 April 2024].

//W3Schools. 1998. To Create simplified and interavtive learning experiences,
// 17 November 2015. [Online]. Available at: https://www.w3schools.com/java/java_while_loop.asp [Accessed 31 March 2024].

//Serplat. 2010. How to add row in JTable? (Version 1.0) [Source code].
//https://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable (Accessed 03 May 2024).
