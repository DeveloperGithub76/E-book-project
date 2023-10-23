<%-- 
    Document   : old_book
    Created on : 12 Oct, 2023, 1:48:15 PM
    Author     : sunil
--%>

<%@page import="java.util.List"%>
<%@page import="dto.Bookdtls"%>
<%@page import="dto.userdtls"%>
<%@page import="DAO.BookDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User:Old Book Page</title>
          <%@include file="all_component/allCss.jsp"%>
    </head>
    <body style="background-color: #f0f1f2;">
         <%@include file="all_component/navbar.jsp"%>
         
                      <c:if test="${not empty succMsg}">
                          <div class="alert alert-success text-center">${succMsg}</div>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                            
                       
         <div class="container p-5">
   <table class="table table-striped">
       <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
       <th scope="col">Category</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody> 
                                    <%            
                                       userdtls u =(userdtls)session.getAttribute("userobj");   
                                       String email=u.getEmail();                                    
                                        BookDAOImpl dao= new BookDAOImpl(db.DBconnector.getConnection());
                                        List<Bookdtls> list=dao.getBookByOld(email,"Old");
                                        for( Bookdtls b:list)
                                        {%>
                                               <tr>     
                                                   <td><%=b.getBookname()%></td>
                                                   <td><%=b.getAuthor()%></td>
                                                   <td><%=b.getPrice()%></td>
                                                    <td><%=b.getBookCategory()%></td>
                                                    <td><a href="delete_old_book?em=<%=email%>&&id=<%=b.getBookId()%>" class="btn btn-danger">Delete</a></td>
                                               </tr>
   
                                        <%}
                                        %>
   
  </tbody>
</table>
         </div>
    </body>
</html>
