var controllers = angular.module('myApp.controllers',[]);

controllers.controller('HomeController',function($scope){
	
});

controllers.controller('UserController',function($scope, $http){
	$http.get('users/')
	.success(function(data){
		$scope.users = data;
	})
	.error(function(data){
		alert('Error');
	});
});
