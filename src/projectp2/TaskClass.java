
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectp2;

import javax.swing.JOptionPane;
import static projectp2.ProjectP2.kanBan;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class TaskClass {
    //Member Variables
    private String tName, tDes,devDetails,tID,tStatus;
    private int tNum ,duration;
    private int totDur = 0;
    
    public TaskClass(){}
    //Test Task Description length
    public boolean checkTaskDescription(String des)
    {
        return (des.length() > 50);
    }
    //Create the Task ID 
    public String createTaskID(String tName, int tNum)
    {
        //Generates the Task Id 
        return  tName.substring(0, 2)+";"+tNum+";"+(tName.substring(tName.length()-3, tName.length())).toUpperCase();
    }
    //Display Data to User in Joption Panes 
    public void printTaskDetails(EasyKanBan kanBan)
    {
        //Outputs Data in JoptionPane
        JOptionPane.showMessageDialog(null, tStatus,"Status",1);
        JOptionPane.showMessageDialog(null, devDetails,"Developer Details",1);
        JOptionPane.showMessageDialog(null, tNum,"Task Number",1);
        JOptionPane.showMessageDialog(null, tName,"Task Name",1);
        JOptionPane.showMessageDialog(null, tDes,"Task Description",1);
        JOptionPane.showMessageDialog(null, tID,"Task ID",1);
        JOptionPane.showMessageDialog(null, duration+" Hours","Duration",1);    
        
        //Send Data to EasyKanBan seTable
        kanBan.setTable(tName, tDes, devDetails, tID, tStatus, tNum, duration);
    }
    //Calc the total Hours 
    public void calcTotalHours()
    {
        totDur = totDur + duration;
    }
    //Return the Total Hours
    public int returnTotalHours()
    {
       return (totDur);
        
    }
    
    //Setters
    public void settName(){
        tName = JOptionPane.showInputDialog("Task Name");
    }
    public void setDevDetails(){
        devDetails = JOptionPane.showInputDialog("First and Last Name of Dev");
    }
    public void settDes(){
        tDes = addNewDescription();
        
    }
    public void  settID(){
        tID  = createTaskID(tName, tNum);
    }
    public void  setStatus(int i,String[] status){
        tStatus = status[i];
    }
    public void setDur(){
        duration = Integer.parseInt(JOptionPane.showInputDialog("How will it take in hours?"));
    }
    public void settNum(int tNum) {
        this.tNum = tNum;
    }
    //Getters
    public String gettName() {
        return tName;
    }
    public String getDevDetails() {
        return devDetails;
    }
    public int getDur() {
        return duration;
    }
    
    
    
    
    //Gets and tests that the Description is less than 50 Characters
    private String addNewDescription()
    {
        ProjectP2 obj = new ProjectP2();
        //Declare Variables
        String des;
        //Input
        des = JOptionPane.showInputDialog("Description Under 51 Characters");
        if (checkTaskDescription(des))
        {
            do {            
                des = JOptionPane.showInputDialog("Please enter a task descrpitin of less than 50 characters");
            } while (des.length() > 50);
        }
        else 
            obj.output("Task Successfully Captured");
        return des;
    }

}