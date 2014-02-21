'use strict';

/**
 * DashboardController
 * 
 * @constructor
 */
var DashboardController = function($rootScope, $scope, $location) {
	console.log('Dashboard controller loaded');
};

/**
 * MenuController
 * 
 * @constructor
 */
var MenuController = function($rootScope, $scope, $location) {

	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};

	$location.path('/home');
	console.log('Menu controller loaded');
};