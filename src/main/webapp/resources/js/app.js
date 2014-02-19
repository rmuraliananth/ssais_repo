'use strict';
/*
 * var SmallSavingsAgentApp = {};
 * 
 * var App = angular.module( 'SmallSavingsAgentApp', [ 'ngRoute',
 * 'SmallSavingsAgentApp.filters', 'SmallSavingsAgentApp.services',
 * 'SmallSavingsAgentApp.directives' ]).config( [ '$routeProvider',
 * function($routeProvider) { $routeProvider.when('/customer', { templateUrl :
 * 'customer/page', controller : CustomerController });
 * 
 * $routeProvider.when('/agent', { templateUrl : 'agent/page', controller :
 * AgentController });
 * 
 * $routeProvider.otherwise({ redirectTo : '/auth/index' }); } ]);
 * 
 */

var SmallSavingsAgentApp = angular.module('SmallSavingsAgentApp',
		[ 'ui.compat' ]);

angular.module('SmallSavingsAgentApp').config(
		function($stateProvider, $urlRouterProvider, $sceProvider) {
			$sceProvider.enabled(false);

			$stateProvider.state('dashboard', {
				url : '',
				controller : 'CustomerController',
				templateUrl : '../customer/pageNew'
			}), $stateProvider.state('customer', {
				url : '/customer',
				controller : 'CustomerController',
				templateUrl : '../customer/pageNew'
			}), $stateProvider.state('agent', {
				url : '/agent',
				controller : 'AgentController',
				templateUrl : '../agent/page'
			}), $stateProvider.state('subpage', {
				url : '/subpage',
				controller : 'subpageController',
				templateUrl : 'app/subpage.jsp'
			});
		});
