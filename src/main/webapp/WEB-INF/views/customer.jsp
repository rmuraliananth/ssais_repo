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
	
	<div ng-app="SmallSavingsAgentApp">					
		<div ng-controller="CustomerController">
		
			<!-- Container -->
			<div class="container" role="main">
				<div class="row">
					<div class="col-sm-8">
						<spring:message code="customer.title" />
					</div>
					<div class="col-sm-4">
						<!-- Button trigger modal -->
						<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#customerModel">
							<spring:message code="customer.btn.add" />
						</button>
						
						<button class="btn btn-sm btn-primary"  ng-click="editCustomer(customer)">
							<spring:message code="customer.btn.edit" />
						</button>
		
						<input type="reset" class="btn btn-sm btn-primary" value="<spring:message code="customer.btn.delete" />" name="Delete">
						
						<button class="btn btn-sm btn-primary"  ng-click="fetchCustomersList()">
							<spring:message code="customer.btn.refresh" />
						</button>
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
							<form  class="navbar-form" >	
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel"><spring:message code="customer.lbl.header"/></h4>
							</div>
							<div class="modal-body  ui-widget">
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message code="customer.lbl.name"/>
										</div>
										<div class="col-sm-4">
											<input type="hidden" class="form-control" name="customer.id" id="id">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<input type="text" class="form-control" name="name" ng-model="customer.name" placeholder="Customer Name" required autofocus min="2">
										</div>
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message code="customer.lbl.email_id"/>
										</div>
										<div class="col-sm-4">
											<input type="email" class="form-control" name="emailId"  ng-model="customer.emailId" placeholder="Email Id">
										</div>
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message code="customer.lbl.phone_no"/>
										</div>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="phoneNo"  ng-model="customer.phoneNo" placeholder="Phone No">
										</div>
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message code="customer.lbl.address"/>
										</div>
										<div class="col-sm-6">
											<textarea rows="4" cols="25" class="form-control" name="address"  ng-model="customer.address" placeholder="Address"></textarea>										
										</div>
									</div>	
							
							</div>
							<div class="modal-footer">
								<!-- Angular JS -->
															
									
									<button type="button" class="btn btn-sm btn-primary" ng-disabled="!customer.name" ng-hide="editMode" ng-click="addNewCustomer(customer)">
										<spring:message code="customer.btn.save"/>
									</button>
									
									<button type="button" class="btn btn-sm btn-primary" ng-disabled="!customer.id && !customer.name" ng-show="editMode" ng-click="updateCustomer(customer)">
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
		</div>
	</div>
	





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
						name : 'phoneNo',
						index : 'phone_no',
						align : "left",
						width : 150
					},
					{
						name : 'emailId',
						index : 'email_id',
						align : "left",
						width : 150
					},
					{
						name : 'address',
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
