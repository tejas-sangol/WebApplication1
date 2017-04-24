<%-- 
    Document   : loginpage
    Created on : 23 Apr, 2017, 6:20:47 PM
    Author     : ishitamalviya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="LoginServlet">
            <label for="username"> Enter username: </label>
            <input type="text" id = "username" name="un" /><br>
            <label for="password"> Enter password </label>
            <input type="text" id="password" name="pw" /><br>
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
