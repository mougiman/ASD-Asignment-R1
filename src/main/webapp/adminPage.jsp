<%-- 
    Document   : adminPage
    Created on : 26/08/2019, 4:37:48 PM
    Author     : Calvin
--%>
<%@page import="asd.demo.model.*"%>
<%@page import="asd.demo.model.dao.DBManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
            
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        
        
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h> Admin page</h>
        <div class="container">
            <div class="col">
                <div> Username: Calvin </div>
            </div>
            <div class="col">
                <a href="./all" class="button"> Manage users </a>
                <a href="allListings.jsp" class="button"> Manage listings </a>
            </div>
        </div>
    </body>
</html>
