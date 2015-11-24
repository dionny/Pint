/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('CoordinatorCtrl', function ($rootScope, $scope, $http, $resource) {
        var BloodDrive = $resource('/api/coordinator/getBloodDrives');
        $scope.bloodDrives = BloodDrive.query();
    });