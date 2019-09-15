<%-- 
    Document   : view_user
    Created on : Aug 15, 2019, 5:33:46 PM
    Author     : Sean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="asd.demo.model.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="asd.demo.controller.*"%>
<%@page import="asd.demo.model.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    </head>
    <jsp:include page="header.jsp"/>

    <body>              
        <% 
            User user = (User) request.getAttribute("user");
            String error = (String) request.getAttribute("err");
        %>

    <div>
        <div class="col-sm-12">
            <div class="col-sm-2"></div>
<% if(error.length() > 0) { %>
            <%=error%>
            <%} else { %>
                <div class="col-sm-8">
                    <h2 class="text-center"><%=user.getID()%> Profile</h2>
                    <table class="table table-striped">
                      
                        <tr>
                        <td>Name</td>
                        <td>Phone</td>
                        <td>Email</td>
                      </tr>
                       
                      <tr>
                        <td><%=user.getName()%></td>
                        <td><%=user.getPhone()%></td>
                        <td><%=user.getEmail()%></td>                       
                      </tr>
                       
                      
                     
                       
                    <tr>
                         <td class="text-center" colspan="3">
<button onclick="location.href='sales?id=<%= user.getID() %>'" class="btn btn-primary">Sales History</button>

<button onclick="location.href='order?id=<%= user.getID() %>'" class="btn btn-warning">Order History</button>
                          
                         </td>    
                    </tr> 

                    </table>       
                </div>
<% } %>
        </div> <!-- col-sm-12 -->
    </div><!-- row -->
    </body>
</html>    

    
 


