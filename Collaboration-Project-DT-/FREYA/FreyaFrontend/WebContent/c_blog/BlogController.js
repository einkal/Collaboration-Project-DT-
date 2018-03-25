myApp.controller("BlogController",function($scope,http,$location)
{
	$scope.blog={"blogName":'',"blogContent":'',"createDate":'',"likes":0,"userName":'',"status":''}
	$scope.insertBlog=function()
	{
		console.log('Enter into insertBlog Method');
		$http.post('http://localhost:8081/FreyaMiddleWare/addBlog',$scope.blog)
		.then(function(response)
				{
					console.log('Status Text:'+response.statusText);
				});
	};
	
});           




