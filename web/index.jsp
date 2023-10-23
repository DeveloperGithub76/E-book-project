<%-- 
    Document   : index.jsp
    Created on : 2 Oct, 2023, 12:16:03 AM
    Author     : sunil
--%>

<%@page import="dto.userdtls"%>
<%@page import="java.util.List"%>
<%@page import="dto.Bookdtls"%>
<%@page import="DAO.BookDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DBconnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Ebook:Index page</title>
        <%@include file="all_component/allCss.jsp"%>
        <style type="text/css">
           .back-img{
                background: url("https://cdn.elearningindustry.com/wp-content/uploads/2016/05/top-10-books-every-college-student-read-e1464023124869.jpeg");     
               
           
                height: 50vh;
                width: 100%;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .crd-ho:hover{
                background-color: #fcf7f7;
            }



        </style>
    </head>
    <body  style="background-color: #f7f7f7;">
        <%   userdtls u =(userdtls)session.getAttribute("userobj"); %>
        <%@include file="all_component/navbar.jsp"%>
        <div class="container-fluid back-img">
            <h2 class="text-center">Ebook Management System</h2>
        </div>
       
<!--Start Recent Book-->

<div class="container_fluid">
               <div class="container my-2">
            <h3 class="text-center">Recent Book</h3>
            <div class="row">           
                    <%
                        BookDAOImpl dao2=new BookDAOImpl(db.DBconnector.getConnection());
                        List<Bookdtls> list2=dao2.getRecentBook();
                        for(Bookdtls b:list2)
                        {%>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="book/<%=b.getPhoto()%>"style="width: 150px; height:200px;" class="img-thumblin">
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
                       <a href="Login.jsp" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-plus"></i>Add Cart </a>
                       <% }
                         else{%>
                        <a href="cart?bid=<%=b.getBookId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>

                        <% }
                    
                        %>
                         
                             <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm ml-1">View Details</a>
                             <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice()%></a>
                         </div>
                                   <%}
                        %>
                       
                    </div>
                    </div>
                </div>
                        <%}
                        %>
            
            </div>
            <div class="text-center mt-1">
                 <a href="all_recent_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>
</div>

<!--End Recent Book-->
<hr>

<!-- Start New Book-->

        <div class="container">
            <h3 class="text-center">New Book</h3>
            <div class="row">
                
                    <% BookDAOImpl dao =new BookDAOImpl(db.DBconnector.getConnection());                     
                        List<Bookdtls> list=dao.getNewBook();
                      for(Bookdtls b:list)
                    {
                    %><div class="col-md-3">
                     <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="book/<%=b.getPhoto() %>" style="width: 150px; height: 200px;" class="img-thumblin">
                        <p><%=b.getBookname() %></p>
                        <p><%=b.getAuthor() %></p>
                        <p>Categories:<%=b.getBookCategory() %></p>
                         <div class="row justify-content-center">  
                        <%    if(u==null)
                        {%>
                       <a href="Login.jsp" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-plus"></i>Add Cart </a>
                       <% }
                         else{%>
                        <a href="cart?bid=<%=b.getBookId()%>&uid=<%=u.getId()%>" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>

                        <% }
                    
                        %>
                                          
                              <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-primary btn-sm ml-1">View Details </a>
                              <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=b.getPrice()%></a>
                         </div>
                    </div>
                    </div>
                           </div>
                    <%    
                    }
                    %>
            
            </div>
            <div class="text-center mt-1">
                 <a href="all_new_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>

<!--End New Book-->
<hr>
<!-- Start Old Book-->

        <div class="container">
            <h3 class="text-center">Old Book</h3>
            <div class="row">
                
                <%
                        BookDAOImpl dao3=new BookDAOImpl(db.DBconnector.getConnection());
                        List<Bookdtls> list3=dao3.getOldBooks();
                        for(Bookdtls b:list3)
                        {%>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="book/<%=b.getPhoto()%>"style="width: 150px; height:200px;" class="img-thumblin">
                        <p><%=b.getBookname()%></p>
                        <p><%=b.getAuthor()%></p>
                        <p>Categories:<%=b.getBookCategory()%></p>
                       <div class="row justify-content-center">            
                           <a href="view_books.jsp?bid=<%=b.getBookId()%>" class="btn btn-success btn-sm"> View Details </a>
                              <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=b.getPrice()%>
                              </a>
                         </div>   
                        </div>          
                    </div>           
                </div>
                              <%}%>                    
                                  
            </div>
            <div class="text-center mt-1">
                 <a href="all_old_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>

<!--End Old Book-->

<%@include file="all_component/footer.jsp" %>
    </body>
</html>
