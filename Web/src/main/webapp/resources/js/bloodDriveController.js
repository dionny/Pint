/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('BloodDriveCtrl', function ($rootScope, $scope, $resource, $routeParams) {

        var BloodDrive = $resource('/api/coordinator/getBloodDrives');
        var BD = $resource('/api/coordinator/getBloodDriveById/:bdId', {bdId: '@id'});

        $scope.bloodDriveId = $routeParams.bloodDriveId;

        if ($scope.bloodDriveId) {
            $scope.bloodDrive = BD.get({bdId: $scope.bloodDriveId}, function () {
                //console.log($scope.bloodDrive);
            });
        }

        $scope.bloodDrives = BloodDrive.query(function () {
            //console.log($scope.bloodDrives);
        });
    });
    
    
   