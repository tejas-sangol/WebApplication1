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
                
                System.out.println("Your user name is " + username); 
                System.out.println("Your password is " + password); 
                System.out.println("Query: "+searchQuery);
                 try 
                 { 
                            //connect to DB 
//                     DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//                     currentCon = DriverManager.getConnection("jdbc:oracle:thin:C##DBUSER002_01/DBUSER002_001@141.145.121.186:1521:orcl"); 
                        Class.forName("com.mysql.jdbc.Driver"); 
                        
                        DriverManager.registerDriver(new Driver());
                        currentCon=DriverManager.getConnection(  
                        "jdbc:mysql://localhost:3306/pfour","root","root");  
                     stmt=currentCon.createStatement(); 
                     rs = stmt.executeQuery(searchQuery); 
                     boolean more = rs.next(); 
                    // if user does not exist set the isValid variable to false 
                    if (!more) 
                    { 
                        System.out.println("Sorry, you are not a registered user! Please sign up first");
                        bean.setValid(false);
                    } 
                     //if user exists set the isValid variable to true 
                    else if (more)
                    { 
                        String Username = rs.getString("Username");
                         
                         System.out.println("Welcome " + Username);
                         
                        bean.setValid(true); 
                    } 
                 }
                 catch (Exception ex)
                 { 
                     ex.printStackTrace();
                 
                 }
                 finally
                 { 
                     if (rs != null) 
                     { 
                         try 
                         { 
                             rs.close(); 
                         } 
                         catch (Exception e) {} 
                         rs = null; 
                     } 
                     if (stmt != null) 
                     { 
                         try 
                         { 
                             stmt.close(); 
                         } 
                         catch (Exception e) {} 
                         stmt = null; 
                     } 
                     if (currentCon != null) 
                     { 
                         try 
                         { 
                             currentCon.close();
                         } 
                         catch (Exception e) { } 
                         currentCon = null; 
                     } 
                 }
                 
                 return bean; 
     }
}
    

