<%-- 
    Document   : listItem
    Created on : 11/08/2019, 3:29:51 PM
    Author     : Mougi
--%>

<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css" integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <%  // This is code in relation to the local database
            MongoDBConnector connector = new MongoDBConnector();
            //this is code that changes the page depending on if the user has listed an  item properly
            String itemName = request.getParameter("itemName");
            if (itemName == null) {
        %>
        <h1><p>List an Item</p></h1>
        <!--If user is logged in then -->

        <form class="pure-form pure-form-aligned" method="post" action="listItem.jsp">
            <fieldset>
                <div class="pure-control-group">
                    <label for="">Name:</label>
                    <input id="" type="text" placeholder="" name="itemName" required>
                </div>

                <div class="pure-control-group">
                    <label for="">Category:</label>
                    <input id="" type="text" placeholder="" name="itemCategory" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Condition:</label>
                    <input id="" type="text" placeholder="" name="itemCondition" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Quantity:</label>
                    <input id="" type="number" max="999" placeholder="" name="itemQuantity" required>
                </div>
                <div class="pure-control-group">
                    <label for="">Price:</label>
                    <input id="" type="number" min="0.01" step="0.01" max="2500" placeholder="" name="itemPrice" required>
                </div>
                <div class="pure-control-group" >
                    <label for="">Description:</label>
                    <textarea nmae = "itemDesc" class="pure-input-1-2" placeholder="This item...." required></textarea>
                </div>
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Submit</button>
                </div>
            </fieldset>
        </form>
        <%
        } else {
            String itemCategory = request.getParameter("itemCategory");
            String itemDesc = request.getParameter("itemDesc");
            Double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            String itemDateListed = "" + java.time.LocalDate.now();
            int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
            String itemSellerID = "11111111";
            Random rand = new Random();
            String itemID = "" + rand.nextInt(999999999);
            String img = request.getParameter("img");

            connector.addItem(itemID, itemName, itemDateListed, itemQuantity, itemPrice, itemDesc, itemCategory, itemSellerID, "buyerid");
        %>
        <p><%=itemName%> has been Listed</p>
        <a href="listItem.jsp">List another item</a>
        <%
            }
        %>

    </body>
</html>
