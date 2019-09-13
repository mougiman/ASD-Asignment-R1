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
        <%if(session.getAttribute("userEmail")!=null)
        {
            %>
                   <h3>Welcome<%=session.getAttribute("userEmail")%></h3>
                   <a href="logout.jsp">Logout</a>
                   <%
                       }
else
{
%>
<a href="login.jsp">Login</a>
<%
    }
%>
                   
                              
      
        <jsp:include page="header.jsp"/>
            
        <div class="container">
            <div class="row">
                <h> All products </h>
            </div>
            
            <div class="row">
                <div class="itemList">
                    
                    <%for (int i = 0; i < 9; i++) { //later this will display all the listings in the DB%>
                    
                     <a href="itemPage.jsp" class="itemCard">
                         <img src="puzzle-img.jpg" style="width:200px; height:200px;"/>
                         -Item <%=i%> Name- <!--- later this will display item name --->
                         Price: $10.00 <!--- later this will display item price --->
                     </a> 
                     
                    <% } %>
                    
                    
                    
                </div>        
            </div>
        </div> 
        
        <jsp:include page="/ConnServlet" flush="true" />
        

        </div>
        
     

    </body>
</html>