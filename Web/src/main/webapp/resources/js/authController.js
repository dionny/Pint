var app = angular.module('statelessApp', ['ngResource', 'ngRoute', 'ui.bootstrap']).factory('TokenStorage', function () {
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
}).factory('TokenAuthInterceptor', function ($q, $location, TokenStorage) {
    return {
        request: function (config) {
            var authToken = TokenStorage.retrieve();
            if (authToken) {
                config.headers['X-AUTH-TOKEN'] = authToken;
            } else {
                $location.path("/");
            }
            return config;
        },
        responseError: function (error) {
            //if (error.status === 401 || error.status === 403) {
            //    TokenStorage.clear();
            //}
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

app.factory('Authentication', function () {
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
        getRole: function () {
            return data.role;
        },
        setRole: function (role) {
            data.role = role;
        }
    };
});

app.controller('AuthCtrl', function ($scope, $http, TokenStorage, $window, $location, Authentication, Logger) {
    $scope.authenticated = false;
    $scope.token;

    Logger.log('authCtrl: load');

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
                Authentication.setRole('coordinator');

                if ($location.absUrl().indexOf('/coordinator/') === -1) {
                    Logger.log('authCtrl: changing url to /coordinator');
                    $location.url('/coordinator');
                }
                Logger.log('authCtrl: setting role to coordinator');
                break;

            case "manager":
                break;

            case "nurse":
                break;
        }
    };

    $scope.init = function () {
        Logger.log('authCtrl: init');
        $http.get('/api/users/current').success(function (user) {
            if (user.username !== 'anonymousUser') {
                $scope.token = JSON.parse(atob(TokenStorage.retrieve().split('.')[0]));
                $scope.user = user;
                processLogin();
            }
        });
    };

    $scope.login = function () {
        Logger.log('authCtrl: login');
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