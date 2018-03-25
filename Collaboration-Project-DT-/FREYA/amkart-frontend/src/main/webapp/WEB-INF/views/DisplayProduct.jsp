<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	img  {
    float:left;
}

	

</style>
<title>Display Product</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  </head>
<body>
<div class="container">
<%@ include file = "header.jsp" %>
		 <form:form method="POST" action="${pageContext.request.contextPath}/addToCart" modelAttribute="cartItem" id="AddToCart">
 		<div class="input-group">
	       <p><input type="hidden" class="form-control" name="productID" value="${product.productID}"/></p>
    	</div>
	<div class="well well-lg">${product.productName}</div>	
	<img src="${pageContext.request.contextPath}/resources/${product.imageName}" class="img-responsive img-rounded" alt="${product.imageName}" height=400 width=400>
	<div class="input-group">
	    <label for="productDescription">Details: ${product.description}</label>
    </div>
	 <div class="input-group">
	    <label for="productPrice">PRICE: ${product.price}</label>
	    <p><form:hidden class="form-control" path="price" name="price" value="${product.price}"/></p>
    </div>
     <div class="input-group">
		  <label for="Quantity">Enter Quantity:</label>
		    <p><form:input class="form-control" path="quantity" name="quantity" value="1"/></p>
	    </div>
	        
	    
	    	        <button type="submit" class="button"><span>ADD TO CART</span><i class="icon-shopping-cart"></i> </button>
	</form:form>
	</div>
		<%@ include file="footer.jsp"%> 
	
</body>
</html>