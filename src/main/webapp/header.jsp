<%-- 
    Document   : header
    Created on : 15/08/2019, 5:55:03 PM
    Author     : Changkeun
--%>
<%@page import="asd.demo.model.User"%>
<%@page import="asd.demo.model.Users"%>
<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <header>      
        <title>Barter-Mart</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </header>


      <div class="title">Sell n Buy / Barter-Mart</div>
    <% User user = (User) session.getAttribute("userLogin"); %>                                 
    <div class ="navbar">
        <span class="leftalign">
            <% if (user != null) { %>
                <a href=".\" class="links">Home</a> <!--- Links back to index --->
                <a href="listItem.jsp" class="links">List an Item</a>
                <a href="Auction.jsp" class="links">Auction a Product</a>
                <a href="placebid.jsp" class="links">Place a bid</a>
                

            <% } else { %> 
                <a href=".\" class="links">Home</a> <!--- Links back to index --->
                <a href="listItem.jsp" class="links">List an Item</a>
                <a href="Auction.jsp" class="links">Auction a Product</a>
                <a href="placebid.jsp" class="links">Place a bid</a>
                <a href="adminPage.jsp" class="links">Administration</a>
                
            <% } %>
        </span>
        <span class="rightalign">
            <% if (user != null) {%>
                <a href="myAccount.jsp"> <%=user.getEmail()%>'s Profile</a>
                <% if (true /*user.isAdmin() - Function does not exist yet*/) { %>
                    <a href="adminPage.jsp">Administration</a>
                <% } %>
                <a href="cart.jsp">Cart</a>
                <a href="logoutAction.jsp">Logout</a>
            <% } else { %>                      
            <a href="login.jsp" class="links">Log In</a>
            <a href="register.jsp" class="links" >Register</a>
            <% }%>                    
        </span> 
    </div>
</html>
