<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<!-- Container -->
<div class="container" role="main">
	<div class="row">
		<div class="col-sm-8">
			<spring:message code="customer.title" />
		</div>
		<div class="col-sm-4">
			<!-- Button trigger modal -->
			<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#customerModel" ng-click="resetCustomerForm()">
				<spring:message code="customer.btn.add" />
			</button>
			
			<button class="btn btn-sm btn-primary"  ng-click="editCustomer()">
				<spring:message code="customer.btn.edit" />
			</button>

			<input type="reset" class="btn btn-sm btn-primary"  ng-disabled="true" value="<spring:message code="customer.btn.delete" />" name="Delete">
			
			<button class="btn btn-sm btn-primary"  ng-click="fetchCustomersList()">
				<spring:message code="customer.btn.refresh" />
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
			<table id="customerList"></table>
			<div id="customerPager"></div>
		</div>
	</div>

    
	<!-- Modal -->

	<div class="modal fade" id="customerModel" tabindex="-1" role="dialog" aria-labelledby="Customer" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form  class="navbar-form" name="customerForm" ng-submit="save(customerForm)" novalidate>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"><spring:message code="customer.lbl.header"/></h4>
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
									<spring:message code="customer.lbl.name"/>
								</div>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" name="customer.id" id="id">
									<input type="hidden" class="form-control" name="customer.account.id">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="text" class="form-control" name="name" ng-model="customer.name" placeholder="Customer Name" required autofocus min="2">
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.lbl.email_id"/>
								</div>
								<div class="col-sm-4">
									<input type="email" class="form-control" name="emailId"  ng-model="customer.emailId" placeholder="Email Id">
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.lbl.phone_no"/>
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="phoneNo"  ng-model="customer.phoneNo" placeholder="Phone No" ng-pattern="/[0-9]{5}$/">
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.lbl.address"/>
								</div>
								<div class="col-sm-6">
									<textarea rows="3" cols="18" class="form-control" name="address"  ng-model="customer.address" placeholder="Address"></textarea>										
								</div>
							</div>
							<p></p>
							<!-- Account -->
							
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.account.lbl.account_no"/>
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="accountNo"  ng-model="customer.account.accountNo" placeholder="Account No">										
								</div>
							</div>	
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.account.lbl.principal_amount"/>
								</div>
								<div class="col-sm-4">
									<input type="number" class="form-control" name="principalAmount" ng-model="customer.account.principalAmount" placeholder="Amount" required ng-minlength="2" ng-pattern="/^[1-9]\d*$/">										
								</div>
							</div>	
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.account.lbl.open_date"/>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<input id="openDate" type="text" class="form-control" name="openDate" ng-model="customer.account.openDate" placeholder="Open Date" ng-required="true">
                    					<span class="input-group-addon"  onclick="showDate('#openDate')"><span class="glyphicon glyphicon-calendar"></span></span>
               					 	</div>
									
								</div>
							</div>	
							<p></p>
							<div class="row">
								<div class="col-sm-6">
									<spring:message code="customer.account.lbl.maturity_date"/>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<input  id="maturityDate" type="text" class="form-control" name="maturityDate" ng-model="customer.account.maturityDate"  placeholder="Maturity Date" ng-required="true">
                    					<span class="input-group-addon"  onclick="showDate('#maturityDate')"><span class="glyphicon glyphicon-calendar"></span></span>
               					 	</div>
								</div>
							</div>	
					 	</div>
					 </div>
				</div>
				<div class="modal-footer">
					<!-- Angular JS -->
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="customerForm.$invalid" ng-hide="editMode" ng-click="addNewCustomer(customer)">
							<spring:message code="customer.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-disabled="customerForm.$invalid" ng-show="editMode" ng-click="updateCustomer(customer)">
							<spring:message code="customer.btn.save"/>
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" ng-click="resetCustomerForm()">
							<spring:message code="login.btn.reset" />
						</button>
						
						<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">
							<spring:message code="customer.btn.cancel"/>
						</button>
				</div>
				</form>
			</div>
			
		</div>
	</div>
</div>

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
				'<spring:message code="customer.lbl.address"/>' ];

		var colModel = [ {
			name : 'id',
			index : 'id',
			align : "center",
			width : 60

		}, {
			name : 'name',
			index : 'customer_name',
			align : "left",
			width : 150
		}, {
			name : 'account.accountNo',
			index : 'account_no',
			align : "center",
			width : 100
		}, {
			name : 'account.principalAmount',
			index : 'principal_amount',
			align : "right",
			width : 100
		}, {
			name : 'account.openDate',
			index : 'open_date',
			align : "center",
			width : 120
		}, {
			name : 'account.maturityDate',
			index : 'maturity_date',
			align : "center",
			width : 120
		}, {
			name : 'phoneNo',
			index : 'phone_no',
			align : "left",
			width : 100
		}, {
			name : 'emailId',
			index : 'email_id',
			align : "left",
			width : 100
		}, {
			name : 'address',
			index : 'address',
			align : "left",
			width : 150
		}

		];

		$("#customerList").jqGrid({
			url : '../customer/view?q=2',
			datatype : 'json',
			colNames : colNames,
			colModel : colModel,
			rowNum : 10,
			rowList : [ 10, 20, 30, 40, 50 ],
			pager : '#customerPager',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			autowidth : true,
			rownumbers : true,
			height : "100%",
			caption : '<spring:message code="customer.lbl.header"/>'
		});

		$("#customerList").jqGrid('navGrid', '#customerPager', {
			edit : false,
			add : false,
			del : false,
			search : false
		});

		$("#openDate").datepicker({
			 dateFormat : 'dd-mm-yy'
		});

		$("#maturityDate").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>