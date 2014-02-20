<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="footer">
	<div class="container">
		<p></p>
		<p class="text-muted ui-widget ui-helper-reset" align="center">		
			<spring:message code="ssais.footer" />
		</p>
	</div>
</div>




<!-- Bootstrap core JavaScript -->
<!-- Placed at the end of the document so the pages load faster -->
<script	src="${pageContext.request.contextPath}/resources/js/bootstrap-3.1.0/js/bootstrap.min.js"></script>

<!-- Angular core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/angular-1.2.12/angular.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-1.2.12/angular-route.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-1.2.12/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/DashboardController.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/CustomerController.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/AgentController.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/filters.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>