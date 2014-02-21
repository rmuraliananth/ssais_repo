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
			<spring:message code="postoffice.title" />
		</div>
		<div class="col-sm-4">
			<!-- Button trigger modal -->
			<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#postofficeModel" ng-click="resetPostOfficeForm()">
				<spring:message code="postoffice.btn.add" />
			</button>
			
			<button class="btn btn-sm btn-primary"  ng-click="editPostOffice()">
				<spring:message code="postoffice.btn.edit" />
			</button>

			<input type="reset" class="btn btn-sm btn-primary"   ng-disabled="true" value="<spring:message code="postoffice.btn.delete" />" name="Delete">
			
			<button class="btn btn-sm btn-primary"  ng-click="fetchPostOfficesList()">
				<spring:message code="postoffice.btn.refresh" />
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
			<table id="postofficeList"></table>
			<div id="postofficePager"></div>
		</div>
	</div>

    
	<!-- Modal -->

	<div class="modal fade" id="postofficeModel" tabindex="-1" role="dialog" aria-labelledby="PostOffice" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  class="navbar-form" name="postofficeForm" ng-submit="save(postofficeForm)" novalidate>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><spring:message code="postoffice.lbl.header"/></h4>
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
									<spring:message code="postoffice.lbl.name"/>
								</div>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" name="id" ng-model="postoffice.id"  id="id">									
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="text" class="form-control" name="name" ng-model="postoffice.name" placeholder="PostOffice Name" required autofocus min="2">
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="postoffice.lbl.branch"/>
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="branch" ng-model="postoffice.branch" placeholder="Branch" required>
								</div>
							</div>							
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="postoffice.lbl.address"/>
								</div>
								<div class="col-sm-6">
									<textarea rows="3" cols="18" class="form-control" name="address"  ng-model="postoffice.address" placeholder="Address"></textarea>										
								</div>
							</div>							
					 	</div>
					 </div>
				</div>
				<div class="modal-footer">
					<!-- Angular JS -->
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="postofficeForm.$invalid" ng-hide="editMode" ng-click="addNewPostOffice(postoffice)">
							<spring:message code="postoffice.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="postofficeForm.$invalid" ng-show="editMode" ng-click="updatePostOffice(postoffice)">
							<spring:message code="postoffice.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-click="resetPostOfficeForm()">
							<spring:message code="login.btn.reset" />
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">
							<spring:message code="postoffice.btn.cancel"/>
						</button>
				</div>
				</form>
			</div>
			
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {

		var colNames = [ '<spring:message code="postoffice.lbl.id"/>',
				'<spring:message code="postoffice.lbl.name"/>',
				'<spring:message code="postoffice.lbl.branch"/>',
				'<spring:message code="postoffice.lbl.address"/>' ];

		var colModel = [ {
			name : 'id',
			index : 'id',
			align : "center",
			width : 60

		}, {
			name : 'name',
			index : 'postoffice_name',
			align : "left",
			width : 150
		}, {
			name : 'branch',
			index : 'registration_no',
			align : "center",
			width : 120
		}, {
			name : 'address',
			index : 'address',
			align : "left",
			width : 150
		} ];

		$("#postofficeList").jqGrid({
			url : '../postoffice/view?q=2',
			datatype : 'json',
			colNames : colNames,
			colModel : colModel,
			rowNum : 10,
			rowList : [ 10, 20, 30, 40, 50 ],
			pager : '#postofficePager',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			autowidth : true,
			rownumbers : true,
			height : "100%",
			caption : '<spring:message code="postoffice.lbl.header"/>'
		});

		$("#postofficeList").jqGrid('navGrid', '#postofficePager', {
			edit : false,
			add : false,
			del : false,
			search : false
		});

	});
</script>

