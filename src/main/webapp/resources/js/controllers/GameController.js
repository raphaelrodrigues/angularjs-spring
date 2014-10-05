'use strict';

/**
 * RailwayStationController
 * 
 * @constructor
 */
var GameController = function($scope, $http, $timeout, PlayerFactory, GameFactory ) {
    
	$scope.game = {};
    $scope.editMode = false;
    
    $scope.fetchGamesList = function() {
    	$scope.games =  GameFactory.query();
    };
    
    
    $scope.list5 =  PlayerFactory.query();
    
    $scope.game.team1 = [];
    $scope.game.team2 = [];
    
    $scope.dt = new Date();
    
    
    // Limit items to be dropped in list1
    $scope.optionsList1 = {
      accept: function(dragEl) {
        if ($scope.game.team1.length >= 5) {
          return false;
        } else {
          return true;
        }
      }
    };
    
    $scope.optionsList2 = {
    	      accept: function(dragEl) {
    	        if ($scope.game.team2.length >= 5) {
    	          return false;
    	        } else {
    	          return true;
    	        }
    	      }
    	    };
    
    
    $scope.addNewGame = function(game) {
       
    	
    	$scope.resetError();
        var game1 = {"id":1,"team1":[{"id":6,"name":"Nani","points":5,"games":[]},{"id":7,"name":"Mossoro","points":17,"games":[]},{"id":8,"name":"Toti","points":5,"games":[]},{"id":9,"name":"Neuer","points":0,"games":[]},{"id":10,"name":"Pirlo","points":3,"games":[]}],"team2":[{"id":1,"name":"Messi","points":5,"games":[]},{"id":2,"name":"Ronaldo","points":6,"games":[]},{"id":3,"name":"Diego Costa","points":14,"games":[]},{"id":4,"name":"Pepe","points":7,"games":[]},{"id":5,"name":"Figo","points":17,"games":[]}],"result_team1":3,"result_team2":1,"date_of_game":null,"created_at":null}
    	
    	//alert($scope.game.team1);
    	
    	var game_json = JSON.stringify(game);
    	alert(game_json);
//    	var player_json = JSON.stringify(game1.team1[0]);
//    	alert(player_json);
    	var res = $http.post('games/add', game_json,function(e) {

        }, "json");
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			alert(data);
		});
		
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
		
		
        
    };
    
    
    $scope.resetGameForm = function() {
        $scope.resetError();
        $scope.game = {};
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
    
    //DRAG AND DROP
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