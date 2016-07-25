
var myApp = angular.module('myApp');

myApp.controller('LoginController', 
	[ '$rootScope','$scope', '$http', '$state','$location','$cookies', 'UserService','UtilService', 
     function ($rootScope, $scope,$http, $state, $location, $cookies, UserService, UtilService) {
		$scope.loginUser = {};
		
		$scope.authenticateUser = function(){
			
			$scope.loginFailed = false;
			$http({
			    method: 'POST',
			    url: 'authenticate',
			    data: $.param($scope.loginUser),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			})
			
			.then(function(response) {
				//UtilService.notifyInfo('Login successful');
				UserService.setUser(response.data);
				$state.transitionTo('home');
			},function(response) {
				console.log('Login failed');
				$scope.loginFailed = true;
	        	UtilService.notifyError('Invalid Login Credentials');
			});
		};
		
	}
]);

myApp.controller('HomeController', 
   [ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
   function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) {

	$scope.loadPosts = function(page){
		var pageSize = 5;
		
		PostsService.loadPosts(page, pageSize)
			.then(
					function(data, status, headers, config){
						var posts = data.posts;
						angular.forEach(posts, function(post) {
							post.contentPreview = $sce.trustAsHtml(post.contentPreview);
						});
						$scope.posts = posts;
						$scope.postsPagination = {
								hasNextPage : data.hasNextPage,
								hasPrevPage: data.hasPrevPage,
								currentPage: data.currentPage
						};
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in loading posts');
					}
			);
	};
	
	$scope.loadPosts(0);
	
}]);


myApp.controller('PostController', 
	[ '$scope','$http', '$state','$stateParams', '$location', '$sce','UtilService',
    function ($scope, $http, $state, $stateParams, $location,$sce, UtilService) {
	
	$scope.loadPost = function(){
		$http.get('api/posts/'+$stateParams.postId)
		.success(function(data, status, headers, config){
			$scope.post = data;
			$scope.post.content = $sce.trustAsHtml($scope.post.content);
			var comments = data.comments;
			angular.forEach(comments, function(comment){
				comment.content = $sce.trustAsHtml(comment.content);
			});
			$scope.post.comments=comments;
		})
		.error(function(data, status, headers, config){
			UtilService.notifyError('Problem in loading post details');
		})
		;
	}

	$scope.loadPost();
	$scope.newComment = {};
	
	$scope.createComment = function(){
		$scope.newComment.content = $('#contentEditor').code();
		$http.post('api/posts/'+$stateParams.postId+"/comments", $scope.newComment)
		.success(function(data, status, headers, config){
			UtilService.notifyInfo('Comment saved successfully');
			
			$scope.newComment = {};
			$('#contentEditor').code('');
			$scope.loadPost();
		})
		.error(function(data, status, headers, config){
			UtilService.notifyError('Problem in saving comment');
		})
		;
	};
}]);



myApp.controller('NewPostController', [ '$scope','$http', '$stateParams', '$location', 'UtilService',
    function ($scope, $http, $stateParams, $location, UtilService) {
	
	$scope.newPost = {};
	
	$scope.createPost = function(){
		$scope.newPost.content = $('#contentEditor').code();
		$http.post('api/admin/posts/', $scope.newPost)
		.success(function(data, status, headers, config){
			UtilService.notifyInfo('Post saved successfully');
			$scope.newPost = {};
			$('#contentEditor').code('');
		})
		.error(function(data, status, headers, config){
			UtilService.notifyError('Problem in saving post');
		});
	}

}]);


myApp.controller('AdminController',
	[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) 
        {
            console.log('admin controller');
			

		}
    ]
);

myApp.controller('AdminTagsController',
	[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) 
        {
            console.log('AdminTagsController');
            $scope.tags = [];
			
            $scope.loadTags = function()
			{
				$http.get('api/tags')
				.success(function(data, status, headers, config){
					$scope.tags = data;
				})
				.error(function(data, status, headers, config){
					UtilService.notifyError('Problem in loading tags');
				});
			}
            $scope.newTag = {};
            
            $scope.createTag = function()
			{
				$http.post('api/admin/tags', $scope.newTag)
				.success(function(data, status, headers, config){
					UtilService.notifyInfo('Tag saved successfully');
					$scope.loadTags();
					$scope.newTag = {};
				})
				.error(function(data, status, headers, config){
					UtilService.notifyError('Problem in saving tag');
				});
			}
            
			$scope.loadTags();

		}
    ]
);

myApp.controller('AdminEmailSubscribersController',
		[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
			function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService) 
	        {
	            console.log('AdminEmailSubscribersController');
	            
	            $scope.subscribers = [];
				
	            $scope.loadSubscribers = function()
				{
					$http.get('api/admin/emailSubscribers')
					.success(function(data, status, headers, config){
						$scope.subscribers = data;
					})
					.error(function(data, status, headers, config){
						UtilService.notifyError('Problem in loading subscribers');
					});
				}
	            $scope.newSubscriber = {};
	            
	            $scope.addSubscriber = function()
				{
					$http.post('api/emailSubscribers', $scope.newSubscriber)
					.success(function(data, status, headers, config){
						UtilService.notifyInfo('Subscriber added successfully');
						$scope.loadSubscribers();
						$scope.newSubscriber = {};
					})
					.error(function(data, status, headers, config){
						UtilService.notifyError('Problem in adding subscriber');
					});
				}
	            
				$scope.loadSubscribers();

			}
	    ]
	);

myApp.controller('AdminPostsController', 
		[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		   function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService)
    {
		$scope.loadPosts = function(page){
			var pageSize = 5;
			
			PostsService.loadPosts(page, pageSize)
				.then(
						function(data, status, headers, config){
							var posts = data.posts;
							angular.forEach(posts, function(post) {
								post.contentPreview = $sce.trustAsHtml(post.contentPreview);
							});
							$scope.posts = posts;
							$scope.postsPagination = {
									hasNextPage : data.hasNextPage,
									hasPrevPage: data.hasPrevPage,
									currentPage: data.currentPage
							};
						},
						function(data, status, headers, config){
							UtilService.notifyError('Problem in loading posts');
						}
				);
		};
		
		$scope.loadPosts(0);
		
		$scope.editPost = function(postId)
		{
			alert('edit post :'+postId);
		}
		$scope.deletePost = function(postId)
		{
			var r = confirm("Are you sure to delete the post?");
			if (r == true) {
				$http.delete('api/admin/posts/'+postId)
				.then(
					function(data, status, headers, config){
						UtilService.notifyInfo('Post deleted successfully');
						$scope.loadPosts(0);
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in deleteing post');
					}
				);
			}
		}
		$scope.sharePost = function(postId)
		{
			alert('share post :'+postId);
		}
		
	}
]);

myApp.controller('AdminCommentsController', 
		[ '$scope', '$rootScope', '$http', '$location','$sce', 'PostsService','UtilService',
		   function ($scope, $rootScope, $http, $location, $sce,PostsService, UtilService)
    {
		$scope.loadComments = function(page){
			var pageSize = 5;
			
			$http.get('api/admin/comments')
				.then(
						function(data, status, headers, config){
							var comments = data.data.comments;
							angular.forEach(comments, function(comment) {
								//comment.contentPreview = $sce.trustAsHtml(comment.contentPreview);
							});
							$scope.comments = comments;
							$scope.commentsPagination = {
									hasNextPage : data.data.hasNextPage,
									hasPrevPage: data.data.hasPrevPage,
									currentPage: data.data.currentPage
							};
						},
						function(data, status, headers, config){
							UtilService.notifyError('Problem in loading comments');
						}
				);
		};
		
		$scope.loadComments(0);
		
		$scope.checkAll = function () {
	        if ($scope.selectedAll) {
	            $scope.selectedAll = true;
	        } else {
	            $scope.selectedAll = false;
	        }
	        angular.forEach($scope.comments, function (comment) {
	        	comment.Selected = $scope.selectedAll;
	        });
	    };
	    
	    $scope.deleteSelectedComments = function()
		{
	    	var commentIds = [];
	    	angular.forEach($scope.comments, function (comment) {
	        	if(comment.Selected){
	        		commentIds.push(comment.id);
	        	}
	        });
	    	
	    	if(commentIds.length < 1){
	    		alert('Please select the comments to be deleted');
	    		return;
	    	}
	    	var r = confirm("Are you sure to delete the comments?");
			if (r == true) {
				$http.delete('api/admin/comments?commentIds='+commentIds)
				.then(
					function(data, status, headers, config){
						UtilService.notifyInfo('Comments deleted successfully');
						$scope.loadComments(0);
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in deleteing comments');
					}
				);
			}
		}
	    
		$scope.deleteComment = function(commentId)
		{
			var r = confirm("Are you sure to delete the comment?");
			if (r == true) {
				$http.delete('api/admin/comments/'+commentId)
				.then(
					function(data, status, headers, config){
						UtilService.notifyInfo('Comment deleted successfully');
						$scope.loadComments(0);
					},
					function(data, status, headers, config){
						UtilService.notifyError('Problem in deleteing comment');
					}
				);
			}
		}
		
		
	}
]);