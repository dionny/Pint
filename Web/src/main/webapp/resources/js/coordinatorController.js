/**
 * Created by Dionny on 11/24/2015.
 */

angular.module('statelessApp')
    .controller('CoordinatorCtrl', function ($rootScope, $scope, $http, $resource) {
        var BloodDrive = $resource('/api/coordinator/getBloodDrives');
        var BD = $resource('/api/coordinator/getBloodDriveById/:bdId', {bdId:'@id'});
        
        $scope.coordinatorTemplate = "templates/bdSummaryPage.html";
        
        $scope.bloodDrives = BloodDrive.query(function() {
        	console.log($scope.bloodDrives);
        });
        
        $scope.chooseBloodDrive = function(id) {
        
        $scope.bloodDrive=BD.get({bdId:id}, function(){
        	console.log($scope.bloodDrive);
        });
        
        console.log("hello world");
       // console.log(id);
        	$scope.coordinatorTemplate = "templates/bdDetailPage.html";
        };
        
        
    });
    
    
   