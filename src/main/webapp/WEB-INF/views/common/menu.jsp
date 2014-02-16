<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="navbar-collapse collapse ui-widget ui-helper-reset">
	<ul class="nav navbar-nav navbar-right">
		<li class="active">
			<a href="<spring:url value="/dashboard/view"></spring:url>"> 
				<spring:message	code="menu.lbl.home" />
				
			</a>
		</li>
		<li>
			<a id="customer" href="<spring:url value="/customer/page"></spring:url>"> 
				<spring:message	code="menu.lbl.customer" />
			</a>
		</li>
		<li>
			<a href="<spring:url value="/logout"></spring:url>">
			<spring:message	code="menu.lbl.logout" />
			</a>
		</li>
	</ul>	
</div>