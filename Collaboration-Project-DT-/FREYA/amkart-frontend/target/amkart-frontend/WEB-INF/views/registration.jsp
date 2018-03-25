<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIGN UP</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/AddEntities.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
 
</head>
<body>
<div class="container">
<%@ include file = "header.jsp" %> 
  <table class="table table-hover">

<form:form method="POST" action="registerUser" modelAttribute="user" id="userAddForm">
	  <h1>FILL UP YOUR DETAILS:</h1>
	 
	 <tr>
	 <td>
	  <!-- One "tab" for each step in the form: -->
	  <div class="col-xs-4">
	  <label for="email">EMAIIL:</label>
	    <p><form:input class="form-control" path="email" placeholder="Email.." name="email"/></p>
	  		<form:errors path="email"/>
		</div>		
	  
 <br>
 </td>
   </tr>
   <tr>
   <td>
	   <div class="col-xs-4">
		  <label for="name">NAME:</label>
	    <p><form:input class="form-control" path="name" placeholder="Name.." name="name"/></p>
	 		  	
	 		  		<form:errors path="name"/>
	 				
    </div>
    <br>
    </td>
    </tr>
    <tr>
    <td>
    <div class="col-xs-4">
	  <label for="name">PASSWORD:</label>
	    <p><form:input type="password" class="form-control" path="password" placeholder="Password.." name="password"/></p>
	 	  		
	 	  		<form:errors path="password"/>
	 	  		
    </div>
<br>
</td>
</tr>
<tr>
<td>
     <div class="col-xs-4">
   	  <label for="name">ADDRESS:</label>
	    <p><form:input class="form-control" path="address" placeholder="Address.." name="address"/></p>
			  		<form:errors path="address"/>
					
    </div>
    </td>
    </tr>
    <br>
    <tr>
    <td>
    <!-- One "tab" for each step in the form: -->
	  <div class="col-xs-4">
	  <label for="phone">PHONE:</label>
	    <p><form:input class="form-control" path="phone" placeholder="Phone.." name="phone"/></p>
								<form:errors path="phone"/>
				
	 
    </div>
    <br>
    </td>
    </tr>
    <tr>
    <td>
    <div style="text-align:center;">
        <button type="submit" class="button"><span>SIGN UP</span></button>
    </div>
     </td>
     </tr>
     
</form:form>
</table>
<%@ include file="footer.jsp"%> 

</div>
</body>
</html>
