<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.*"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>

    <body>        
        <%  // This is code in relation to the local database
            ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("itemList");
            String error = (String) request.getAttribute("error");
        %>
        
        <jsp:include page="../header.jsp"/>
        
        <div class="container">
            <div class="row">
                <h> All products </h>
            </div>
            <div class="row">
                <form action="./home">
                    Search Bar
                    <input type="text" name="searchText">
                    <input type="submit" name="search" value="Search">
                    <br>
                    <input type="radio" name="searchType" value="item" checked> Search for Item </input>
                    <input type="radio" name="searchType" value="category"> Search for Category </input>
                    <br>
                    <select name="sort">
                        <option value="null"> Sort By </option>
                        <option value="lowToHigh"> Price - Low to High </option>
                        <option value="highToLow"> Price - High to low </option>
                    </select>
                    
                </form>
            </div>
            <div class="row">
                <div class="itemList">
                    
                    <% if(error.length() > 0){ %>
                        <%=error%>
                    <% } %>
                    <%for (int i = 0; i < items.size(); i++) { Item item = items.get(i);%>
                    <a href="./item?id=<%=item.getID()%>" class="itemCard">
                        <input type="hidden" name="itemID" value="<%=item.getID()%>"/>
                        <div class="imageContainer">
                            <span class="helper"></span>
                            <img src="<%=item.getImage()%>"/>
                        </div>
                        <br>
                         <%=item.getName()%>
                         $<%=item.getPrice()%>
                     </a>
                    <% } %>
                </div>        
            </div>
        </div> 
        <%--<jsp:include page="logout.jsp"/>--%>
        </div>
    </body>
</html>