/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('BloodDriveCtrl', function ($scope, $resource, $routeParams, BloodDrive, Authentication) {
        console.log('bloodDriveCtrl: load');
        $scope.load = function() {
            if(!Authentication.getRole()) {
                return;
            }

            console.log(Authentication.getRole());

            $scope.bloodDriveId = $routeParams.bloodDriveId;

            if ($scope.bloodDriveId) {
                console.log('bloodDriveCtrl: getting details');
                $scope.bloodDrive = BloodDrive.getBloodDrive($scope.bloodDriveId);
                $scope.assignedNurses = BloodDrive.getAssignedNurses($scope.bloodDriveId);
                $scope.unassignedNurses = BloodDrive.getUnassignedNurses($scope.bloodDriveId);
            }

            if (!$scope.bloodDriveId) {
                console.log('bloodDriveCtrl: getting all');
                $scope.bloodDrives = BloodDrive.getBloodDrives();
                console.log($scope.bloodDrives);
            }
        }

        $scope.$watch(function() {
            return Authentication.getRole();
        }, $scope.load, true);
    });