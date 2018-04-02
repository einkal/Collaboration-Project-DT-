var myApp = angular.module("myApp", [ 'ngRoute',,'ngCookies']);
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
.when("/Login", {
    templateUrl : "c_user/login.html"
   
  })
  .when("/Logout", {
    templateUrl : "c_user/logout.html"
   
  })
  .when("/UserHome", {
    templateUrl : "c_user/userHome.html"
   
  })
  .when("/UpdateProfilePic", {
    templateUrl : "c_user/UpdateProfile.html"
   
  })
  .when("/Register", {
    templateUrl : "c_user/register.html"
   
  })
  .otherwise({redirectTo: "/"});
});
myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.username);
				console.log($rootScope.currentUser.role);
				}
		});