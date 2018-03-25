<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  </head>
<body>
<div class="container">
<%@ include file = "header.jsp" %>
	  <h1>${categoryName}</h1>
	  <div class="table-responsive">          
  		
		 <table class="table ">
   		<tr class="success">
  			<th>ProductID</th>
  			<th>ProductName</th>
  			<th>Description</th>
  			<th>Price</th>
  			 <th>Image</th>
  			<th>DISPLAY</th>
  			</tr>  
			<c:forEach items="${productList}" var="productList">
			<tr>
				<td>${productList.productID}</td>
				<td>${productList.productName}</td>
				<td>${productList.description}</td>
				<td>${productList.price}</td>
				<td><img src="${pageContext.request.contextPath}/resources/${productList.imageName}" class="img-responsive" alt="${productList.imageName}" height=100 width=200></td>
				<td><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/displayProduct/${productList.productID}">DISPLAY</a></td>  
				</tr> 

			</c:forEach>  
		 </table>
		 </div>
		 <%@ include file="footer.jsp"%> 
		 
		 </div>
		 </body>
		 </html>
		 