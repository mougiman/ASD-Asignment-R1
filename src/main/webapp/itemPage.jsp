<%-- 
    Document   : itemPage
    Created on : 16/08/2019, 5:48:55 PM
    Author     : Calvin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Item Page</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>
        
        <% 
            Item item = (Item) request.getAttribute("item");
            String error = (String) request.getAttribute("err");
        %>  
        <div class="row">
        <div class="mainBox">
            <% if(error.length() > 0) { %>
            <%=error%>
            <%} else { %>
            <div class="col">
                <h><%=item.getName()%></h>
                <p></p>
                <img src="<%=item.getImage()%>" style="width:500px; height:400px;"/>
                <div> Description </div>
                    <div> <%=item.getDescription()%> </div>
                    <hr>
                    <div> Category: <%=item.getCategory()%> </div>
                    <div> Price: <%=item.getPrice()%> </div>
                    <div> Condition: <%=item.getCondition()%> </div>
                    <div> Color: <%=item.getColor()%> </div>
                    <div> Year Made: <%=item.getYearMade()%> </div>
                    <button type="button"> Buy Now! 
            </div>
            <div class="col">
                <div class="userBox">
                    <div> Listed User: <a href="salesHistory.jsp"> <%=item.getSellerID()%> </a></div>
                    <div> Listed Date: <%=item.getDateListed()%> </div>
                </div>
            </div>
            <% } %>
        </div>
    </body>
</html>
