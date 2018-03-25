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
 <!-- <form:form>
 	<div class="input-group">
	       <p><input type="hidden"  class="form-control" name="cartID" value="${cart.cartID}"/></p>
    	</div>
 </form:form>
 -->
 <div class="table-responsive">          
  		<table class="table table-striped" >
<tr class="success"> 
  			<th><h1>Order Summary</h1></th>
  			<th></th>
  			</tr>
  			<tr>
   			<td><h3>total Items</h3></td>
   			
   			<td>${cart.cartQuantity}</td>
   			</tr>
   			<tr>
   			<td><h3>Order total</h3></td>
   			<td> ${order.total}</td>
   			</tr>
   			<tr>
   			<td><h3>Delivery</h3></td>
   			<td>Free</td>
   			</tr>
   			<tr>
   			<td><h3>Payment:</h3></td>
   			
   			<td>
 		 		   <a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/placeOrder/${order.orderId}/${cart.cartID}" class="btn btn-info" role="button">Make Payment</a>
 	
		  	 </td>
   			</tr>
   			</table>
  		</div>
  		<%@ include file="footer.jsp"%> 
  		
  		</div>
  		</body>
  		</html>