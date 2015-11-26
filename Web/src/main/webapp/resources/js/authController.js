var app = angular.module('statelessApp', ['ngResource', 'ngRoute']).factory('TokenStorage', function () {
    var storageKey = 'auth_token';
    return {
        store: function (token) {
            return localStorage.setItem(storageKey, token);
        },
        retrieve: function () {
            return localStorage.getItem(storageKey);
        },
        clear: function () {
            return localStorage.removeItem(storageKey);
        }
    };
}).factory('TokenAuthInterceptor', function ($q, TokenStorage) {
    return {
        request: function (config) {
            var authToken = TokenStorage.retrieve();
            if (authToken) {
                config.headers['X-AUTH-TOKEN'] = authToken;
            }
            return config;
        },
        responseError: function (error) {
            if (error.status === 401 || error.status === 403) {
                TokenStorage.clear();
            }
            return $q.reject(error);
        }
    };
}).config(function ($httpProvider) {
    $httpProvider.interceptors.push('TokenAuthInterceptor');
});

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/coordinator', {
            templateUrl: 'templates/bdSummaryPage.html',
            controller: 'BloodDriveCtrl'
        }).
        when('/coordinator/:bloodDriveId', {
            templateUrl: 'templates/bdDetailPage.html',
            controller: 'BloodDriveCtrl'
        }).
        otherwise({
            redirectTo: '/'
        });
    }]);

app.factory('Authentication', function() {
    var data = {
        firstName: '',
        lastName: '',
        role: ''
    };

    return {
        getFirstName: function () {
            return data.firstName;
        },
        setFirstName: function (firstName) {
            data.firstName = firstName;
        },
        getLastName: function () {
            return data.lastName;
        },
        setLastName: function (lastName) {
            data.lastName = lastName;
        },
        getRole: function() {
            return data.role;
        },
        setRole: function(role) {
            data.role = role;
        }
    };
});

app.controller('AuthCtrl', function ($scope, $http, TokenStorage, $window, $location, Authentication) {
    $scope.authenticated = false;
    $scope.token;

    function processLogin() {
        $scope.role = $scope.token.roles[0].toLowerCase();

        if ($scope.role == "donor") {
            $scope.logout();
            return;
        }

        $scope.authenticated = true;
        $scope.displayName = $scope.user.firstName + " " + $scope.user.lastName;

        switch ($scope.role) {
            case "coordinator":
                $location.url('/coordinator');
                Authentication.setRole('coordinator');
                break;

            case "manager":
                break;

            case "nurse":
                break;
        }
    };

    $scope.init = function () {
        $http.get('/api/users/current').success(function (user) {
            if (user.username !== 'anonymousUser') {
                $scope.token = JSON.parse(atob(TokenStorage.retrieve().split('.')[0]));
                $scope.user = user;
                processLogin();
            }
        });
    };

    $scope.login = function () {
        $http.post('/api/login', {
            username: $scope.username,
            password: $scope.password
        }).success(function (result, status, headers) {
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
        $location.url('/');
    };
});