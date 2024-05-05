<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

            <meta charset="UTF-8">

            <meta http-equiv="X-UA-Compatible" content="IE=edge">

            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Receipt Sample</title>
<%@ include file="./components/common_cs_js.jsp"%>
<link rel="stylesheet" href="css/payment.css"> 


  
</head>

<body>
         <%@ include file="./components/navbar.jsp"%>
         
  
      	<%@ include file="./components/message.jsp"%>




        <div class="container">

           

            <div class="receipt_header">  

            <h1>Payment Receipt</h1>

            <h2>Address: Lorem Ipsum, 1234-5 <span>phone: +1 012 345 67 89</span></h2>

            </div>

           

            <div class="receipt_body">

       

                <div class="date_time_con">

                    <div class="date">11/12/2020</div>

                    <div class="time">11:13:06 AM</div>

                </div>

       

                <div class="items">

                    <table>


<thead>

<th>QTY</th>

<th>ITEM</th>

 <th>AMT</th>

 </thead>
 <%
List<Orders> listOfOrders = new ArrayList<>();

listOfOrders = (List<Orders>)request.getAttribute("orders");
double totalCartPrice = 0;
double totalDiscountPrice = 0;


if(listOfOrders != null ) {
    for(Orders o : listOfOrders) {
           
     	  
  	  Product f =  productDao.getProductById(o.getProductId());
          
           User u = userDao.getUserById(o.getUserId());
           double productPrice = Helper.getProductSellingPrice(f.getPrice(), f.getDiscount());
     	   double cartPrice = productPrice * o.getQuantity();
     	   double DiscountPrice = (f.getPrice()* f.getDiscount()) / 100;
     	   totalCartPrice = totalCartPrice + cartPrice;
     	  totalDiscountPrice = totalDiscountPrice + DiscountPrice;

           
%>



<tbody>

<tr>

<td><%=o.getQuantity() %></td>
<script>console.log(o)</script>

<td><%=f.getName() %></td>
<td><%=f.getPrice() %></td>

</tr>

</tbody>


<%
    }
}
%>
<tfoot>

<tr>

<td>Discount</td>

<td></td>

<td> -<%=  totalDiscountPrice %></td>

</tr>



<tr>

<td>Total</td>

<td></td>

<td><%= totalCartPrice %></td>

</tr>


</tfoot>
</table>

                </div>


            </div>


            <h3>Thank You!</h3>

       

        </div>



      
</body>
</html>