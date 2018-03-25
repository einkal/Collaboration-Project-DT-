
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="java">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
 </head>
<body>
 ${role}

<div class="container">
<%@ include file = "header.jsp" %> 
<div class="jumbotron text-center" style="background-color: #f4511e;color: #fff;">
  <h1>AMKART</h1> 
  <p>Delivering Happiness at your doorstep</p> 
  	<form class="form-inline">
    	<div class="input-group">
      	<input type="email" class="form-control" size="50" placeholder="Email Address" required>
      	<div class="input-group-btn">
        	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">Subscribe</button>
      	</div>
    	</div>
  	</form>
</div>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
	<div class="item peopleCarouselImg">
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/images/images1.jpg" alt="offer" class="img-responsive">
      	<div class="carousel-caption">
          <h3>SPRING OFFER</h3>
          <p>Shopping is always so much fun!</p>
        </div>
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/images2.jpg" alt="Offers" class="img-responsive">
		<div class="carousel-caption">
          <h3>DISCOUNT</h3>
          <p>Avail the maximum discount!</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/images/images3.jpg" alt="Offers" class="img-responsive">
        <div class="carousel-caption">
          <h3>HAPPY SHOPPING</h3>
          <p>Shop Anywhere.. Shop Anytime..</p>
      </div> 
     </div>
      </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</div>

   <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Subscription</h4>
        </div>
        <div class="modal-body">
          <p>You are subscribed t!!</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
 
</div>
  
<%@ include file = "footer.jsp" %> 

</body>

</html>
