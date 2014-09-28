'use strict';

/**
 * RailwayStationController
 * @constructor
 */
var GameController = function($scope, $http, $timeout, PlayerFactory, GameFactory ) {
    $scope.rs = {};
    $scope.editMode = false;
    
    $scope.fetchGamesList = function() {
    	$scope.games =  GameFactory.query();
    };
    
    $scope.list5 =  PlayerFactory.query();
    
    $scope.list1 = [];
    $scope.list2 = [];
    
    
    // Limit items to be dropped in list1
    $scope.optionsList1 = {
      accept: function(dragEl) {
        if ($scope.list1.length >= 5) {
          return false;
        } else {
          return true;
        }
      }
    };
    
    
    $scope.addPlayer = function(rs) {
        $scope.resetError();

        $http.post('players/add/' +  rs.name).success(function() {
            $scope.fetchGamesList();
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

    $scope.fetchGamesList();

    $scope.predicate = 'id';
    
    $scope.dropListener = function (eDraggable, eDroppable) {
    	 
        var isDropForbidden = function (aTarget, item) {
            if (aTarget.some(function (i) {
                return i.name == item.name;
            })) {
                return {reason:'target already contains "' + item.name + '"'};
            } else {
                return false;
            }
        };

        var onDropRejected = function (error) {
            alert('Operation not permitted: ' + error.reason);
        };

        var onDropComplete = function (eSrc, item, index) {
            console.log('moved "' + item.name + ' from ' + eSrc.data('model') + '[' + index + ']' + ' to ' + eDroppable.data('model'));
        };

        var eSrc = eDraggable.parent();
        var sSrc = eSrc.data('model');
        var sTarget = eDroppable.data('model');

        if (sSrc != sTarget) {
            $scope.$apply(function () {
                var index = eDraggable.data('index');
                var aSrc = $scope.$eval(sSrc);
                var aTarget = $scope.$eval(sTarget);
                var item = aSrc[index];
                var error = isDropForbidden(aTarget, item);
                if (error) {
                    onDropRejected(error);
                } else {
                    aTarget.push(item);
                    aSrc.splice(index, 1);
                    onDropComplete(eSrc, item, index);
                }
            });
        }

    };

};