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
		$scope.resetError();
		$("#customerList").trigger("reloadGrid");
	};

	$scope.save = function(customer) {
		if (customer.$valid) {
			console.log("valid");
			console.log(customer);
		}
	};

	$scope.addNewCustomer = function(customer) {
		$scope.resetCustomerForm();
		$http.post('../customer/addCustomer', customer).success(function() {
			$scope.fetchCustomersList();
			$("#customerModel").modal('hide');
		}).error(function() {
			$scope.setModalError('Could not add a new customer');
		});
	};

	$scope.updateCustomer = function(customer) {
		$scope.editMode = true;
		$http.put('../customer/updateCustomer', customer).success(function() {
			$scope.fetchCustomersList();
			$("#customerModel").modal('hide');
			$scope.resetCustomerForm();
		}).error(function() {
			$scope.setModalError('Could not update the customer.');
		});
	};

	$scope.editCustomer = function() {
		$scope.resetCustomerForm();
		var selRowId = jQuery("#customerList").jqGrid('getGridParam', 'selrow');
		if (selRowId != null) {
			// var rowNum =
			// jQuery("#customerList").jqGrid('getGridParam','rowNum');
			// var page = jQuery("#customerList").jqGrid('getGridParam','page')
			// -1;
			var userData = jQuery("#customerList").getGridParam("userData");
			$.each(userData, function(index, element) {
				if (element.id == selRowId) {
					$scope.customer = element;
					$scope.editMode = true;
				}
			});

			$("#customerModel").modal('show');
		} else {
			$scope.setError("Please Select Row");
		}
	};

	$scope.removeCustomer = function(id) {
		$scope.resetError();
		$http['delete']('customer/removeCustomer/' + id).success(function() {
			$scope.fetchcustomersList();
		}).error(function() {
			$scope.setError('Could not remove customer');
		});
	};

	$scope.removeAllcustomers = function() {
		$scope.resetError();

		$http['delete']('customer/removeAllcustomers').success(function() {
			$scope.fetchcustomersList();
		}).error(function() {
			$scope.setError('Could not remove all customers');
		});

	};

	$scope.resetCustomerForm = function() {
		$scope.resetError();
		$scope.resetModalError();
		$scope.customer = {};
		$scope.customer.emailId = '';
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

	$scope.resetModalError = function() {
		$scope.modalError = false;
		$scope.modalErrorMessage = '';
	};

	$scope.setModalError = function(message) {
		$scope.modalError = true;
		$scope.modalErrorMessage = message;
	};

	console.log("Customer controller loaded.....");
	// $scope.fetchCustomersList();
	$scope.predicate = 'id';
};