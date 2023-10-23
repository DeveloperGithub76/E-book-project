<%@page import="dto.Bookdtls"%>
<%@page import="DAO.BookDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Add Books</title>
         <%@include file="allCss.jsp" %>
    </head>
    <body style="background-color: #f0f2f2">
         <%@include file="navbar.jsp" %>
         <div class="container">
         <div class="row p-3">
         <div class="col-md-4 offset-md-4">
           <div class="card">
               <div class="card-body">
                   <h3 class="text-center">Edit Books</h3>
                   <c:if test="${not empty succMsg}">
                            <p class="text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                            
                         <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove var="failedMsg" scope="session"/>
                        </c:if>
                 <% 
                 int id=Integer.parseInt(request.getParameter("id"));
                 BookDAOImpl dao=new BookDAOImpl(db.DBconnector.getConnection());
                 Bookdtls b=dao.getBookById(id);
                   %>
                               
                   <form action="../editBook_Servlet" method="Post">
                         <input type="hidden" name="id" value="<%=b.getBookId()%>">
   <div class="form-group">
    <label for="exampleInputEmail1">Book Name*</label>
    <input type="text" class="form-control" name="bookname" aria-describedby="emailHelp" required="required" value="<%=b.getBookname()%>">  
  </div>
      
  <div class="form-group">
    <label for="exampleInputEmail1">Author Name*</label>
    <input type="text" class="form-control"  name="author" aria-describedby="emailHelp" required="required" value="<%=b.getAuthor()%>">  
  </div>
      
   <div class="form-group">
    <label for="exampleInputEmail1">Price*</label>
    <input type="text" class="form-control"  name="price" aria-describedby="emailHelp"required="required" value="<%=b.getPrice()%>">  
  </div>
                         
   <div class="form-group">
    <label for="exampleInputPassword1">Book Status</label> <select  
        id="inputState" name="status" class="form-control">
        <% if("Active".equals(b.getStatus()))
        {
        %>
          <option value="Active">Active</option>
           <option value="Inactive">Inactive</option> 
         <%
          }  else
                  {
                    %>
                     <option value="Inactive">Inactive</option> 
                       <option value="Inactive">Inactive</option> 
          <%            
          }
         %>  
        
    </select>
  </div>                 
  <button type="submit" class="btn btn-primary">Update</button>
</form>
               </div>
                     </div>
                 </div>
             </div>
         </div>
         <%@include file="footer.jsp" %>
    </body>
</html>
