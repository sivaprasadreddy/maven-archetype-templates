var myApp = angular.module('myApp');

myApp.controller('HomeController', [ '$scope', '$http', function ($scope, $http) {
	
	$http.get('persons/')
		.success(function(data){
			$scope.persons = data;
		});
}]);


myApp.controller('ContactController', [ '$scope', function ($scope) {
	
	
	
	}
]);

myApp.controller('AboutController', [ '$scope', function ($scope) {
	
	
}]);
