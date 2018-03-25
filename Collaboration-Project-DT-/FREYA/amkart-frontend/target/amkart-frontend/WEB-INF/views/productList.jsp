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
<p>Type in what you want to search for!!</p>  
 
	         
  		  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  		
		 <table class="table ">
   		<tr class="success">
  			<th>ProductID</th>
  			<th>ProductName</th>
  			<th>Description</th>
  			<th>Price</th>
  			 <th>Image</th>
  			<th>DISPLAY</th>
  			</tr>  
  			 <tbody id="myTable">
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
			</tbody>
		 </table>
  		
	
  		<%@ include file="footer.jsp"%> 
  		</div>
  		
  		
 <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
  		</body>
  		</html>