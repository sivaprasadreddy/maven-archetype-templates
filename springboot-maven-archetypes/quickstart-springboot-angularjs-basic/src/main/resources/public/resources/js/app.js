
angular.module('myApp', ['ngRoute','ngResource'])


.config(['$routeProvider','$locationProvider',
        function($routeProvider, $locationProvider) {
          $routeProvider
          	.when('/home', {
              templateUrl: 'templates/home.html',
              controller: 'HomeController'
          	}).
            when('/contact', {
              templateUrl: 'templates/contact.html',
              controller: 'ContactController'
            }).
            when('/about', {
            	templateUrl: 'templates/about.html',
                controller: 'AboutController'
            })
           
            .otherwise({
            	redirectTo: 'home'
            });
          
          //$locationProvider.html5Mode(true); //Remove the '#' from URL.
}])


.run(['$rootScope', '$location', function ($rootScope, $location) {
	
    $rootScope.$on('$routeChangeStart', function (event, next, current) {
    	//console.log($location.path());
    	//console.log(next.templateUrl +":"+current.templateUrl );
    	//var currentNavLink = '/home';
    	$rootScope.currentNavLink=$location.path();
    });

}]);



