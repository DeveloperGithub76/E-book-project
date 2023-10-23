<%-- 
    Document   : all_books
    Created on : 3 Oct, 2023, 11:21:40 PM
    Author     : sunil
--%>

<%@page import="java.util.List"%>
<%@page import="dto.Bookorders"%>
<%@page import="DAO.BookOrderDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Order Page</title>
         <%@include file="allCss.jsp" %>
    </head>
    <body>
        <c:if test="${empty userobj}">
             <c:redirect url="Login.jsp"/>
        </c:if>
         <%@include file="navbar.jsp" %>
         <h3 class="text-center"> Hello Admin...</h3>
         <table class="table table-striped">
     <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col"> Name</th>
      <th scope="col">Email</th>
      <th scope="col">Price</th>
       <th scope="col">Ph No</th>
        <th scope="col">Book Name</th>
         <th scope="col">Author</th>
          <th scope="col">Price</th>
           <th scope="col">Payment type</th>
    </tr>
  </thead>
  <tbody>
      <%                   
                    BookOrderDAOImpl dao=new BookOrderDAOImpl(db.DBconnector.getConnection());
                    List<Bookorders> blist= dao.getAllOrder();
                    for(Bookorders b:blist)
                    {%>
                        
                                      <tr>
                                          <th scope="row"><%=b.getOrderId()%></th>
                                          <td><%=b.getUserName()%></td>
                                          <td><%=b.getEmail()%></td>
                                          <td><%=b.getFulladd()%></td>
                                          <td><%=b.getPhno()%></td>
                                          <td><%=b.getBookName()%></td>
                                          <td><%=b.getAuthor()%></td>
                                          <td><%=b.getPrice()%></td>
                                          <td><%=b.getPatmentType()%></td>
                                      </tr>
                    <%}
                      
      %>
   
    
  </tbody>
</table>
          <div style="margin-top: 370px;"> <%@include file="footer.jsp" %></div>
    </body>
</html>
