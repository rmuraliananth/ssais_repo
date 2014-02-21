'use strict';

/**
 * PostOfficeController
 * 
 * @constructor
 */
var PostOfficeController = function($scope, $http) {
	$scope.postoffice = {};
	$scope.editMode = false;

	$scope.fetchPostOfficesList = function() {
		$scope.resetError();
		$("#postofficeList").trigger("reloadGrid");
	};

	$scope.save = function(postoffice) {
		if (postoffice.$valid) {
			console.log("valid");
			console.log(postoffice);
		}
	};

	$scope.addNewPostOffice = function(postoffice) {
		$scope.resetPostOfficeForm();
		$http.post('../postoffice/addPostOffice', postoffice).success(
				function() {
					$scope.fetchPostOfficesList();
					$("#postofficeModel").modal('hide');
				}).error(function() {
			$scope.setModalError('Could not add a new postoffice');
		});
	};

	$scope.updatePostOffice = function(postoffice) {
		$scope.editMode = true;
		$http.put('../postoffice/updatePostOffice', postoffice).success(
				function() {
					$scope.fetchPostOfficesList();
					$("#postofficeModel").modal('hide');
					$scope.resetPostOfficeForm();
				}).error(function() {
			$scope.setModalError('Could not update the postoffice.');
		});
	};

	$scope.editPostOffice = function() {
		$scope.resetPostOfficeForm();
		var selRowId = jQuery("#postofficeList").jqGrid('getGridParam',
				'selrow');
		if (selRowId != null) {
			// var rowNum =
			// jQuery("#postofficeList").jqGrid('getGridParam','rowNum');
			// var page =
			// jQuery("#postofficeList").jqGrid('getGridParam','page') -1;
			var userData = jQuery("#postofficeList").getGridParam("userData");
			$.each(userData, function(index, element) {
				if (element.id == selRowId) {
					$scope.postoffice = element;
					$scope.editMode = true;
				}
			});

			$("#postofficeModel").modal('show');
		} else {
			$scope.setError("Please Select Row");
		}
	};

	$scope.removePostOffice = function(id) {
		$scope.resetError();
		$http['delete']('postoffice/removePostOffice/' + id).success(
				function() {
					$scope.fetchPostOfficesList();
				}).error(function() {
			$scope.setError('Could not remove postoffice');
		});
	};

	$scope.removeAllpostoffices = function() {
		$scope.resetError();

		$http['delete']('postoffice/removeAllpostoffices').success(function() {
			$scope.fetchPostOfficesList();
		}).error(function() {
			$scope.setError('Could not remove all postoffices');
		});

	};

	$scope.resetPostOfficeForm = function() {
		$scope.resetError();
		$scope.resetModalError();
		$scope.postoffice = {};
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

	console.log("PostOffice controller loaded.....");
	// $scope.fetchPostOfficesList();
	$scope.predicate = 'id';
};