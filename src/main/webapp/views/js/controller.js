'use strict';

/* Controller */
var studentApp = angular.module('studentAppMainControllers',[]);

studentApp.controller('getStudentFromUrlController',['$scope','$http',
    function($scope,$http){
        $scope.students = {};
        $http.get('http://54.169.160.61:8080/lab02server/student/allstudents.json').success(function(data) {
            $scope.students = data;
        });


    }]);

studentApp.controller('getStudentFromGPAController',['$scope','$http',
    function($scope,$http){
        $scope.students = {};
        $scope.gpa = '0';
        $scope.getStudentFromGPA = function(){
            $http.get('http://localhost:8080/gpa.json',
                {params:{gpa:$scope.gpa}}).success(function(data){
                    $scope.students = data;
                })
        }
        $scope.getStudentFromGPA();

    }]);

