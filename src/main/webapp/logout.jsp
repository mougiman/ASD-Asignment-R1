<%-- 
    Document   : logout
    Created on : 2019-8-17, 2:42:58
    Author     : lee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
 
    </head>
    <body>
       <%=session.getAttribute("userEmail")%><br/>
        
         <%
             response.setHeader("refresh","2;URL=index.jsp");
             session.invalidate();
             %>
    </body>
</html>