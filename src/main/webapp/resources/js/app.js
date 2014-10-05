'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ["ngSanitize","ngRoute", "ngResource", 'ngDragDrop','AngularSpringApp.services','AngularSpringApp.filters','AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    

	$routeProvider.when('/games', {
        templateUrl: 'games/layout',
        controller: GameController
    });
    
    $routeProvider.when('/players', {
        templateUrl: 'players/layout',
        controller: PlayerController
    });
    
    $routeProvider.when('/players/new', {
        templateUrl: 'players/layout_new',
        controller: PlayerController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });
    
    $routeProvider.when('/results', {
        templateUrl: 'results/layout',
        controller: ResultController
    });
    
    $routeProvider.otherwise({redirectTo: '/games'});
}]);
