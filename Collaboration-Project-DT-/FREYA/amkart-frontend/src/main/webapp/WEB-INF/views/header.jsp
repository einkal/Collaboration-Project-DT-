
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>AMKART</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
	img  
	{
    float:left;
	}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="${pageContext.request.contextPath}/index">
    <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Amkart" height=50 width=120>
      </a>
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
      
    </div>
  
    <br>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
          
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin<span class="caret"></span></a>
          <ul class="dropdown-menu"> 
            <li><a href="${pageContext.request.contextPath}/AddEntities">Add Entities</a></li>
            <li><a href="${pageContext.request.contextPath}/ModifySupplier">Modify Supplier</a></li>
            <li><a href="${pageContext.request.contextPath}/ModifyProduct">Modify Product</a></li>
            
          </ul>
        </li>
       
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">PRODUCTS<span class="caret"></span></a>
        <ul class="dropdown-menu">
        	<c:forEach items="${categoryList}" var="categoryList">
          <li><a href="${pageContext.request.contextPath}/showCategory/${categoryList.categoryID}">${categoryList.categoryName}</a></li>
          </c:forEach>
        </ul>
      </li> 
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:if test="${pageContext.request.userPrincipal.name!=null}">
          <li><a href="${pageContext.request.contextPath}/showUserDetails">My Details</a></li>
          <li><a href="${pageContext.request.contextPath}/showOrderDetails">My Orders</a></li>
          </c:if>
          <li><a href="${pageContext.request.contextPath}/ContactUs">Contact Us</a></li>
        </ul>
      </li>
    </ul>

     
    
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${pageContext.request.userPrincipal.name==null}">
      <li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/goToLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
  
    <c:if test="${pageContext.request.userPrincipal.name!=null}">
    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    <li>
   
    <a href="${pageContext.request.contextPath}/getCart">My Cart
         <span class="glyphicon glyphicon-shopping-cart"></span>
    
    </a>
   <a role="button" href="${pageContext.request.contextPath}/showAllProducts">List  All Product
   <span class="glyphicon glyphicon-eye-open"></span>
   </a>
    </li>
    </c:if>
    </ul>
    <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/searchCategory">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
             <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    </div>
  </div>
</nav>

      
 </body>

</html>
