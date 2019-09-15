<%-- 
    Document   : review
    Created on : 02/09/2019, 2:35:16 PM
    Author     : mougi
--%>

<%@page import="java.util.Random"%>
<%@page import="asd.demo.model.Item"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave a Review</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
    <body>  
        <jsp:include page="header.jsp"/>  

        <%
            String itemid = request.getParameter("id");
            String title = request.getParameter("title");
            MongoDBConnector connector = new MongoDBConnector();
            if (itemid != null) {
                if (title == null) {
        %>
        <form class="pure-form pure-form-aligned" method="post" action="review.jsp">
            <fieldset>
                <div class="pure-control-group">
                    <label for="">Review Title:</label>
                    <input id="" type="text" placeholder="" name="title" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Description:</label>
                    <input id="" placeholder="" name="desc" required>
                </div>            
                <input type="HIDDEN" name="itemid" value="<%=itemid%>">
                <input type="HIDDEN" name="userid" value="111111">
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
        <%
        } else {
            String userid = request.getParameter("userid");
            Random rand = new Random();
            String id = "" + rand.nextInt(999999);
            String desc = request.getParameter("desc");
            String DateListed = "" + java.time.LocalDate.now();
            connector.addReview(id, itemid, userid, desc, title, DateListed);

        %>
        <h2>Thank you for your review</h2>
        <a href="index.jsp">Return to main page</a>
        <%            }
        } else {
        %>
        <div class="mainBox">
            <div class="col">
                <h>Something went wrong!</h>
            </div>
        </div>
    </div>
    <%
        }
    %>
</body>
</html>
