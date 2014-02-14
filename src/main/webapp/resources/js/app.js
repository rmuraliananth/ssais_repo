'use strict';

var SmallSavingsAgentApp = {};

var App = angular.module('SmallSavingsAgentApp', [
		'SmallSavingsAgentApp.filters', 'SmallSavingsAgentApp.services',
		'SmallSavingsAgentApp.directives' ]);

App.controller('CustomerController', [ '$scope','$http', function($scope, $http) {	
	$scope.customer = {};
    $scope.editMode = false;

    $scope.fetchCustomersList = function() {
    	$("#customerList").trigger("reloadGrid");		  
    }

    $scope.addNewCustomer = function(customer) {
        $scope.resetCustomerForm();        
        $http.post('addCustomer', customer).success(function() {
            $scope.fetchCustomersList();
            $("#customerModel").modal('hide');
        }).error(function() {
            $scope.setError('Could not add a new customer');
        });
    }

    $scope.updateCustomer = function(customer) {
    	 $scope.resetCustomerForm();      
    	 $scope.editMode = true;
        $http.put('customer/updateCustomer', customer).success(function() {
        	$scope.fetchCustomersList();
        	$scope.customer = {};            
            $("#customerModel").modal('hide');
        }).error(function() {
            $scope.setError('Could not update the customer');
        });
    }

    $scope.editCustomer = function(customer) {
    	$("#customerModel").modal('show');
        $scope.resetError();
        $scope.customer = customer;
        $scope.editMode = true;
    }

    $scope.removeCustomer = function(id) {
        $scope.resetError();

        $http.delete('customer/removeCustomer/' + id).success(function() {
            $scope.fetchcustomersList();
        }).error(function() {
            $scope.setError('Could not remove customer');
        });
    }

    $scope.removeAllcustomers = function() {
        $scope.resetError();

        $http.delete('customer/removeAllcustomers').success(function() {
            $scope.fetchcustomersList();
        }).error(function() {
            $scope.setError('Could not remove all customers');
        });

    };

    $scope.resetCustomerForm = function() {
        $scope.resetError();
        $scope.customer = {};
        $scope.customer.emailId = '';
        $scope.editMode = false;
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }
    
    // $scope.fetchCustomersList();
    $scope.predicate = 'id';
	
} ]);