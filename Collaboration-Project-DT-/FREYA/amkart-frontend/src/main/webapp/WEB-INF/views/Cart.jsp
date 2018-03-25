<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<title>Cart</title>
</head>
<body>
<div class="container">
 <%@ include file = "header.jsp" %>
 <div class="table-responsive">          
  		<table class="table" >
  			 <tr class="success">
  			<th>Product Name</th>
   			<th>Description</th>
  			<th>Quantity</th>
  			<th>Price</th>
   			<th>Image</th>
   			<th>Remove</th>
  			</tr>   
  			 
			<c:forEach items="${cartItems}" var="item">
			<tr>
				<c:set var = "cartId" scope = "session" value = "${item.cart.cartID}"/>
				<td>${item.product.productName}</td>
				<td>${item.product.description}</td>
				<td>${item.quantity}</td>
				<td>${item.price}</td>
				<td><img src="${pageContext.request.contextPath}/resources/${item.product.imageName}" class="img-responsive" alt="${productList.imageName}" height=100 width=200></td>
				<td><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/removeItem/${item.cartItemID}">remove</a></td>  
				
			</tr> 

			</c:forEach>  
		 </table>
		 <div class="btn-group">
	<a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/removeAllItems/${cartId}">Empty Cart</a>
	<a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/checkOut//${cartId}">CheckOut</a>
	 </div>
	 <%@ include file="footer.jsp"%> 
	 
	 </div>
	 </body>
	 </html>	 