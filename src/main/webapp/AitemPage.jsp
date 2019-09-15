<%-- 
    Document   : AitemPage
    Created on : 2019-9-15, 15:58:24
    Author     : Cai weize
--%>


<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="asd.demo.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
             <meta charset=UTF-8">

    <head>
        <title>Item Page</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
    </head>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type=text/javascript> type="text/javascript"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js" type="text/javascript"></script>      
        <script type="text/javascript">
        
<script>
            $(document).ready(function(){
                $('#page').validate({
                    rules:{
                        bid:{
                            required: true,
                            digits: true,
                            maxlength: 20
                        }
      
            </script>
            <body>
        <jsp:include page="header.jsp"/>
        
        <% 
            Item item = (Item) request.getAttribute("item");
         
             
            String error = (String) request.getAttribute("err");
            LocalDate now =LocalDate.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          //  double bid =Double.parseDouble(request.getParameter("bid"));
            String b = request.getParameter("bid");
            MongoDBConnector connector = new MongoDBConnector(); 
        %> 
        <form method="post"action="./item?id=<%=item.getID()%>" id ="page">
        <div class="row">
        <div class="mainBox">
            <% if(error.length() > 0) { %>
            <%=error%>
            <%} else if (item.getExpDate().compareTo(date)<=0)
{ %>
               <p> this item is expired</p>
         <a href="../home" >go to home page</a>

<%
}else if( b == null){ %>
            <div class="col">
                <h><%=item.getName()%></h>
                <p></p>
                <img src="<%=item.getImage()%>" style="width:500px; height:400px;"/>
                <div> Description </div>
                    <div> <%=item.getDescription()%> </div>
                    <hr>
                    <div> Category: <%=item.getCategory()%> </div>
                    <div> Price: <%=item.getPrice()%> </div>
                    <div> New bid <input type="text" name="bid" value = "0"></div>
                    <div> Expiration Date: <%=item.getExpDate()%></div>
                    
                    <button type="submit" value = "AitemPage"> Place bid Now! </button>
            </div>
            <div class="col">
                <div class="userBox">
                    <div> User Info <div>
                    <div> Listed User: <a href="salesHistory.jsp"> <%=item.getSellerID()%> </a></div>
                    <div> Listed Date: <%=item.getDateListed()%> </div>
                </div>
            </div>
                </div>
                </form>
            <% }else if( Double.parseDouble(b) <=item.getPrice() ){  %>
               <p> you need to put a higher bid</p>
         <a href="./item?id=<%=item.getID()%>" >place bid again</a>
        <%} else{
connector.changePrice(item.getID(),  Double.parseDouble(b));                           

        %>
         <p>Bid has been placed</p>
         <a href="./item?id=<%=item.getID()%>" >back to homepage</a>
        <%}%>
    </body>
</html>

