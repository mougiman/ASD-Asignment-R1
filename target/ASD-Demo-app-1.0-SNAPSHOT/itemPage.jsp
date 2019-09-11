<%-- 
    Document   : itemPage
    Created on : 16/08/2019, 5:48:55 PM
    Author     : Calvin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
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
        <div class="row">
            <%
                String id = request.getParameter("id");
                MongoDBConnector connector = new MongoDBConnector();
                Item item = connector.getitem(id);
                if (item != null) {
            %>
            <div class="mainBox">
                <div class="col">
                    <h><%=item.getName()%></h>
                    <p></p>
                    <p>Description </p>
                    <p> <%=item.getDescription()%> </p>
                    <p> Category: <%=item.getCategory()%> </p>
                    <p> Price: <%=item.getPrice()%> </p>
                    <button type="button"> Buy Now! </button>
                </div>
            </div>
            <div class="col">
                <div class="userBox">
                    <div> Listed User: <%=item.getSellerID()%> </div>
                    <div> Listed Date: <%=item.getDateListed()%> </div>
                </div>
            </div>
            <%
            } else {
            %>

            <div class="mainBox">
                <div class="col">
                    <h>No Item Found!</h> <!--- Will link to item info --->
                </div>
            </div>
        </div>
        <%
            }
        %>
        <div>
            <h2>Item Reviews</h2>
            <form method="post" action="review.jsp">
                <input type="HIDDEN" name="id" value="<%=item.getID()%>">
                <input class="" type="submit" value="Leave a Review">
            </form> 
            <%
                ArrayList<Review> reviews = connector.getItemReviews(id);
                for (Review review : reviews) {
            %>
            <div>
                <h3><%=review.getTitle()%></h3>
                <p>by <%=review.getUserID()%></p>
                <p><%=review.getDesc()%></p>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
