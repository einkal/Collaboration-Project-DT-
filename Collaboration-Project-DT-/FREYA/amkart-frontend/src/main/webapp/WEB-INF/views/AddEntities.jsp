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
  <h2>Welcome ${name}</h2>
  <p>To Add Supplier, Category or Product details, click on the respective tab. </p>
	
  <ul class="nav nav-tabs">
    <li><a href="${pageContext.request.contextPath}/AddEntities">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/getSupplier">Supplier</a></li>
    <li><a href="${pageContext.request.contextPath}/getCategory">Category</a></li>
    <li><a href="${pageContext.request.contextPath}/getProduct">Product</a></li>
  </ul>



  <div>
    <div class="well">${message}</div>
      <h1>Select the tabs accordingly!!<span class="label label-default">Add New Entities</span></h1>
    
    
      	
      	<c:if test="${isSupplierClicked == true}">
    		<c:import url="../views/AddSupplier.jsp" />  	
		
		</c:if>
	 
    
       ${isCategoryClicked}
    
    
      	
      	<c:if test="${isCategoryClicked == true}">
    		<c:import url="../views/AddCategory.jsp" />  	
		
		</c:if>
		
		
		
		 ${isProductClicked}
    
        	
      	<c:if test="${isProductClicked == true}">
    		<c:import url="../views/AddProduct.jsp" />  	
		</c:if>
	
    </div>
 
        <c:if test="${status!=null}">
    <script>
   $(function () {  
	   $('#myModal').modal('show');
   });
   </script>
   </c:if>
    		
  
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

      <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Status</h4>
      </div>
      <div class="modal-body">
        <p>${status}</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
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
