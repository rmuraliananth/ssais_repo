'use strict';

var SmallSavingsAgentApp = {};

var App = angular.module('SmallSavingsAgentApp', [
		'SmallSavingsAgentApp.filters', 'SmallSavingsAgentApp.services',
		'SmallSavingsAgentApp.directives' ]);

// Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider) {
	/*
	 * $routeProvider.when('/cars', { templateUrl : 'cars/layout', controller :
	 * CarController });
	 * 
	 * $routeProvider.when('/trains', { templateUrl : 'trains/layout',
	 * controller : TrainController });
	 * 
	 * $routeProvider.when('/railwaystations', { templateUrl :
	 * 'railwaystations/layout', controller : RailwayStationController });
	 * 
	 * $routeProvider.otherwise({ redirectTo : '/cars' });
	 */
} ]);
