<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
 
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AccessDenied page</title>
</head>
<body class="black-skin">
<div class="container">
<%@ include file = "header.jsp" %> 
   <!--  <h1>${user}</h1> -->
    Dear <strong>${pageContext.request.userPrincipal.name}</strong>, You are not authorized to access this page
    <a class="btn btn-info" role="button" href="<c:url value="/logout" />">Logout</a>
<%@ include file="footer.jsp"%> 

</div>
</body>
</html>