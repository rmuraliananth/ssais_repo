'use strict';

/**
 * AgentController
 * 
 * @constructor
 */
var AgentController = function($scope, $http) {
	$scope.agent = {};
	$scope.editMode = false;

	$scope.fetchAgentsList = function() {
		$scope.resetError();
		$("#agentList").trigger("reloadGrid");
	};

	$scope.save = function(agent) {
		if (agent.$valid) {
			console.log("valid");
			console.log(agent);
		}
	};

	$scope.addNewAgent = function(agent) {
		$scope.resetAgentForm();
		$http.post('../agent/addAgent', agent).success(function() {
			$scope.fetchAgentsList();
			$("#agentModel").modal('hide');
		}).error(function() {
			$scope.setModalError('Could not add a new agent');
		});
	};

	$scope.updateAgent = function(agent) {
		$scope.editMode = true;
		$http.put('../agent/updateAgent', agent).success(function() {
			$scope.fetchAgentsList();
			$("#agentModel").modal('hide');
			$scope.resetAgentForm();
		}).error(function() {
			$scope.setModalError('Could not update the agent.');
		});
	};

	$scope.editAgent = function() {
		$scope.resetAgentForm();
		var selRowId = jQuery("#agentList").jqGrid('getGridParam', 'selrow');
		if (selRowId != null) {
			// var rowNum =
			// jQuery("#agentList").jqGrid('getGridParam','rowNum');
			// var page = jQuery("#agentList").jqGrid('getGridParam','page') -1;
			var userData = jQuery("#agentList").getGridParam("userData");
			$.each(userData, function(index, element) {
				if (element.id == selRowId) {
					$scope.agent = element;
					$scope.editMode = true;
				}
			});

			$("#agentModel").modal('show');
		} else {
			$scope.setError("Please Select Row");
		}
	};

	$scope.removeAgent = function(id) {
		$scope.resetError();
		$http['delete']('agent/removeAgent/' + id).success(function() {
			$scope.fetchAgentsList();
		}).error(function() {
			$scope.setError('Could not remove agent');
		});
	};

	$scope.removeAllagents = function() {
		$scope.resetError();

		$http['delete']('agent/removeAllagents').success(function() {
			$scope.fetchAgentsList();
		}).error(function() {
			$scope.setError('Could not remove all agents');
		});

	};

	$scope.resetAgentForm = function() {
		$scope.resetError();
		$scope.resetModalError();
		$scope.agent = {};
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

	console.log("Agent controller loaded.....");
	// $scope.fetchAgentsList();
	$scope.predicate = 'id';
};