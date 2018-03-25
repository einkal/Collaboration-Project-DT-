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
<title>Add Product</title>
</head>
<body>
		<form:form method="POST" action="addProduct" modelAttribute="product" id="productAddForm"  enctype="multipart/form-data">
		  <h1>ADD PRODUCT:</h1>
		  <div class="input-group">
		  
		 	    
	    <div class="input-group">
		  <label for="productName">NAME:</label>
		    <p><form:input class="form-control" path="productName" placeholder="product Name..." name="productName"/></p>
	    </div>
	       
	      <div class="input-group">
		  <label for="description">DESCRIPTION:</label>
		    <p><form:input class="form-control" path="description" placeholder="description..." name="description"/></p>
	    </div>   
	       
	       <div class="input-group">
		  <label for="price">PRICE:</label>
		    <p><form:input class="form-control" path="price" placeholder="price..." name="price"/></p>
	    </div>
	       
	       
	        <div class="input-group">
		  <label for="stock">STOCK:</label>
		    <p><form:input class="form-control" path="stock" placeholder="stock..." name="stock"/></p>
	    </div>
	     <div class="form-group">
	     
	    <label for="category">Select Category:</label>
        <form:select path="categoryID" class="form-control" id="category" name="category">
         <form:option value = "NONE" label = "Select">---Category---</form:option>
            <c:forEach items="${categoryList}" var="categoryList">
                
               <form:option value="${categoryList.categoryID}">
               		${categoryList.categoryName}
               </form:option>
                    
                   
            </c:forEach>
        </form:select>
	   </div>
	   
	   <div class="form-group">
	     
	    <label for="supplier">Select Supplier:</label>
        <form:select path="supplierID" class="form-control" id="supplier" name="supplier">
         <form:option value = "NONE" label = "Select">---Supplier---</form:option>
            <c:forEach items="${supplierList}" var="supplierList">
                
               <form:option value="${supplierList.supplierID}">
               		${supplierList.supplierName}
               </form:option>
                    
                   
            </c:forEach>
        </form:select>
	   </div>
	 
	        <div class="input-group">
	        <div class="fileinput fileinput-new" data-provides="fileinput">
		 	<label for="imageName">UPLOAD IMAGE:</label>
		    <p><input type="file" path="imageName" placeholder="Image..." name="file"/></p>
		  <span class="input-group-addon"><i class="glyphicon glyphicon-file fileinput-exists"></i></span>   
	    </div>
	    
	      	
	        <button type="submit" class="button"><span>ADD</span></button>
	     
	     </div>
	    </form:form> 
	<div class="table-responsive">          
  		<table class="table table-striped" border="1" >
  		<tr class="success">
  			<th>ProductID</th>
  			<th>ProductName</th>
  			<th>Description</th>
  			<th>Price</th>
  			<th>Stock</th>
  			<th>Supplier</th>
  			<th>Category</th>
  			<th>Image</th>
  			</tr>  
			<c:forEach items="${productList}" var="productList">
			<tr>
				<td>${productList.productID}</td>
				<td>${productList.productName}</td>
				<td>${productList.description}</td>
				<td>${productList.price}</td>
				<td>${productList.stock}</td>
				<td>${productList.supplierID}</td>
				<td>${productList.categoryID}</td>
				<td><img src="${pageContext.request.contextPath}/resources/${productList.imageName}" height=100 width=200></td>
				</tr> 

		</c:forEach>  
		</table>
	





</body>
</html>