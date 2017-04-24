/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplePackage;
import java.text.*; 
import java.util.*; 
import java.sql.*;
import java.sql.DriverManager;
//import oracle.jdbc.driver.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author ishitamalviya
 */
public class UserDAO 
{
    static Connection currentCon = null; 
    static ResultSet rs = null; 
    
     public static UserBean login(UserBean bean) 
     { 
            //preparing some objects for connection 
         
                Statement stmt = null; 
                String username = bean.getUsername(); 
                String password = bean.getPassword(); 
                String searchQuery = "select * from user where username='" + username + "' AND password='" + password + "'";
                
               
                 try 
                 { 
                    Class.forName("com.mysql.jdbc.Driver"); 
                        
                        DriverManager.registerDriver(new Driver());
                        currentCon=DriverManager.getConnection(  
                        "jdbc:mysql://localhost:3306/pfour","root","root");  
                     stmt=currentCon.createStatement(); 
                     rs = stmt.executeQuery(searchQuery); 
                     boolean more = rs.next(); 
                     bean.setValid(more);
                 }
                 catch (Exception ex)
                 { 
                     ex.printStackTrace();
                 
                 }
                 finally
                 { 
                     try{
                         rs.close();
                         stmt.close();
                         
                         
                     }
                     catch(Exception e)
                     {
                         e.printStackTrace();
                     }
                     
                 }
                 
                 return bean; 
     }
}
    

