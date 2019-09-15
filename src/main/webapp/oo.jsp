<%-- 
    Document   : oo
    Created on : 2019-9-16, 2:58:14
    Author     : Cai weize
--%>

<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 
            String id = request.getParameter("id");
            double bid = Double.parseDouble(request.getParameter("bid"));
             double price = Double.parseDouble(request.getParameter("price"));
            if(bid <=price)
            {
            %>
            <p> bid is too small</p>
           <%   }else{
              MongoDBConnector connector = new MongoDBConnector();
              connector.changePrice(request.getParameter("id"), Double.parseDouble(request.getParameter("bid")));   
        %>  
        <p>success</p>
  <a href=".\" class="links">Home</a> 
      <a href="./item?id=<%=id%>"> back </a>
    </body>
     <% }%>
</html>
