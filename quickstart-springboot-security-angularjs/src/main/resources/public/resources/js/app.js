
var myApp = angular.module('myApp',['ui.router','ngResource','ngCookies','ngSanitize','ui-notification']);


myApp.factory('responseObserver',
  function responseObserver($q, $window, $rootScope) {
	
	return {
        request: function (config) {
            return config || $q.when(config);
        },
        requestError: function(request){
            return $q.reject(request);
        },
        response: function (response) {
            return response || $q.when(response);
        },
        responseError: function (response) {
            if (response && response.status === 412) {
            	var message = {type: 'error', 'msg':'Problem in processing your request.'};
            	$rootScope.$emit('NotificationEvent', message);
            	$rootScope.logout();
            }
            if (response && response.status === 401) {
            	var message = {type: 'error', 'msg':'Invalid Login Credentials or Session Expired.'};
            	$rootScope.$emit('NotificationEvent', message);
            	$rootScope.logout();
            }
            return $q.reject(response);
        }
    };
    
});


myApp.config(function($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {
	$httpProvider.interceptors.push('responseObserver');

	$stateProvider
	.state('login', {
		url: '/login',
		templateUrl: 'templates/login.html', 
  		controller: 'LoginController',
  		access: 'public'
	})
	.state('home', {
		url: '/home',
		templateUrl: 'templates/home.html', 
  		controller: 'HomeController',
  		access: 'public'
	})
	.state('newpost', {
		url: '/newpost',
		templateUrl: 'templates/newpost.html', 
  		controller: 'NewPostController'
	})
	.state('viewpost', {
		 url: '/posts/:postId',
         templateUrl: 'templates/post.html',
         controller: 'PostController',
   		 access: 'public'
     })
	.state('admin', {
		url: '/admin',
		templateUrl: 'templates/admin.html',
		controller: 'AdminController'
	})
	.state('admin.posts', {
		url: '/posts',
		templateUrl: 'templates/admin/posts.html',
		controller: 'AdminPostsController'
	})
	.state('admin.comments', {
		url: '/comments',
		templateUrl: 'templates/admin/comments.html',
		controller: 'AdminCommentsController'
	})
	.state('admin.tags', {
		url: '/tags',
		templateUrl: 'templates/admin/tags.html',
		controller: 'AdminTagsController'
	})
	.state('admin.emailSubscribers', {
		url: '/emailSubscribers',
		templateUrl: 'templates/admin/emailSubscribers.html',
		controller: 'AdminEmailSubscribersController'
	})
	.state('admin.settings', {
		url: '/settings',
		templateUrl: 'templates/admin/settings.html',
		controller: 'AdminController'
	})
	.state('admin.statistics', {
		url: '/statistics',
		templateUrl: 'templates/admin/statistics.html',
		controller: 'AdminController'
	})
	;
	
	$urlRouterProvider.otherwise('/home');
})

.run(['$rootScope', '$state', '$timeout','UserService','UtilService',
    function ($rootScope, $state, $timeout, UserService, UtilService) {
	
	$rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
		//console.log(toState);
    	//console.log(toState.name);
		var access = toState.access;
		//console.log(toState.access);
    	if(access != 'public'){
    		if(UserService.isUserLoggedIn()){
    			$rootScope.currentNavLink=toState.name;
    		} else {
    			evt.preventDefault();
    			console.log('redirect to login');
    			$state.go("login");
    		}
    	}
		
    	//$rootScope.currentNavLink=toState.name;
	});
	
	$rootScope.$on('NotificationEvent', function (event, message) {
	  	  //console.log(message);
	  	  $rootScope.message = message;
	  	  if(message.type == 'error'){
	  		UtilService.notifyError(message.msg);
	  	  } else {
	  		UtilService.notifyInfo(message.msg);
	  	  }
	  	  
	  	  $timeout(function(){
	  		  delete $rootScope.message;
	  	  }, 3000);
	 });
	
	$rootScope.isUserLoggedIn = function(){
        return UserService.isUserLoggedIn();
	}
 
	$rootScope.logout = function()
	{
		console.log('Logging out..');
		UserService.logout();
		$state.transitionTo("login");
	}
	    
}])
;
