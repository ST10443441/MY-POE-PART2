/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectp2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cameron Griffin ST10443441
 */
public class ProjectP2Test {
    
    public ProjectP2Test() {
    }

    
     boolean run = false;
    
     @Test
    public void testUsername() 
    {   
        //Arrange 
        String expected = "kyl_1";
        //Act 
        ProjectP2 p = new ProjectP2();
        String actual = p.setUsername();
        //Assert
        assertEquals(expected, actual);
    }
     @Test
    public void testPassword()
    {
        //Arrange 
        String expected = "Ch&&sec@ke99!";
        //Act 
        ProjectP2 p = new ProjectP2();
        String actual = p.setPassword();
        //Assert
        assertEquals(expected, actual);   
        
        run = true;
    }
     @Test
    public void testUsernameRequirements()
    {
        //Act
        ProjectP2 p = new ProjectP2();
        boolean check = p.checkUserName("kyl_1");
        //Assert
        assertTrue(check);
    }
     @Test
    public void testPasswordComplexity()
    {
        //Act
        ProjectP2 p = new ProjectP2();
        boolean check = p.checkPasswordComplexity("Ch&&sec@ke99!");
        //Assert
        assertTrue(check);
    }
    
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

    
    
}
