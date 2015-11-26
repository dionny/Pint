var app = angular.module('statelessApp', ['ngResource']).factory('TokenStorage', function() {
	var storageKey = 'auth_token';
	return {		
		store : function(token) {
			return localStorage.setItem(storageKey, token);
		},
		retrieve : function() {
			return localStorage.getItem(storageKey);
		},
		clear : function() {
			return localStorage.removeItem(storageKey);
		}
	};
}).factory('TokenAuthInterceptor', function($q, TokenStorage) {
	return {
		request: function(config) {
			var authToken = TokenStorage.retrieve();
			if (authToken) {
				config.headers['X-AUTH-TOKEN'] = authToken;
			}
			return config;
		},
		responseError: function(error) {
			if (error.status === 401 || error.status === 403) {
				TokenStorage.clear();
			}
			return $q.reject(error);
		}
	};
}).config(function($httpProvider) {
	$httpProvider.interceptors.push('TokenAuthInterceptor');
});

app.controller('AuthCtrl', function ($scope, $http, TokenStorage) {
	$scope.authenticated = false;
	$scope.token;

	function processLogin() {
		$scope.role = $scope.token.roles[0];

		if($scope.role.toLowerCase() == "donor") {
			$scope.logout();
			return;
		}

		$scope.authenticated = true;
		$scope.displayName = $scope.user.firstName + " " + $scope.user.lastName;

		switch($scope.role.toLowerCase()) {
			case "coordinator":
				$scope.roleTemplate = "templates/coordinator.html";
				break;

			case "manager":
				$scope.roleTemplate = "templates/manager.html";
				break;

			case "nurse":
				$scope.roleTemplate = "templates/nurse.html";
				break;

			default:
				$scope.roleTemplate = "templates/coordinator.html";
		}
	};

	$scope.init = function () {
		$http.get('/api/users/current').success(function (user) {
			if(user.username !== 'anonymousUser'){
				$scope.token = JSON.parse(atob(TokenStorage.retrieve().split('.')[0]));
				$scope.user = user;
				console.log($scope.user);
				processLogin();
			}
		});
	};

	$scope.login = function () {
		$http.post('/api/login', { username: $scope.username, password: $scope.password }).success(function (result, status, headers) {
			TokenStorage.store(headers('X-AUTH-TOKEN'));
			$scope.init();
		});  
	};

	$scope.logout = function () {
		// Just clear the local storage
		TokenStorage.clear();
		$scope.username = "";
		$scope.password = "";
		$scope.authenticated = false;
		$scope.user = null;
		$scope.token = null;
		$scope.displayName = null;
		$scope.roleTemplate = null;
	};
});