<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<head>
<title><spring:message code="customer.title"></spring:message></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<jsp:include page="common/include.jsp"></jsp:include>
</head>
<body>
	<!-- Header -->
	<jsp:include page="common/header.jsp"></jsp:include>
		
	<!-- Container -->
	<div class="container theme-showcase" role="main">
			<div class="row">
				<div class="col-sm-8">
					<spring:message code="customer.title" />
				</div>
				<div class="col-sm-4">
					<!-- Button trigger modal -->
					<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#customerModel">
						<spring:message code="customer.btn.add" />
					</button>

					<input type="reset" class="btn btn-sm btn-primary" value="<spring:message code="customer.btn.edit" />" name="Edit">
					<input type="reset" class="btn btn-sm btn-primary" value="<spring:message code="customer.btn.delete" />" name="Delete">
					<input type="reset" class="btn btn-sm btn-primary" value="<spring:message code="customer.btn.refresh" />" name="Refresh">
				</div>	
			</div>
			<p></p>
			<div class="row">
				<div class="col-sm-12">
					<table id="customerList"></table>
					<div id="customerPager"></div>
				</div>
			</div>
			
		<!-- Modal -->
		<div class="modal fade" id="customerModel" tabindex="-1" role="dialog" aria-labelledby="Customer" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"><spring:message code="customer.lbl.header"/></h4>
					</div>
					<div class="modal-body">
							<div class="row">
								<div class="col-sm-2">
									<spring:message code="customer.lbl.name"/>
								</div>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" name="id" id="id">
									<input type="text" class="form-control" name="name" id="name" placeholder="Name" required autofocus>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-2">
									<spring:message code="customer.lbl.email_id"/>
								</div>
								<div class="col-sm-2">
									<input type="email" class="form-control" name="emailId" id="email" placeholder="Email Id" required>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-2">
									<spring:message code="customer.lbl.phone_no"/>
								</div>
								<div class="col-sm-2">
									
								</div>
							</div>
							<div class="row">
								<div class="col-sm-2">
									<spring:message code="customer.lbl.address"/>
								</div>
								<div class="col-sm-2">
									
								</div>
							</div>
							
					
					'<spring:message code="customer.lbl.id"/>',
					'<spring:message code="customer.lbl.name"/>',
					'<spring:message code="customer.account.lbl.account_no"/>',
					'<spring:message code="customer.account.lbl.principal_amount"/>',
					'<spring:message code="customer.account.lbl.open_date"/>',
					'<spring:message code="customer.account.lbl.maturity_date"/>',
					'<spring:message code="customer.account.lbl.id"/>',
					'<spring:message code="customer.account.lbl.name"/>'
					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-primary" >
							<spring:message code="customer.btn.save"/>
						</button>
						<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">
							<spring:message code="customer.btn.cancel"/>
						</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<!-- Angular JS -->
	<div class="alert alert-error" ng-show="error">
    {{errorMessage}}
</div>
<form class="form-horizontal">
    <div class="control-group">
        <label class="control-label" for="inputEmail">Train Name</label>

        <div class="controls">
            <input type="text" id="inputEmail" ng-model="train.name" placeholder="Train Name" required min="2">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputEmail">Speed</label>

        <div class="controls">


            <input class="span3" type="text" id="inputSpeed" ng-model="train.speed" placeholder="Speed" required min="1">
            <span class="add-on">km/h</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <label class="checkbox">
                <input type="checkbox" ng-model="train.diesel"> Is Diesel
            </label>
        </div>
        <hr />
        <div class="controls">
            <button type="button" class="btn btn-primary" ng-disabled="!train.name || !train.speed" ng-hide="editMode" ng-click="addNewTrain(train)">Add Train</button>
            <button type="button" class="btn btn-primary" ng-disabled="!train.name || !train.speed" ng-show="editMode" ng-click="updateTrain(train)">Save Train</button>
            <button type="button" class="btn" ng-click="resetTrainForm()">Reset</button>
        </div>
    </div>
</form>
<hr />
<h3>Trains List</h3>
<div class="alert alert-info" ng-show="trains.length == 0">
    No trains found
</div>
<table class="table table-bordered table-striped" ng-show="trains.length > 0">
    <thead>
        <tr>
            <th style="text-align: center; width: 25px;">Id</th>
            <th style="text-align: center;">Name</th>
            <th style="text-align: center;">Speed</th>
            <th style="text-align: center;">Diesel</th>
            <th style="text-align: center;">Action</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="train in trains | orderBy:predicate">
            <td style="text-align: center;">{{train.id}}</td>
            <td>{{train.name}}</td>
            <td>{{train.speed}}</td>
            <td style="text-align: center;width: 20px;"><span ng-show="train.diesel" class="icon-ok"></span></td>
            <td style="width:100px;text-align: center;">
                <button class="btn btn-mini btn-danger" ng-click="removeTrain(train.id)">Remove</button>
                <button class="btn btn-mini btn-success" ng-click="editTrain(train)">Edit</button>
            </td>
        </tr>
    </tbody>
</table>
<button class="btn btn-danger" ng-show="trains.length > 1" ng-click="removeAllTrains()">Remove All Trains</button>
	
	<!-- Footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		$(function() {

			var colNames = [
					'<spring:message code="customer.lbl.id"/>',
					'<spring:message code="customer.lbl.name"/>',
					'<spring:message code="customer.account.lbl.account_no"/>',
					'<spring:message code="customer.account.lbl.principal_amount"/>',
					'<spring:message code="customer.account.lbl.open_date"/>',
					'<spring:message code="customer.account.lbl.maturity_date"/>',
					'<spring:message code="customer.lbl.phone_no"/>',
					'<spring:message code="customer.lbl.email_id"/>',
					'<spring:message code="customer.lbl.address"/>',
					'<spring:message code="customer.account.lbl.id"/>',
					'<spring:message code="customer.account.lbl.name"/>' ];

			var colModel = [
					{
						name : 'id',
						index : 'id',
						align : "center",
						width : 50

					},
					{
						name : 'name',
						index : 'customer_name',
						align : "left",
						width : 150
					},
					{
						name : 'account.accountNo',
						index : 'account_no',
						align : "center",
						width : 150
					},
					{
						name : '<spring:message code="customer.account.lbl.principal_amount"/>',
						index : 'principal_amount',
						align : "right",
						width : 150
					},
					{
						name : '<spring:message code="customer.account.lbl.open_date"/>',
						index : 'open_date',
						align : "center",
						width : 150
					},
					{
						name : '<spring:message code="customer.account.lbl.maturity_date"/>',
						index : 'maturity_date',
						align : "center",
						width : 150
					},
					{
						name : '<spring:message code="customer.lbl.phone_no"/>',
						index : 'phone_no',
						align : "left",
						width : 150
					},
					{
						name : '<spring:message code="customer.lbl.email_id"/>',
						index : 'email_id',
						align : "left",
						width : 150
					},
					{
						name : '<spring:message code="customer.lbl.address"/>',
						index : 'address',
						align : "left",
						width : 150
					},
					{
						name : 'account.id',
						index : 'account_id',
						align : "center",
						width : 150
					},
					{
						name : '<spring:message code="customer.account.lbl.name"/>',
						index : 'account_name',
						align : "left",
						width : 150
					} ];

			$("#customerList").jqGrid({
				url : 'view?q=2',
				datatype : "json",
				colNames : colNames,
				colModel : colModel,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : '#customerPager',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				autowidth : true,
				rownumbers : true,
				height : "100%",
				editurl : "server.php",
				caption : '<spring:message code="customer.lbl.header"/>'
			});
			$("#customerList").jqGrid('navGrid', '#customerPager', {
				edit : false,
				add : false,
				del : false
			});

		});
	</script>
</body>
</html>
