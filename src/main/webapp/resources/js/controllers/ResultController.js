/**
 * 
 */
'use strict';

/**
 * RailwayStationController
 * @constructor
 */
var ResultController = function($scope, $http, GameFactory) {
	
	$scope.players = {};
    
    $scope.fetchPlayersList = function() {
        $http.get('results/classification.json').success(function(rsList){
        
            $scope.players = rsList;
        });
    };
    
    $scope.fetchGamesList = function() {
    	$scope.games =  GameFactory.query();
    };
    
    
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchPlayersList();
    $scope.fetchGamesList();
};