<%-- 
    Document   : register
    Created on : 2 Oct, 2023, 6:33:35 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ebook: Register Page</title>
        <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f1f2;">
          <%@include file="all_component/navbar.jsp" %>
       <div class="container p-3">
          <div class="row">
          <div class="col-md-4 offset-md-4">
           <div class="card">
           <div class="card-body">
            <h3 class="text-center">Registration</h3>
                        
                        <c:if test="${not empty succMsg}">
                            <p class="text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                            
                         <c:if test="${not empty failedMsg}">
                            <p class="text-center text-danger">${failedMsg}</p>
                            <c:remove var="failedMsg" scope="session"/>
                        </c:if>
                            
    <form action="Register_Servlet" method="Post">
   <div class="form-group">
    <label for="exampleInputEmail1">Enter Full Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" required="required" placeholder="Enter full name">  
  </div>
      
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" required="required" placeholder="Enter email address">  
  </div>
      
   <div class="form-group">
    <label for="exampleInputEmail1">Phone No.</label>
    <input type="number" class="form-control" id="exampleInputEmail1" name="phno" aria-describedby="emailHelp"required="required" placeholder="Enter phone number">  
  </div>
      
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1"name="password" required="required" placeholder="Enter password">
  </div>
      
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="check">
    <label class="form-check-label" for="exampleCheck1">Agree term & condition</label>
  </div>
  <button type="submit" class="btn btn-primary">Register</button>
</form>
        </div>
        </div>                   
        </div>
        </div>
       </div>
          <%@include file="all_component/footer.jsp" %>     
    </body>
</html>
