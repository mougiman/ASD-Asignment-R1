<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>      
        <title>Main</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>

    <body>        
        <%  // This is code in relation to the local database
            // DBManager manager = (DBManager) session.getAttribute("manager");
            String itemName = request.getParameter("itemName");
        %>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row">
                <h> All products</h>
            </div>
            <div class="row">
                <div class="itemList">
                    <%
                        MongoDBConnector connector = new MongoDBConnector();
                        ArrayList<Item> items = new ArrayList<Item>();
                        items = connector.getItemList();
                        for (Item item : items) {
                    %>
                    <form method="post" action="itemPage.jsp" class="itemCard">
                        <img src="puzzle-img.jpg" style="width:200px; height:200px;"/>
                        <input type="HIDDEN" name="id" value="<%=item.getID()%>">
                        <input class="" type="submit" value="<%=item.getName()%>">
                        <p>$<%=item.getPrice()%></p>
                    </form> 
                    <%
                        }
                    %>
                </div>        
            </div>
        </div> 
        <jsp:include page="logout.jsp"/>
    </body>
</html>