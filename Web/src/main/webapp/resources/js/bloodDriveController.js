/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('NurseAssignmentCtrl', function ($scope, $resource, $routeParams, $uibModalInstance, nurses) {
        $scope.nurses = nurses;

        $scope.rowClick = function (nurse) {
            console.log(nurse);
            nurse.selected = !nurse.selected;
            console.log('test');
        };

        $scope.toggleObjSelection = function ($event) {
            $event.stopPropagation();
        };

        $scope.ok = function () {
            $uibModalInstance.close(_.where($scope.nurses, {'selected': true}));
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    });

angular.module('statelessApp')
    .controller('BloodDriveCtrl', function ($scope, $resource, $routeParams, $uibModal, $log,
                                            BloodDrive, Authentication) {
        console.log('bloodDriveCtrl: load');
        $scope.load = function () {
            if (!Authentication.getRole()) {
                return;
            }

            console.log(Authentication.getRole());

            $scope.bloodDriveId = $routeParams.bloodDriveId;

            if ($scope.bloodDriveId) {
                console.log('bloodDriveCtrl: getting details');
                $scope.bloodDrive = BloodDrive.getBloodDrive($scope.bloodDriveId);
                $scope.assignedNurses = BloodDrive.getAssignedNurses($scope.bloodDriveId);
                $scope.unassignedNurses = BloodDrive.getUnassignedNurses($scope.bloodDriveId);
                console.log('bloodDrive = ', $scope.bloodDrive);
                console.log('assignedNurses = ', $scope.assignedNurses);
                console.log('unassignedNurses = ', $scope.unassignedNurses);
            }

            if (!$scope.bloodDriveId) {
                console.log('bloodDriveCtrl: getting all');
                $scope.bloodDrives = BloodDrive.getBloodDrives();
                console.log($scope.bloodDrives);
            }
        };

        $scope.open = function () {
            var modalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'templates/nurseAssignModal.html',
                controller: 'NurseAssignmentCtrl',
                size: 'lg',
                resolve: {
                    nurses: function () {
                        _.forEach($scope.unassignedNurses, function (nurse) {
                            nurse.selected = false;
                        });
                        return $scope.unassignedNurses;
                    }
                }
            });

            modalInstance.result.then(function (selectedNurses) {
                var selected = _.pluck(selectedNurses, 'userId');
                console.log(selected);
                BloodDrive.assignNurses($scope.bloodDriveId, selected)
                    .then(function () {
                            swal("Success!", "Nurses were successfully assigned.", "success")
                        },
                        function () {
                            swal("Oops...", "Something went wrong!", "error");
                        });

            }, function () {
                //$log.info('Modal dismissed at: ' + new Date());
            });
        };

        $scope.$watch(function () {
            return Authentication.getRole();
        }, $scope.load, true);
    });