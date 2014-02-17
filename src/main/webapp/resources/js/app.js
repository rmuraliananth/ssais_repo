'use strict';

var SmallSavingsAgentApp = {};

var App = angular.module('SmallSavingsAgentApp', [
                                                  'ngRoute',
                                                  'SmallSavingsAgentApp.filters',
                                                  'SmallSavingsAgentApp.services',
                                                  'SmallSavingsAgentApp.directives'
                                                  ]).
     config(['$routeProvider', function($routeProvider) {	
		 $routeProvider.when('/customer', {
			 templateUrl: 'customer/page',
			 controller: CustomerController
		 });
		 $routeProvider.otherwise({redirectTo: '/auth/index'});
}]);