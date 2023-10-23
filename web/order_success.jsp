<%-- 
    Document   : order_success
    Created on : 13 Oct, 2023, 7:27:19 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Success Page</title>
        <%@include file="all_component/allCss.jsp"%>
    </head>
    <body style="background-color: #f0f1f2;">
         <%@include file="all_component/navbar.jsp"%>
         <div class="container text-center mt-3">
             <i class="fas fa-check-circle fa-5x text-success"></i>
             <h1>Thank you</h1>
             <h2>Your Order  Successfully</h2>
             <h5>With in 7 Days Your Product will be Delivered In  Your Address </h5>
             <a href="index.jsp" class="btn btn-primary mt-3">Home</a>
             <a href="Myorder.jsp" class="btn btn-danger mt-3">View Order</a>
            
         </div>
    </body>
</html>
