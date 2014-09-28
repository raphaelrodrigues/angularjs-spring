'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ["ngSanitize","ngRoute", "ngResource", 'AngularSpringApp.services']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    

     
	$routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });
    
    $routeProvider.when('/players', {
        templateUrl: 'trains/layout.html',
        controller: PlayerController
    });
    
    $routeProvider.when('/games', {
        templateUrl: 'game',
        controller: PlayerController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    
    $routeProvider.otherwise({redirectTo: '/cars'});
}]);
