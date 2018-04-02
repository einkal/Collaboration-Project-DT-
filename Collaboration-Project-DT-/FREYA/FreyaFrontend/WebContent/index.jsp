<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <title></title>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
  	<link href="Styles.css" rel="stylesheet" />
  	<script src="js/app.js"></script>
  	<script src="c_blog/BlogController.js"></script>
  	  	<script src="c_user/UserController.js"></script>
  	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>




<style>

item {

	height: 100%;

	width: 100%;

}



footer {

	position: fixed;

	left: 0;

	bottom: 0;

	width: 100%;

	background-color: black;

	color: white;

	text-align: center;

}

</style>



</head>

<body ng-app="myApp">



	<div class="container-fluid">

		<div class="row">

			<div class="col-md-12">

				<nav class="navbar navbar-inverse" role="navigation">

					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse"

							data-target="#bs-example-navbar-collapse-1">

							<span class="sr-only">Toggle navigation</span><span

								class="icon-bar"></span><span class="icon-bar"></span><span

								class="icon-bar"></span>

						</button>

						<a class="navbar-brand" href="#/">Freya</a>

					</div>



					<div class="collapse navbar-collapse"

						id="bs-example-navbar-collapse-1">

						<ul class="nav navbar-nav">

							<li class="active"><a href="#/Home">Home</a></li>

							<li

								ng-hide="currentUser.role=='ROLE_USER'||currentUser.role=='ADMIN'"><a

								href="#/Login">Login</a></li>

							<li

								ng-hide="currentUser.role=='ROLE_USER'||currentUser.role=='ADMIN'"><a href="#/Blog">Blog</a></li>

						</ul>

						<ul class="nav navbar-nav navbar-right">

							<li

								ng-hide="currentUser.role=='USER'||currentUser.role=='ADMIN'"><a href="#/Register">Register</a></li>

							<li

								ng-hide="currentUser.role=='USER'||currentUser.role=='ADMIN'"><a href="#/AboutUs">AboutUs</a></li>

							<li

								ng-hide="currentUser.role=='USER'||currentUser.role=='ADMIN'"><a href="#/ContactUs">ContactUs</a></li>

						</ul>

					

					<div class="nav navbar-nav navbar-right"

						ng-hide="currentUser==undefined">

					<ul class="nav navbar-nav">

					<li> <font color="white">Welcome {{currentUser.userName}} </font></li>
					<form ng-controller="UserController"><input type="submit" value="LogOut" ng-click="logout()" class="btn btn-info"></form> 

					</ul>

					</div></div>

				</nav>

			</div>

		</div>

		<div ng-view></div>

	</div>

	<footer>

		<div id="footer">

			<div class="container">

				<div class="bottom-bar">

					Copyright &copy; Freya 
					All Rights Reserved © 2018 


				</div>

			</div>

		</div>

	</footer>

</body>



</html>