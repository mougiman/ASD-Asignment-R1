<%-- 
    Document   : listItem
    Created on : 11/08/2019, 3:29:51 PM
    Author     : Mougi
--%>

<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="asd.demo.model.dao.DBManager"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
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
        <form method="post" action="listItem.jsp">
            <table>
                <tr>
                    <td>
                        <p>Name:</p>
                    </td>
                    <td>
                        <input type="text" name="itemName">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Image:</p>
                        <p>Will be implemented</p>
                    </td>
                    <td>
                        <input type="text" name="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Category:</p>
                    </td>
                    <td>
                        <input type="text" name="itemCategory">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Description:</p>
                    </td>
                    <td>
                        <input type="text" name="itemDesc">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Condition:</p>
                    </td>
                    <td>
                        <select name="itemCond">
                            <option value="New">New</option>
                            <option value="Used">Used</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Quantity:</p>
                    </td>
                    <td>
                        <input type="number" name="itemQuantity">
                    </td>
                </tr>                
                <tr>
                    <td>
                        <p>Pricing:</p>
                    </td>
                    <td>
                        <input type="text" name="itemPrice">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Color:</p>
                    </td>
                    <td>
                        <input type="text" name="itemColor">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Year Made:</p>
                    </td>
                    <td>
                        <input type="number" name="itemYearMade">
                    </td>
                </tr>
                <tr><td></td><td>
                        <!--If all necessary forms are filled out then let user submit -->
                        <input type="submit" value="List Item">
                    </td></tr>
            </table>
        </form>
        <%
        } else {
            String itemCategory = request.getParameter("itemCategory");
            String itemDesc = request.getParameter("itemDesc");
            String itemCond = request.getParameter("name");
            Double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            String itemDateListed = "" + java.time.LocalDate.now();
            int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
            String itemSellerID = "11111111";
            Random rand = new Random();
            String itemID = "" + rand.nextInt(999999999);
            String itemColor = request.getParameter("itemColor");
            String itemYearMade = request.getParameter("itemYearMade");

            connector.addItem(itemID, itemName, itemDateListed, itemQuantity, itemPrice, itemDesc, itemCategory, itemSellerID, "buyerid");
        %>
        <p><%=itemName%> has been Listed</p>
        <a href="listItem.jsp">List another item</a>
        <%
            }
        %>

    </body>
</html>
