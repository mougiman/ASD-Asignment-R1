<%-- 
    Document   : Auction
    Created on : 2019-8-13, 19:34:59
    Author     : Cai weize
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="asd.demo.model.dao.MongoDBConnector"%>
<%@page import="java.util.Random"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">       
    <head>
         <meta charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type=text/javascript> type="text/javascript"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js" type="text/javascript"></script>      
        <script type="text/javascript">
        
<script>
            $(document).ready(function(){
                $('#auctionform').validate({
                    rules:{
                        itemName:{
                            required: true,
                            textonly: true,
                            maxlength: 20
                        },
                       itemC:{
                            required: true
                     
                        },
                       itemDesc:{
                            required:true
                       
                       },
                       itemQ:{
                           required:true,
                            digits: true
                           
                         
                       },
                       itemPrice:{
                           required: true,
                           digits: true
                        
                       }
                   }
                
       
                });
                
            });

        </script>





        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List an Item</title>
        <link rel="stylesheet" href="css/ASDStyle.css">
        
    </head>
        <jsp:include page="header.jsp"/>
    <body>
 <%     MongoDBConnector connector = new MongoDBConnector(); 
 LocalDate now =LocalDate.now();
        String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String expdate = request.getParameter("expdate");

  String itemName = request.getParameter("itemName");
            if (itemName == null ) {
               
            %>

        <h1><p>Auction a Product</p></h1>
        <!--If user is logged in then -->
        <form method="post"action="Auction.jsp" id = "auctionform">
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
                        <p>Category:</p>
                    </td>
                    <td>
                        <input type="text" name="itemC">
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
                        <p>Quantity:</p>
                    </td>
                    <td>
                        <input type="text" name="itemQ">
                    </td>
                </tr>                
                <tr>
                    <td>
                        <p>Lowest price:</p>
                    </td>
                    <td>
                        <input type="text" name="itemPrice">
                    </td>
                </tr>
               

                 <tr>
                    <td>
                        <p>Expire Date:</p>
                    </td>
                    <td>
                        <input type="date" name="expdate" id="expdate">
                    </td>
                </tr>
                <tr><td></td><td>
                        <!--If all necessary forms are filled out then let user submit -->
                        <input type="submit" value="Auction item">
                    </td></tr>
            </table>
        </form>
        <%  
        } else if( expdate.compareTo(date)<0 )
{
 %>
        <p><%=itemName%>  Has a wrong time</p>
        <a href="Auction.jsp">Auction again</a>
        <%
}
else {

            String itemCategory = request.getParameter("itemC");
            String itemDesc = request.getParameter("itemDesc");
           
            Double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            String itemDateListed = "" + java.time.LocalDate.now();
            int itemQuantity = Integer.parseInt(request.getParameter("itemQ"));
            String expdate1 = request.getParameter("expdate");
           
            String itemSellerID = "11111111";
            Random rand = new Random();
            String itemID = "" + rand.nextInt(999999999);
            boolean ifAuc = true;

            
            

            connector.addAucItem(itemID, itemName, itemDateListed, itemQuantity,  itemPrice, itemDesc, itemCategory,itemSellerID,  expdate1, null, ifAuc);
        %>
        <p><%=itemName%> has been Auctioned</p>
        <a href="Auction.jsp">Auction another Product</a>
        <%
            }
        %>

    </body>
</html>
