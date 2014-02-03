<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="ui-widget ui-helper-reset">
	<p>
		<a href="<spring:url value="/dashboard/view"></spring:url>"> 
			<spring:message	code="menu.lbl.home" />
		</a> |
		<a href="<spring:url value="/customer/page"></spring:url>"> 
			<spring:message	code="menu.lbl.customer" />
		</a> | 
		<a href="<spring:url value="/logout"></spring:url>">
			<spring:message	code="menu.lbl.logout" />
		</a>
	</p>
</div>