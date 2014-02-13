'use strict';

/**
 * CustomerController
 * 
 * @constructor
 */
var CustomerController = function($scope, $http) {
    $scope.customer = {};
    $scope.editMode = false;

    $scope.fetchCustomersList = function() {
        $http.get('customers/customerslist.json').success(function(customerList){
            $scope.customers = customerList;
        });
    }

    $scope.addNewCustomer = function(customer) {
        $scope.resetError();

        $http.post('customer/addCustomer', customer).success(function() {
            $scope.fetchcustomersList();
            $scope.customer.name = '';
            $scope.customer.speed = '';
            $scope.customer.diesel = false;
        }).error(function() {
            $scope.setError('Could not add a new customer');
        });
    }

    $scope.updateCustomer = function(customer) {
        $scope.resetError();

        $http.put('customer/updateCustomer', customer).success(function() {
            $scope.fetchcustomersList();
            $scope.customer.name = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the customer');
        });
    }

    $scope.editcustomer = function(customer) {
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

    $scope.fetchCustomersList();

    $scope.predicate = 'id';
}