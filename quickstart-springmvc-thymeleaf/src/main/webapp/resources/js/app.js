
var myApp = angular.module('myApp',['ngRoute','myApp.controllers']);

myApp.config(['$routeProvider', '$httpProvider',
        function ($routeProvider, $httpProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'tmpls/home.html',
                    controller: 'HomeController'
                })
                .when('/myAccount', {
                    templateUrl: 'tmpls/myAccount.html',
                    controller: 'UserController'
                })
                .otherwise({
                	redirectTo: '/home'
                });

        }])
        .run(['$rootScope', '$location', '$http',
            function($rootScope, $location, $http) {
                $rootScope.$on('$routeChangeStart', function (event, next) {
                	if(!next.$$route){
                		$rootScope.currentPage = '/home';
                	} else {
                		$rootScope.currentPage = next.$$route.originalPath;
                	}
                });

        }]);
