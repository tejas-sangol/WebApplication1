<%-- 
    Document   : validlogin
    Created on : 23 Apr, 2017, 8:30:07 PM
    Author     : ishitamalviya
--%>

<%@page import="ExamplePackage.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%  System.out.println(session.getAttribute("currentUser")); %></h1>
    </body>
</html>
