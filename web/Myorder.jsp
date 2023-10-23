<%-- 
    Document   : Myorder
    Created on : 12 Oct, 2023, 2:56:28 AM
    Author     : sunil
--%>

<%@page import="java.util.List"%>
<%@page import="dto.Bookorders"%>
<%@page import="dto.userdtls"%>
<%@page import="DAO.BookOrderDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order  Page</title>
          <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
         <c:if test="${empty userobj}">
             <c:redirect url="Login.jsp"/>
        </c:if>
         <%@include file="all_component/navbar.jsp" %>
         
         <div class="container p-1">
             <h3 class="text-center text-primary">Your Order</h3>
             <table class="table table-striped mt-3">
                 <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Name</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
       <th scope="col">Price</th>
        <th scope="col">Payment Type</th>
    </tr>
  </thead>
  <tbody>
      <%  
                                  userdtls u =(userdtls)session.getAttribute("userobj");   
                                 BookOrderDAOImpl dao=new BookOrderDAOImpl(db.DBconnector.getConnection());
                                 List<Bookorders> blist=dao.getBook(u.getEmail());
                                 for( Bookorders b:blist)
                                 {%>
                                        <tr>
                                            <th scope="row"><%=b.getOrderId()%></th>
                                            <td><%=b.getUserName()%></td>
                                            <td><%=b.getBookName()%></td>
                                            <td><%=b.getAuthor()%></td>
                                            <td><%=b.getPrice()%></td>
                                            <td><%=b.getPatmentType()%></td>   
                                        </tr> 
                                 <%}
      %>
   
   
  </tbody>
</table>
         </div>
    </body>
</html>
