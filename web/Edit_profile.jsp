<%-- 
    Document   : Edit_profile
    Created on : 12 Oct, 2023, 2:19:58 AM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile Page</title>
          <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
          <%@include file="all_component/navbar.jsp" %>
          <div class="container mt-3">
              <div class="row">
                  <div class="col-md-4 offset-md-4">
                      <div class="card">
                          <div class="card-body">
                              <h4 class="text-center text-primary">Edit Profile</h4>
       <c:if test="${not empty succMsg}">
           <h5 class="text-center text-success">${succMsg}</h5>
           <c:remove var="succMsg" scope="session"/>
       </c:if>
                  
       <c:if test="${not empty failedMsg}">
           <h5 class="text-center text-danger">${failedMsg}</h5>
           <c:remove var="failedMsg" scope="session"/>
       </c:if>
    <form action="update_profile" method="Post">
        <input type="hidden" value="${userobj.id}" name="id">
   <div class="form-group">
    <label for="nameField">Enter Full Name</label>
    <input type="text" class="form-control" id="nameField" name="name" aria-describedby="emailHelp" required="required" value="${userobj.name}">  
  </div>
      
  <div class="form-group">
    <label for="emailField">Email Address</label>
    <input type="email" class="form-control" id="emailField" name="email" aria-describedby="emailHelp" required="required" value="${userobj.email}">  
  </div>
  
  <div class="form-group">
    <label for="phnoField">Phone Number</label>
    <input type="text"class="form-control" id="phnoField" name="phno" aria-describedby="emailHelp" required="required" value=""/>  
</div>

      
  <div class="form-group">
    <label for="passwordField">Password</label>
    <input type="password" class="form-control" id="passwordField" name="password" required="required">
  </div>
      

  <div class="text-center p-2">
      <button type="submit" class="btn btn-primary btn-block btn-sm">Update</button>
  </div>
</form>

                          </div> 
                      </div>
                  </div>
              </div>
          </div>
    </body>
</html>
