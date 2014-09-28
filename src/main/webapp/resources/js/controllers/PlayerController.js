'use strict';

/**
 * RailwayStationController
 * @constructor
 */
var PlayerController = function($scope, $http, PlayerFactory) {
    $scope.rs = {};
    $scope.editMode = false;
    
    $scope.fetchPlayersList = function() {
    	$scope.players =  PlayerFactory.query();
    };
    
    $scope.addPlayer = function(rs) {
        $scope.resetError();

        $http.post('players/add/' +  rs.name).success(function() {
            $scope.fetchPlayersList();
            $scope.rs.name = '';
            toastr.success("Created");
        }).error(function(data) {
        	
            $scope.setError('Could not add a new player');
            
        });
    };
    
    $scope.updatePlayer = function(rs) {
        $scope.resetError();

        $http.put('players/update', rs).success(function() {
            $scope.fetchPlayersList();
            $scope.rs.name = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the player');
        });
    };

    $scope.editPlayer = function(rs) {
        $scope.resetError();
        $scope.rs = rs;
        $scope.editMode = true;
    };

    $scope.removePlayer = function(id) {
        $scope.resetError();

        $http.delete('players/remove/' + id).success(function() {
            $scope.fetchPlayersList();
        }).error(function() {
            $scope.setError('Could not remove player');
        });
        
        $scope.rs = '';
    };

    $scope.removeAllPlayer = function() {
        $scope.resetError();

        $http.delete('players/removeAll').success(function() {
            $scope.fetchPlayersList();
        }).error(function() {
            $scope.setError('Could not remove all Players');
        });

    };

    $scope.resetPlayerForm = function() {
        $scope.resetError();
        $scope.rs = {};
        $scope.editMode = false;
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

    $scope.predicate = 'id';
};