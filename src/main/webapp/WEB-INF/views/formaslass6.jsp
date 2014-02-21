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
	
	<div class="well">  
		<input type="text" class="span3" id="search" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="["Ahmedabad","Akola","Asansol","Aurangabad","Bangaluru","Baroda","Belgaon","Berhumpur","Calicut","Chennai","Chapra","Cherapunji"]">  
	</div>
	
	<div class="example example-numbers">
        <h2 class="example-name">Dead Simple</h2>
        <p class="example-description">Suggestions are fetched from the hardcoded local data. </p>

        <div class="demo">
          <input class="typeahead" type="text" placeholder="numbers (1-10)">
        </div>

        <div class="gist">
          <script src="https://gist.github.com/jharding/8764233.js"></script>
        </div>
      </div>
      
      <div class="example example-countries">
        <h2 class="example-name">Transform Remote Data</h2>
        <p class="example-description">Prefetches remote data then transforms it into the proper format.</p>

        <div class="demo">
          <input class="typeahead" type="text" placeholder="countries">
        </div>

        <div class="gist">
          <script src="https://gist.github.com/jharding/8156031.js"></script>
        </div>
      </div>
      
       <div class="example example-films">
        <h2 class="example-name">Prefetch Backed by Remote</h2>
        <p class="example-description">Prefetches some data then relies on remote requests for suggestions when prefetched data is insufficient.</p>

        <div class="demo">
          <input class="typeahead" type="text" placeholder="best picture winners">
        </div>

        <div class="gist">
          <script src="https://gist.github.com/jharding/8156071.js"></script>
        </div>
      </div>

	
</div>
<script>  
 var subjects = ['PHP', 'MySQL', 'SQL', 'PostgreSQL', 'HTML', 'CSS', 'HTML5', 'CSS3', 'JSON'];   
$('#search').typeahead({source: subjects})  

// instantiate the bloodhound suggestion engine
var numbers = new Bloodhound({
datumTokenizer: function(d) { return Bloodhound.tokenizers.whitespace(d.num); },
queryTokenizer: Bloodhound.tokenizers.whitespace,
local: [
{ num: 'one' },
{ num: 'two' },
{ num: 'three' },
{ num: 'four' },
{ num: 'five' },
{ num: 'six' },
{ num: 'seven' },
{ num: 'eight' },
{ num: 'nine' },
{ num: 'ten' }
]
});
 
// initialize the bloodhound suggestion engine
numbers.initialize();
 
// instantiate the typeahead UI
$('.example-numbers .typeahead').typeahead(null, {
displayKey: 'num',
source: numbers.ttAdapter()
});

var countries = new Bloodhound({
	datumTokenizer: function(d) { return Bloodhound.tokenizers.whitespace(d.name); },
	queryTokenizer: Bloodhound.tokenizers.whitespace,
	limit: 10,
	prefetch: {
	url: '../customer/view',
	filter: function(list) {
	return $.map(list, function(customer) { return { name: customer.name }; });
	}
	}
	});
	 
	countries.initialize();
	 
	$('.example-countries .typeahead').typeahead(null, {
	name: 'countries',
	displayKey: 'name',
	source: countries.ttAdapter()
	});
	
	var films = new Bloodhound({
		datumTokenizer: function(d) { return Bloodhound.tokenizers.whitespace(d.value); },
		queryTokenizer: Bloodhound.tokenizers.whitespace,
		remote: '../customer/view?q=2',
		prefetch: '../customer/view'
		});
		 
		films.initialize();
		 
		$('.example-films .typeahead').typeahead(null, {
		displayKey: 'value',
		source: films.ttAdapter()
		});
	
</script>  



