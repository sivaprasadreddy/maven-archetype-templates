
var myApp = angular.module('myApp');

myApp.service('UtilService',['$rootScope', '$cookieStore', 'Notification',
	 function($rootScope, $cookieStore, Notification) 
	 {	
		 var self = this;
		 
		 self.fireInfoEvent = function(msg){
			 var message = {type: 'info', 'msg':msg};
         	 $rootScope.$emit('NotificationEvent', message);
		 };
		 
		 self.fireErrorEvent = function(msg){
			 var message = {type: 'error', 'msg':msg};
         	 $rootScope.$emit('NotificationEvent', message);
		 };
		 
		 self.notifyInfo = function(msg){
         	Notification.primary(msg);
		 };
		 
		 self.notifyError = function(msg){
         	 Notification.error(msg);
		 };
		 
	 }
]);

myApp.service('UserService',['$http', '$state', '$cookieStore', 
	 function($http, $state, $cookieStore) {
	
		var self = this;
			
		self.setUser = function(aUser){
			$cookieStore.put('authenticatedUser', aUser);
		};
		    
	    self.getUser = function(){
	    	return $cookieStore.get('authenticatedUser');
	    };
	    
	    self.isUserLoggedIn = function() {
	    	return $cookieStore.get('authenticatedUser') != null;
	    };
	    
	    self.logout = function() {
	    	$cookieStore.remove('authenticatedUser');
	    	$http.post('logout')
	    	.success(function(response){
	    		console.log('Successfully logged out on server');
	  	    });
	  	};  		 	
	 }
]);

myApp.service('PostsService',['$resource', '$http', 
     function($resource, $http){
		
	this.loadPosts = function(page, pageSize){
		var promise = $http.get('api/posts/?pageNo='+page+'&pageSize='+pageSize)
			.then(function(response){
				return response.data;
			});
		return promise;
	 };
	 
	 
	
	}
]);