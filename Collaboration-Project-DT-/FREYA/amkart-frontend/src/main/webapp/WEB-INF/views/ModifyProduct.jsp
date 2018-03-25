<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modify Product</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  </head>
<body>
<div class="container">
<%@ include file = "header.jsp" %>
	  <h1>MODIFY PRODUCT:</h1>
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
  			<th>EDIT</th>
  			<th>DELETE</th>
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
				<td><img src="${pageContext.request.contextPath}/resources/${productList.imageName}" class="img-responsive" alt="${productList.imageName}" height=100 width=200></td>
				<td><a class="btn btn-info" role="button" href="editProduct/${productList.productID}">Edit</a></td>  
				<td><a class="btn btn-info" role="button" href="deleteProduct/${productList.productID}">Delete</a></td>
				</tr> 

			</c:forEach>  
		 </table>
		 
		 <c:if test="${toEdit==true}">
		 	
		 <form:form method="POST" action="Save" modelAttribute="product" id="productAddForm">
		  <h1>MODIFY PRODUCT:</h1>
		   <div class="input-group">
	    <label for="productID">ID: ${productEdit.productID}</label>
	    <p><form:hidden class="form-control" path="productID" name="productID" value="${productEdit.productID}"/></p>
	  	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>   
    	</div>
		 	    
	    <div class="input-group">
		  <label for="productName">NAME:</label>
		    <p><form:input class="form-control" path="productName" name="productName" value="${productEdit.productName}"/></p>
		  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>   
	    </div>
	       
	      <div class="input-group">
		  <label for="description">DESCRIPTION:</label>
		    <p><form:input class="form-control" path="description" value="${productEdit.description}" name="description"/></p>
		  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>   
	    </div>   
	       
	       <div class="input-group">
		  <label for="price">PRICE:</label>
		    <p><form:input class="form-control" path="price" value="${productEdit.price}" name="price"/></p>
		  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>   
	    </div>
	       
	       
	        <div class="input-group">
		  <label for="stock">STOCK:</label>
		    <p><form:input class="form-control" path="stock" value="${productEdit.stock}" name="stock"/></p>
		  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>   
	    </div>
	     <div class="form-group">
	     
	    <label for="category">Select Category:</label>
        <form:select path="categoryID" class="form-control" id="category" name="category">
         <form:option value="${productEdit.categoryID}">${productEdit.categoryID}</form:option>
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
         <form:option value="${productEdit.supplierID}">${productEdit.supplierID}</form:option>
            <c:forEach items="${supplierList}" var="supplierList">
                
               <form:option value="${supplierList.supplierID}">
               		${supplierList.supplierName}
               </form:option>
                    
                   
            </c:forEach>
        </form:select>
	   </div>
	   		<div class="input-group">
			     <p><form:hidden class="form-control" path="imageName" name="imageName" value="${productEdit.imageName}"/></p>
			 </div>
	 `		<img src="${pageContext.request.contextPath}/resources/${productEdit.imageName}" class="img-responsive" alt="${productEdit.imageName}" height=100 width=200>
	        <button type="submit" class="button"><span>ADD</span></button>
	     
	     </div>
	    </form:form> 
		 
		 </c:if>
	</div>
</div>
</body>
</html>
