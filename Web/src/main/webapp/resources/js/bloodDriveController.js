/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('BloodDriveCtrl', function ($scope, $resource, $routeParams, Authentication) {
        var BloodDrive = $resource('/api/' + Authentication.getRole() + '/getBloodDrives');
        var BD = $resource('/api/' + Authentication.getRole() + '/getBloodDriveById/:bdId', {bdId: '@id'});

        $scope.bloodDriveId = $routeParams.bloodDriveId;

        if ($scope.bloodDriveId) {
            $scope.bloodDrive = BD.get({bdId: $scope.bloodDriveId}, function () {
                //console.log($scope.bloodDrive);
            });
        }

        if(Authentication.getRole() && !$scope.bloodDriveId) {
            $scope.bloodDrives = BloodDrive.query(function () {
                //console.log($scope.bloodDrives);
            });
        }
    });
    
    
   