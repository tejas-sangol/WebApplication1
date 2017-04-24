<%-- 
    Document   : validlogin
    Created on : 23 Apr, 2017, 8:30:07 PM
    Author     : ishitamalviya
--%>

<%@page import="ExamplePackage.UserBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

         <center>
            <% // UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
			
            Welcome <%= session.getAttribute("user") %>
         </center>

      </body>
	
   </html>