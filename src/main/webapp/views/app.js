'use strict';

// Declare app level module which depends on views, and components
var labApp = angular.module('labApp', [
    'ngRoute',
    'testTextApp',
    'productMainController'
])
labApp.config(['$routeProvider',
  function($routeProvider) {
  $routeProvider.
      when('/addText',{
        templateUrl: 'template/addText.html',
        controller: 'testTextAppController'
      }).
      when('/addProduct',{
          templateUrl: 'template/editPerson.html',
          controller: 'addProductController'
      }).
      when('/editProduct/:id',{
          templateUrl: 'template/editPerson.html',
          controller: 'editProductController'
      }).
      when('/listProduct',{
          templateUrl: 'template/productList.html',
          controller: 'listProductController'
      }).
       otherwise({redirectTo: '/addText'});
}]);
