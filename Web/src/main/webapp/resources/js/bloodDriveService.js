/**
 * Created by Dionny on 11/26/2015.
 */
angular.module('statelessApp')
    .factory('BloodDrive', function ($resource, $http, $q, Authentication) {
        return {
            getBloodDrives: function () {
                var BloodDrive = $resource('/api/' + Authentication.getRole()
                    + '/getBloodDrives');
                return BloodDrive.query();
            },
            getBloodDrive: function (id) {
                var BD = $resource('/api/' + Authentication.getRole() +
                    '/getBloodDriveById/:bdId',
                    {bdId: '@id'});
                return BD.get({bdId: id});
            },
            getAssignedNurses: function (id) {
                var AN = $resource('/api/' + Authentication.getRole() +
                    '/getNursesForBloodDrive/:bdId',
                    {bdId: '@id'});
                return AN.query({bdId: id});
            },
            getUnassignedNurses: function (id) {
                var UAN = $resource('/api/' + Authentication.getRole() +
                    '/getUnassignedNursesForBloodDrive/:bdId',
                    {bdId: '@id'});

                return UAN.query({bdId: id});
            },
            assignNurses: function (id, nurses) {
                return $http.post('/api/' + Authentication.getRole() + '/assignNurses/' + id, {
                    nurses: nurses
                });
            }
        }
    });