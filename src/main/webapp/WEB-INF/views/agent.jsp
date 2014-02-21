<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Container -->
<div class="container" role="main">
	<div class="row">
		<div class="col-sm-8">
			<spring:message code="agent.title" />
		</div>
		<div class="col-sm-4">
			<!-- Button trigger modal -->
			<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#agentModel" ng-click="resetAgentForm()">
				<spring:message code="agent.btn.add" />
			</button>
			
			<button class="btn btn-sm btn-primary"  ng-click="editAgent()">
				<spring:message code="agent.btn.edit" />
			</button>

			<input type="reset" class="btn btn-sm btn-primary"   ng-disabled="true" value="<spring:message code="agent.btn.delete" />" name="Delete">
			
			<button class="btn btn-sm btn-primary"  ng-click="fetchAgentsList()">
				<spring:message code="agent.btn.refresh" />
			</button>						
		</div>	
	</div>
	<p></p>
	<div class="row">
		<div class="col-sm-12">
			<div class="alert alert-danger" ng-show="error">
	        	{{errorMessage}}
	      	</div>
		</div>	
	</div>				
	
	<div class="row">
		<div class="col-sm-12">
			<table id="agentList"></table>
			<div id="agentPager"></div>
		</div>
	</div>

    
	<!-- Modal -->

	<div class="modal fade" id="agentModel" tabindex="-1" role="dialog" aria-labelledby="Agent" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  class="navbar-form" name="agentForm" ng-submit="save(agentForm)" novalidate>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><spring:message code="agent.lbl.header"/></h4>
				</div>
				<div class="modal-body  ui-widget">
					<div class="row">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-12">
									<div class="alert alert-danger" ng-show="modalError">
							        	{{modalErrorMessage}}
							      	</div>
								</div>	
							</div>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="agent.lbl.name"/>
								</div>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" name="id" ng-model="agent.id"  id="id">									
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="text" class="form-control" name="name" ng-model="agent.name" placeholder="Agent Name" required autofocus min="2">
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="agent.lbl.registration_no"/>
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="registerationNo" ng-model="agent.registerationNo" placeholder="Registration No" required>
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="agent.lbl.registration_date"/>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<input type="text" id="registerDate" class="form-control" name="registerDate" ng-model="agent.registerDate" placeholder="Registration Date" ng-required="true">
                    					<span class="input-group-addon"  onclick="showDate('#registerDate')"><span class="glyphicon glyphicon-calendar"></span></span>
               					 	</div>
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="agent.lbl.expired_date"/>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<input  id="expiredDate" type="text" class="form-control" name="expiredDate" ng-model="agent.expiredDate"  placeholder="Expired Date" ng-required="true">
                    					<span class="input-group-addon"  onclick="showDate('#expiredDate')"><span class="glyphicon glyphicon-calendar"></span></span>
               					 	</div>
								</div>								
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="agent.lbl.address"/>
								</div>
								<div class="col-sm-6">
									<textarea rows="3" cols="18" class="form-control" name="address"  ng-model="agent.address" placeholder="Address"></textarea>										
								</div>
							</div>							
					 	</div>
					 </div>
				</div>
				<div class="modal-footer">
					<!-- Angular JS -->
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="agentForm.$invalid" ng-hide="editMode" ng-click="addNewAgent(agent)">
							<spring:message code="agent.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="agentForm.$invalid" ng-show="editMode" ng-click="updateAgent(agent)">
							<spring:message code="agent.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-click="resetAgentForm()">
							<spring:message code="login.btn.reset" />
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">
							<spring:message code="agent.btn.cancel"/>
						</button>
				</div>
				</form>
			</div>
			
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {

		var colNames = [ '<spring:message code="agent.lbl.id"/>',
				'<spring:message code="agent.lbl.name"/>',
				'<spring:message code="agent.lbl.registration_no"/>',
				'<spring:message code="agent.lbl.registration_date"/>',
				'<spring:message code="agent.lbl.expired_date"/>',
				'<spring:message code="agent.lbl.address"/>' ];

		var colModel = [ {
			name : 'id',
			index : 'id',
			align : "center",
			width : 60

		}, {
			name : 'name',
			index : 'agent_name',
			align : "left",
			width : 150
		}, {
			name : 'registerationNo',
			index : 'registration_no',
			align : "center",
			width : 120
		}, {
			name : 'registerDate',
			index : 'registration_date',
			align : "center",
			width : 120
		}, {
			name : 'expiredDate',
			index : 'expired_date',
			align : "center",
			width : 120
		}, {
			name : 'address',
			index : 'address',
			align : "left",
			width : 150
		} ];

		$("#agentList").jqGrid({
			url : '../agent/view?q=2',
			datatype : 'json',
			colNames : colNames,
			colModel : colModel,
			rowNum : 10,
			rowList : [ 10, 20, 30, 40, 50 ],
			pager : '#agentPager',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			autowidth : true,
			rownumbers : true,
			height : "100%",
			caption : '<spring:message code="agent.lbl.header"/>'
		});

		$("#agentList").jqGrid('navGrid', '#agentPager', {
			edit : false,
			add : false,
			del : false,
			search : false
		});

		$("#registerDate").datepicker({
			dateFormat : 'dd-mm-yy'
		});

		$("#expiredDate").datepicker({
			dateFormat : 'dd-mm-yy'
		});

	});
</script>

