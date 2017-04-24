/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamplePackage;

import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

/**
 *
 * @author ishitamalviya
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet 
{ 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    { 
        try
     { 
        UserBean user = new UserBean();
        user.setUsername(request.getParameter("un")); 
        user.setPassword(request.getParameter("pw"));
        user = UserDAO.login(user);
        if (user.isValid())
            { 
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user.getUsername());
                response.sendRedirect("/WebApplication1/login_success.jsp"); 
            }
//logged-in page } 
        else 
            response.sendRedirect("/WebApplication1/invalid_login.jsp"); //error page
     }
        catch (Exception e) 
    { 
         e.printStackTrace();
    } 
    } 
}