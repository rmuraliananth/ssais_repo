<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header ui-widget ui-helper-reset">
			<div class="navbar-brand">
				<spring:message code="ssais.header" />				
			</div>
		</div>	
		<c:if test="${not empty sessionScope.USER_INFO}">			
			<jsp:include page="menu.jsp"></jsp:include>
		</c:if>	
	</div>
	
</div>
