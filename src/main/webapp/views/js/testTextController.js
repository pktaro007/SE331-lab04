'use strict';

/* Controller */
var testTextApp = angular.module('testTextApp',[]);
testTextApp.controller('testTextAppController',['$scope','$http','$sce',
    function($scope,$http,$sce){
        $scope.inputText='';
        $scope.addNewText = function(){
            $http.post('/temp',$scope.inputText
                ).success(function(data){
                    $scope.resultText = $sce.trustAsHtml(data);
                    $scope.inputText='';
                })
        }
    }]);