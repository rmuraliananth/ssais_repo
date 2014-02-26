'use strict';

/**
 * FormAslass6Controller
 * 
 * @constructor
 */
var FormAslass6Controller = function($scope, $http) {
	$scope.postoffice = {};
	$scope.editMode = false;
	$scope.search_account_id = '';
	$scope.account = {};

	$scope.formaccount = {};

	$scope.fetchPostOfficesList = function() {
		$scope.resetError();
		// $("#postofficeList").trigger("reloadGrid");
	};

	$scope.save = function(postoffice) {
		if (postoffice.$valid) {
			console.log("valid");
			console.log(postoffice);
		}
	};

	$scope.selectedAccount = function(account) {
		$scope.account = account;
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

	console.log("FormAslass6Controller controller loaded.....");

	/* Search account name or account no */
	var searchAccounts = new Bloodhound(
			{
				datumTokenizer : function(d) {
					return Bloodhound.tokenizers.whitespace(d.value);
				},
				queryTokenizer : Bloodhound.tokenizers.whitespace,
				remote : '../formaslass6/searchAccounts?_search_account_no_or_name=%QUERY',
			});

	searchAccounts.initialize();

	$scope._searchByAccountNoOrName = function() {
		$('#search_account_no_or_name').typeahead(
				null,
				{
					displayKey : 'accountNo',
					source : searchAccounts.ttAdapter(),
					templates : {
						suggestion : Handlebars
								.compile('<p>{{name}} ({{accountNo}})</p>')
					}
				});

		$('#search_account_no_or_name').on('typeahead:selected',
				function(e, account, data_set) {
					$scope.$apply(function() {
						$scope.account = account;
					});
				});
	};
	$scope._searchByAccountNoOrName();
	$scope.predicate = 'id';
};