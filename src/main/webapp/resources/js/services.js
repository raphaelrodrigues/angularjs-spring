'use strict';

/* Services */

var AppServices = angular.module('AngularSpringApp.services', ["ngResource"]);

AppServices
.factory('PlayerFactory', ['$resource',
		 function($resource){
		    return $resource('players/playerslist.json', {}, {
		        query: {method:'GET', isArray:true}
		    });
	}])
.factory('GameFactory', ['$resource',
		 function($resource){
		    return $resource('games/gameslist.json', {}, {
		        query: {method:'GET', isArray:true}
		    });
	}])
AppServices.value('version', '0.1');

