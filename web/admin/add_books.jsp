W<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Add Books</title>
         <%@include file="allCss.jsp" %>
    </head>
    <body style="background-color: #f0f2f2">
         <%@include file="navbar.jsp" %>
         <c:if test="${empty userobj}">
            <c:redirect url="../Login.jsp"/>   
        </c:if>
         
         
         <c:if test="${not empty succMsg}">
                            <p class="text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                            
                         <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove var="failedMsg" scope="session"/>
                        </c:if>
         <div class="container">
         <div class="row p-3">
         <div class="col-md-4 offset-md-4">
           <div class="card">
               <div class="card-body">
                   <h3 class="text-center">Add Books</h3>
                   <form action="../Booksadd_servlet" method="POST" enctype="multipart/form-data">
   <div class="form-group">
    <label for="exampleInputEmail1">Book Name*</label>
    <input type="text" class="form-control" name="bookname" aria-describedby="emailHelp" required="required">  
  </div>
      
  <div class="form-group">
    <label for="exampleInputEmail1">Author Name*</label>
    <input type="text" class="form-control"  name="author" aria-describedby="emailHelp" required="required">  
  </div>
      
   <div class="form-group">
    <label for="exampleInputEmail1">Price*</label>
    <input type="text" class="form-control"  name="price" aria-describedby="emailHelp"required="required">  
  </div>
      
                       
   <div class="form-group">
    <label for="exampleInputPassword1">Book Categories</label> <select  
        id="inputState" name="bookCategory" class="form-control">
        <option selected>--select--</option>
        <option value="New">New Book</option>
    </select>
  </div>
                       
   <div class="form-group">
    <label for="exampleInputPassword1">Book Status</label> <select  
        id="inputState" name="status" class="form-control">
        <option selected>--select--</option>
        <option value="Active">Active</option>
         <option value="Inactive">Inactive</option>
    </select>
  </div>                 
      
                      
  <div class="form-group">
    <label for="exampleFormControlFile1">Upload Photo</label>
    <input name="photo" type="file" class="form-control-file">
  </div>
  <button type="submit" class="btn btn-primary">Add</button>
</form>
               </div>
                     </div>
                 </div>
             </div>
         </div>
         <%@include file="footer.jsp" %>
    </body>
</html>
