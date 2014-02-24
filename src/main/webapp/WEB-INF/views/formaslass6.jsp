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
	              Search
	              <input type="text" data-provide="typeahead">
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
	        	{{errorMessage}}
	      	</div>
		</div>	
	</div>	
	


	<div class="example example-films">
		<h2 class="example-name">Prefetch Backed by Remote</h2>
		<p class="example-description">Prefetches some data then relies on
			remote requests for suggestions when prefetched data is insufficient.</p>

		<div class="demo">
			<input class="typeahead" type="text"
				placeholder="best picture winners">
		</div>
	</div>


</div>
<script>
	var films = new Bloodhound({
		datumTokenizer : function(d) {
			return Bloodhound.tokenizers.whitespace(d.value);
		},
		queryTokenizer : Bloodhound.tokenizers.whitespace,
		remote : '../formaslass6/getAccounts?_search_by_account_no=4&&_search_by_account_name=m'
	});

	films.initialize();

	$('.example-films .typeahead').typeahead(null, {
		displayKey : 'accountNo',
		source : films.ttAdapter()
	});
</script>



