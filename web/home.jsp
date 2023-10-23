<%-- 
    Document   : home
    Created on : 3 Oct, 2023, 12:17:54 AM
    Author     : sunil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            
        <c:if test="${not empty userobj}">
           <h5 class="text-center text-danger">${failedMsg}</h5>
           <h1>Name:${userobj.name}</h1>
       </c:if>
        <h1>user Home</h1>
    </body>
</html>
