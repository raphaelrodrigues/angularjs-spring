'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ["ngSanitize","ngRoute", "ngResource", 'ngDragDrop','AngularSpringApp.services','AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    

	$routeProvider.when('/games', {
        templateUrl: 'cars/layout',
        controller: GameController
    });
    
    $routeProvider.when('/players', {
        templateUrl: 'railwaystations/layout',
        controller: PlayerController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    
    $routeProvider.otherwise({redirectTo: '/games'});
}]);
