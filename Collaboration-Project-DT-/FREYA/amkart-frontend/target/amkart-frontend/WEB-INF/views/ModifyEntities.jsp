<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin Entities</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddSupplier.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
 </head>
 <body>


<div class="container">
<%@ include file = "header.jsp" %>
  <h2>Welcome {name}</h2>
  <p>To Add Supplier, Category or Product details, click on the respective tab. </p>

  <ul class="nav nav-tabs">
    <li><a href="#">Home</a></li>
    <li><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/modifySupplier">Supplier</a></li>
    <li><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/modifyProduct">Product</a></li>
  </ul>

  <div>
    ${isSupplierClicked}
    
    
      	
      	<c:if test="${isSupplierClicked == true}">
    		<c:import url="../views/ModifySupplier.jsp" />  	
		
		</c:if>
	 
    	
		
		 ${isProductClicked}
    
        	
      	<c:if test="${isProductClicked == true}">
    		<c:import url="../views/ModifyProduct.jsp" />  	
		</c:if>
	
    </div>
    
 <%@ include file="footer.jsp"%> 
 
</div>
<script>
$(".nav li").on("click",function(){
	$(".nav li").removeClass("active");
	$(this).addClass("active");
});


</script>





</body>
</html>
