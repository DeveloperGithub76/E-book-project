<%-- 
    Document   : sell_book
    Created on : 12 Oct, 2023, 2:09:51 AM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sell Book Page</title>
          <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
         <c:if test="${empty userobj}">
            <c:redirect url="Login.jsp"/>   
        </c:if>
         <%@include file="all_component/navbar.jsp" %>
         <div class="container">
             <div class="row">
                 <div class="col-md-4 offset-md-4">
                     <div class="card mt-3">
                         <div class="card-body">
                             <h4 class="text-center text-primary p-1">Sell Old Book</h4>
                         <c:if test="${not empty succMsg}">
                            <p class="text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                            
                         <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove var="failedMsg" scope="session"/>
                        </c:if>
       <form action="add_old_book" method="Post" enctype="multipart/form-data">
                                 
          <input type="hidden" name="user" value="${userobj.email}">
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
    <label for="exampleFormControlFile1">Upload Photo</label>
    <input name="photo" type="file" class="form-control-file">
  </div>
  <button type="submit" class="btn btn-primary">Sell</button>
</form>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
    </body>
</html>
