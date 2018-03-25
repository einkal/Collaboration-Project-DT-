 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Modify Supplier</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  </head>
<body>
<div class="container">
<%@ include file = "header.jsp" %>
	  <h1>MODIFY SUPPLIER:</h1>
	     
     <div class="table-responsive">          
  		<table class="table table-striped" border="1" >
  		<tr class="success"><th>SupplierID</th><th>SupplierName</th><th>EDIT</th><th>DELETE</th></tr>  
			<c:forEach items="${supplierList}" var="supplierList">
			<tr>
			<td>${supplierList.supplierID}</td>
			<td>${supplierList.supplierName}</td>
			<td><a class="btn btn-info" role="button" href="editSupplier/${supplierList.supplierID}">Edit</a></td>  
			<td><a class="btn btn-info" role="button" href="deleteSupplier/${supplierList.supplierID}">Delete</a></td>
			</tr> 

		</c:forEach>  
		</table>
		<c:if test="${toEdit==true}">
		<form:form method="POST" action="Save" modelAttribute="supplier">
	  <h1>MODIFY SUPPLIER'S DETAILS:</h1>
	 
	  <div class="input-group">
	    <label for="supplierID">ID: ${supplierEdit.supplierID}</label>
	    <p><form:hidden class="form-control" path="supplierID" name="supplierID" value="${supplierEdit.supplierID}"/></p>
	  	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>   
    	</div>
    
    	<div class="input-group">
	 	 <label for="supplierName">NAME:</label>
	    <p><form:input class="form-control" path="supplierName" name="supplierName" value="${supplierEdit.supplierName}"/></p>
	  	<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>   
   	 </div>
   	 
       <button type="submit" class="button"><span>CONFIRM</span></button>
     
   
		
		</form:form>
		
		</c:if>
		
		
		
		</div> 

</div>
</body>
</html>
