<%-- 
    Document   : cart
    Created on : 11 Oct, 2023, 3:26:16 PM
    Author     : sunil
--%>

<%@page import="java.util.List"%>
<%@page import="dto.Cart"%>
<%@page import="dto.userdtls"%>
<%@page import="DAO.CartDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cart JSP Page</title>
         <%@include file="all_component/allCss.jsp"%>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp"%>
        <c:if test="${ empty userobj }">
            <c:redirect url="Login.jsp"></c:redirect>
        </c:if>
        
        <c:if test="${not empty succMsg}">
            <div class="alert alert-success text-center" role="alert">
               ${succMsg}
             </div>
            <c:remove var="succMsg" scope="session"/>
        </c:if>
        
        <c:if test="${not empty failedMsg}">
            <div class="alert alert-danger text-center" role="alert">
               ${failedMsg}
             </div>
            <c:remove var="failedMsg" scope="session"/>
        </c:if>
        <div class="container">
            <div class="row p-3">
                <div class="col-md-6">
                   
                    <div class="card bg-white">
                        <div class="card-body">
                             <h3 class="text-center text-success">Your Selected Item</h3>
   <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
      <%  
               userdtls u =(userdtls)session.getAttribute("userobj");              
                  CartDAOImpl dao=new CartDAOImpl(db.DBconnector.getConnection());
                        List<Cart> cart=dao.getBookByUser(u.getId());
                       Double totalPrice=0.00;
                        for(Cart c:cart)
                        {  totalPrice=c.getTotal_price();    %>
                            <tr>
                                <th scope="row"><%=c.getBookname()%></th>
                                <td><%=c.getAuthor()%></td>
                                <td><%=c.getPrice()%></td>
                                <td>
                                    <a href="remove_book?bid=<%=c.getBid()%>&&uid=<%=c.getUid()%>&&cid=<%=c.getCid()%>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Remove</a>
                                </td>
                            </tr>
   
                       <%}
                        %>
                         <tr>                               
                                <td>Total Price</td>
                                <td></td>
                                <td></td>
                                <td><%=totalPrice%> </td>
                            </tr>
   

  </tbody>
</table>       
                </div>
            </div>
        </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-center text-success">Your Details For Order</h3>
                            <form action="order" method="Post">
       <input type="hidden" value="${userobj.id}" name="id">
     <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Name</label>
      <input type="text" class="form-control" value="${userobj.name}" name="username" readonly="readonly">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Email</label>
      <input type="email" class="form-control" value="${userobj.email}"  name="email" readonly="readonly">
    </div>
  </div>
       
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Phone Number</label>
      <input type="text" class="form-control" name="phno" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Address</label>
      <input type="text" class="form-control" value="" name="address"  required>
    </div>
  </div>
       
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Landmark</label>
      <input type="text" class="form-control" value="" name="landmark"  required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">City</label>
      <input type="text" class="form-control" value="" name="city"  required>
    </div>
  </div>
       
       
     <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">State</label>
      <input type="text" class="form-control" value="" name="state"  required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Pin code</label>
      <input type="text" class="form-control" name="pincode"  required>
    </div>
  </div>
       
       <div class="form-group">
           <label>Payment Mode</label>
           <select class="form-control" name="payment">
               <option value="noselect">--Select--</option>
               <option value="COD">Cash On Delivery</option>
           </select>
       </div>
       
       <div class="text-center">
           <button class="btn btn-warning">Order Now</button>
           <a  href="index.jsp" class="btn btn-success">Continue Shopping</a>
       </div>
</form>
                        </div>
                    </div>  
                </div>
            </div> 
        </div>
      
    </body>
</html>
