/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectp2;


import Test.*;
import static Assert.*;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP2Test {
    
    public ProjectP2Test() {    }

    
     boolean run = false;
    //Test Username
     @Test
    public void testUsername() 
    {   
        //Arrange 
        String expected = "kyl_1";
        //Act 
        ProjectP2 p = new ProjectP2();
        p.setUsername("kyl_1");
        String actual = p.getUsername();
        //Assert
        assertEquals(expected, actual);
    }
    //Test Password
     @Test
    public void testPassword()
    {
        //Arrange 
        String expected = "Ch&&sec@ke99!";
        //Act 
        ProjectP2 p = new ProjectP2();
        p.setPassword("Ch&&sec@ke99!");
        String actual = p.getPassword();
        //Assert
        assertEquals(expected, actual);   
        
        run = true;
    }
    //Test Username Requirments
     @Test
    public void testUsernameRequirements()
    {
        //Act
        ProjectP2 p = new ProjectP2();
        boolean check = p.checkUserName("kyl_1");
        //Assert
        assertTrue(check);
    }
    //Test Password Complexity
     @Test
    public void testPasswordComplexity()
    {
        //Act
        ProjectP2 p = new ProjectP2();
        boolean check = p.checkPasswordComplexity("Ch&&sec@ke99!");
        //Assert
        assertTrue(check);
    }
    //Test Login
    @Test
    public void testzLogin()
    {
        //Arrange 
        if (run){
        //Act 
        ProjectP2 p = new ProjectP2();
        boolean l = p.loginUser();
        //Assert
        assertTrue(l);  }  
    }

    //Task One
    //Test Task Name
    @Test
    public void testTaskOneTName()
    {
     //Arrange 
        String exTaskName = "Login Feature";
        //Act 
        TaskClass p = new TaskClass();
        p.settName("Login Feature");
        String acTaskName = p.gettName();
        //Assert
        assertEquals(exTaskName, acTaskName);    
    }
    //Test Task Description
    @Test
    public void testTaskOneTDes()
    {
     //Arrange 
        TaskClass taskClass =new TaskClass();
        String expected = "Create Login to authenticate users";

        //Assert
        assertTrue(taskClass.checkTaskDescription(expected));    
    }
    //Test Task Developer Details
    @Test
    public void testTaskOneDevDetails()
    {
     //Arrange 
        String expected = "Robyn Harrison";
        //Act 
        TaskClass p = new TaskClass();
        p.setDevDetails("Robyn Harrison");
        String actual = p.getDevDetails();
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Duration
    @Test
    public void testTaskOneDur()
    {
     //Arrange 
        String expected = "8hrs";
        //Act 
        TaskClass p = new TaskClass();
        p.setDur(8);
        
        String actual = String.valueOf(p.getDur())+"hrs";
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Status
    @Test
    public void testTaskOneStatus()
    {
     //Arrange 
        String expected = "To Do";
        
        //Act 
        ProjectP2 p = new ProjectP2();
        
        String actual = p.getStatus(0);
        //Assert
        assertEquals(expected, actual);    
    }
    
    //Task Two
    //Test Task Name
    @Test
    public void testTaskTwoTName()
    {
     //Arrange 
        String exTaskName = "Add Task Feature";
        //Act 
        TaskClass p = new TaskClass();
        p.settName("Add Task Feature");
        String acTaskName = p.gettName();
        //Assert
        assertEquals(exTaskName, acTaskName);    
    }
    //Test Task Description
    @Test
    public void testTaskTwoTDes()
    {
     //Arrange 
        TaskClass taskClass =new TaskClass();
        String expected = "Create Add Task feature to add task users";

        //Assert
        assertTrue(taskClass.checkTaskDescription(expected));    
    }
    //Test Task Developer Details
    @Test
    public void testTaskTwoDevDetails()
    {
     //Arrange 
        String expected = "Mike Smith";
        //Act 
        TaskClass p = new TaskClass();
        p.setDevDetails("Mike Smith");
        String actual = p.getDevDetails();
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Duration
    @Test
    public void testTaskTwoDur()
    {
     //Arrange 
        String expected = "10hrs";
        //Act 
        TaskClass p = new TaskClass();
        p.setDur(10);
        String actual = String.valueOf(p.getDur())+"hrs";
        //Assert
        assertEquals(expected, actual);    
    }
    //Test Task Status
    @Test
    public void testTaskTwoStatus()
    {
     //Arrange 
        String expected = "Doing";
        //Act 
        ProjectP2 p = new ProjectP2();
        String actual = p.getStatus(2);
        //Assert
        assertEquals(expected, actual);    
    }
}
