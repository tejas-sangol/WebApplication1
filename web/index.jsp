<%-- 
    Document   : index
    Created on : 25 Apr, 2017, 3:26:13 AM
    Author     : tejas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
    Session ID: <%=session.getId()%>
    <br />
    <a href="?t=<%=new java.util.Date().getTime()%>">click me</a>
  </body>
</html>
