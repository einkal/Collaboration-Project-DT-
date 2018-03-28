myApp.controller("BlogController",function($scope,$http,$location)
{
	$scope.blog={"blogName":'',"blogContent":'',"createDate":'',"likes":0,"userName":'',"status":''}
	$scope.blogdata;
	$scope.insertBlog=function()
	{
		console.log('Entering into insertBlog Method');
		$http.post('http://localhost:8081/FreyaMiddleWare/addBlog',$scope.blog)
		.then(fetchAllBlog(),function(response)
				{
					fetchAllBlog();	
					console.log('Status Text:'+response.statusText);
				});
		fetchAllBlog();	
	};
			function fetchAllBlog()
			{
				console.log('Fetching All Blog');
				$http.get('http://localhost:8081/FreyaMiddleWare/listBlogs')
				.then(function(response)
						{
							$scope.blogdata=response.data;
						}
				
				
				);
			}
			
		$scope.deleteBlog=function(blogID)
		{
			console.log('Entering into delete blog method');
			$http.get('http://localhost:8081/FreyaMiddleWare/deleteBlog/'+blogID)
			.then(fetchAllBlog(),function(response)
			{
				console.log('Deleted');
				fetchAllBlog();	
				$location.path("/Blog");
			});
			fetchAllBlog();	

		}
		
		$scope.incrementLikes=function(blogID)
		{
			console.log('Entering into increment likes method');
			$http.get('http://localhost:8081/FreyaMiddleWare/incrementLikes/'+blogID)
			.then(fetchAllBlog(),function(response)
			{
				console.log('incremented');
				fetchAllBlog();	
				$location.path("/Blog");
			});
			fetchAllBlog();	
		}
			
		fetchAllBlog();	
			
});           




