<%-- 
    Document   : all_recent_book
    Created on : 10 Oct, 2023, 5:35:43 PM
    Author     : sunil
--%>

<%@page import="dto.userdtls"%>
<%@page import="java.util.List"%>
<%@page import="dto.Bookdtls"%>
<%@page import="DAO.BookDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Recent Book Page</title>
        <%@include file="all_component/allCss.jsp"%>
         <style type="text/css">
          
            .crd-ho:hover{
                background-color: #fcf7f7;
            }
        </style>
    </head>
    <body>
         <%   userdtls u =(userdtls)session.getAttribute("userobj"); %>
        <%@include file="all_component/navbar.jsp"%>
        <div class="container-fluid">
            <div class="row p-3">
              
                     <%
                        BookDAOImpl dao2=new BookDAOImpl(db.DBconnector.getConnection());
                        List<Bookdtls> list2=dao2.getAllRecentBook();
                        for(Bookdtls b:list2)
                        {%>
                <div class="col-md-3">
                    <div class="card crd-ho mt-2">
                        <div class="card-body text-center">
                            <img alt="" src="book/<%=b.getPhoto()%>"style="width: 100px; height:150px;" class="img-thumblin">
                        <p><%=b.getBookname()%></p>
                        <p><%=b.getAuthor()%></p>
                        
                        <% 
                                  if(b.getBookCategory().equals("Old"))
                                  {%>
                                   <p>Categories:<%=b.getBookCategory()%></p>
                          <div class="row justify-content-center">
                         
                             <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm">View Details</a>
                             <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=b.getPrice()%></a>
                         </div>
                                 <%}
                                else{%>
                        <p>Categories:<%=b.getBookCategory()%></p>
                         <div class="row justify-content-center">
                             <%    if(u==null)
                        {%>
                       <a href="Login.jsp" class="btn btn-danger btn-sm ml-5"><i class="fa-solid fa-cart-plus"></i>Add Cart </a>
                       <% }
                         else{%>
                        <a href="cart?bid=<%=b.getBookId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>

                        <% }
                    
                        %>
                             <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
                             <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=b.getPrice()%></a>
                         </div>
                                   <%}
                        %>
                       
                    </div>
                    </div>
                </div>
                        <%}
                        %>
               
            </div>
        </div>
       
    </body>
</html>
