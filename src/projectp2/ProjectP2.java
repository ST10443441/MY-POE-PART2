/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectp2;


import javax.swing.JOptionPane;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP2 {

    
    
    
    public ProjectP2(){   }
    //Adding Variables to global 
    
    static BaseForm form = new BaseForm();
    static EasyKanBan kanBan = new EasyKanBan();
    static TaskClass taskClass = new TaskClass();

    
    public static void main(String[] args) 
    {
        form.setVisible(true);
        
    }
    
    //Out put the message to the User and developer
    public void output(String out)
    {
        form.setOutput(out);
        kanBan.setOutput(out);
        System.out.println(out);
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
        String[] status = {"To Do","Done","Doing"};
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
            
            taskClass.setStatus(choice);
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
    
    
 
}

//OpenAI. (2024). ChatGPT (Jun 21 version) [GPT-3.5 model]. https://chat.openai.com/ 
 
//Oracle Help Center. 1995. Java Tutorials writen of JDK 8,
// 21 July 2022. [Online]. Available at: https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html [Accessed 1 April 2024].

//W3Schools. 1998. To Create simplified and interavtive learning experiences,
// 17 November 2015. [Online]. Available at: https://www.w3schools.com/java/java_while_loop.asp [Accessed 31 March 2024].

//Serplat. 2010. How to add row in JTable? (Version 1.0) [Source code].
//https://stackoverflow.com/questions/3549206/how-to-add-row-in-jtable (Accessed 03 May 2024).
