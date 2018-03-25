
var app = angular.module('myApp2', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'Ex3/view/home.html',
    controller : 'HomeController'
   
  })

  .when('/blog', {
    templateUrl : 'Ex3/view/blog.html',
    controller : 'BlogController'
   
  })

  .when('/friend', {
    templateUrl : 'Ex3/view/friend.html',
    controller : 'FriendController'
   
  })
  
   .when('/job', {
    templateUrl : 'Ex3/view/job.html',
    controller : 'JobController'
   
  })
  
   .when('/login', {
    templateUrl : 'Ex3/view/login.html',
    controller : 'LoginController'
   
  })
  
   .when('/logout', {
    templateUrl : 'Ex3/view/logout.html',
    controller : 'LogoutController'
   
  })

  .otherwise({redirectTo: '/'});
});

