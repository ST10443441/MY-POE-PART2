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
    
    String des;
    int totDur = 0;
    public TaskClass()
    {
        
    }
    public boolean checkTaskDescription(String des)
    {
        
        return (des.length() > 50);
    }
    
    public String createTaskID(String tName, int tNum)
    {
        //Generates the Task Id 
        return  tName.substring(0, 2)+";"+tNum+";"+(tName.substring(tName.length()-3, tName.length())).toUpperCase();
    }
    
    public void printTaskDetails(EasyKanBan kanBan, String tName, String tDes, String devDetails, String tID, String tStatus, int tNum, int duration)
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
    
    public void setTotalHours(int dur)
    {
        totDur = totDur + dur;
    }
    
    public int returnTotalHours()
    {
       return (totDur);
        
    }
}
