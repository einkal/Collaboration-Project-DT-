var myApp = angular.module("myApp", ["ngRoute"]);

myApp.config(function($routeProvider) {
  $routeProvider
   .when("/", {
	    templateUrl :"templates/home.html"	   
	  })
  .when("/Blog", {
    templateUrl : "c_blog/blog.html"
   
  })

  .when("/Friend", {
    templateUrl : "templates/friend.html"
   
  })
  
   .when("/Job", {
    templateUrl : "templates/job.html"
   
  })

  .otherwise({redirectTo: "/"});
});
