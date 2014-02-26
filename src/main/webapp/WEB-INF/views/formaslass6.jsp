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
			<spring:message code="formaslass6.title" />
		</div>
		<div class="col-sm-4">
			<!-- Button trigger modal -->
			<button class="btn btn-sm btn-primary" data-toggle="modal" data-target="#formaslass6Model" ng-click="resetPostOfficeForm()">
				<spring:message code="formaslass6.btn.add" />
			</button>
			
			<button class="btn btn-sm btn-primary"  ng-disabled="true"  ng-click="editPostOffice()">
				<spring:message code="formaslass6.btn.edit" />
			</button>

			<input type="reset" class="btn btn-sm btn-primary"   ng-disabled="true" value="<spring:message code="formaslass6.btn.delete" />" name="Delete">
			
			<button class="btn btn-sm btn-primary"   ng-disabled="true" ng-click="fetchPostOfficesList()">
				<spring:message code="formaslass6.btn.refresh" />
			</button>						
		</div>	
	</div>
	<p></p>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
	            <div class="panel-body">
	              <div class="row">
						<div class="col-sm-3">
							<p>
								<spring:message code="formaslass6.lbl.search_account_no_or_name" />
							</p>
							<input class="form-control" id="search_account_no_or_name" type="text" name="search_account_no_or_name"  placeholder="Account Name Or No"/>
							
						</div>
						<div class="col-sm-9">
							<div class="row">
								<div class="col-sm-2">
										<spring:message code="customer.lbl.name"/>
								</div>
								<div class="col-sm-2">
										<spring:message code="customer.account.lbl.account_no"/>
								</div>
								<div class="col-sm-2">
										<spring:message code="customer.account.lbl.principal_amount"/>
								</div>
								<div class="col-sm-3">
										<spring:message code="customer.account.lbl.open_date"/>
								</div>
							</div>
							<p></p>
							<div class="row">
								<div class="col-sm-2">
									{{account.name}}
								</div>
								<div class="col-sm-2">
									{{account.accountNo}}
								</div>
								<div class="col-sm-2">
									{{account.principalAmount}}
								</div>
								<div class="col-sm-3">
									{{account.openDate}}
								</div>
							</div>
						</div>
					</div>
	            </div>
          	</div>
          	<div class="panel panel-primary">
	            <div class="panel-body">
	              ASSLAS FORM DETAILS
	            </div>
          	</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="alert alert-danger" ng-show="error">
	        	{{errorMessage}}  {{formaccount}}	   
	      	</div>
		</div>	
	</div>
</div>