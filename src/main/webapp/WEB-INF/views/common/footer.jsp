<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="footer">
	<p class="text-muted">
		<spring:message code="ssais.footer" />
	</p>
</div>




<!-- Bootstrap core JavaScript -->
<!-- Placed at the end of the document so the pages load faster -->
<script	src="${pageContext.request.contextPath}/resources/js/bootstrap-3.1.0/js/bootstrap.min.js"></script>

<!-- Angular core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/angular-1.2.12/angular.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/CustomerController.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/filters.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/directives.js"></script>