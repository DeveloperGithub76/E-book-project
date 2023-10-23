<%-- 
    Document   : home
    Created on : 3 Oct, 2023, 7:59:46 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home page</title>
        <%@include file="allCss.jsp" %>
        <style type="text/css">
            a{
                text-decoration: none;
                color: black;
            }
                a:hover
                {
                    text-decoration: none;
                    color: black;
                }
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <c:if test="${empty userobj}">
            <c:redirect url="../Login.jsp"/>   
        </c:if>
        <div class="container">
        <div class="row p-5">
        <div class="col-md-3">
            <a href="add_books.jsp">
        <div class="card">
              <div class="card-body text-center">
              <i class="fa-regular fa-square-plus fa-3x text-primary"></i>
              <p>Add Books</p>
                     --------
              </div>
        </div>
          </a>
         </div>
            
       <div class="col-md-3">
           <a href="all_books.jsp">
        <div class="card">
              <div class="card-body text-center">
              <i class="fa-solid fa-book-open fa-3x text-danger"></i>
               <p>All Books</p>
                     --------
              </div>
        </div>
        </a>
         </div>
            
        <div class="col-md-3">
            <a href="orders.jsp">
        <div class="card">
               <div class="card-body text-center">
                <i class="fa-solid fa-box fa-3x text-warning"></i>
                <p>Orders</p>
                     --------
                </div>
        </div>
            </a>
         </div>
            
            <div class="col-md-3">
                <a data-toggle="modal" data-target="#exampleModalCenter">
                     <div class="card">
            <div class="card-body text-center">
            <i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i>
                <p>Logout</p>
                     --------
            </div>
           </div>
                </a>
         </div>
            </div>
        </div>
        <!--Logout modal-->
<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="text-center">
              <h4>Do You Want Logout</h4>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a href="../Logout" type="button" class="btn btn-primary text-white">Logout</a>
          </div>
      </div>
      <div class="modal-footer">
       
      </div>
    </div>
  </div>
</div>
<!--End Logout modal-->
        <div style="margin-top: 270px;"> <%@include file="footer.jsp" %></div>
    </body>
</html>
