<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="navbar-collapse collapse ui-widget ui-helper-reset">
	<ul class="nav navbar-nav navbar-right" ng-controller="MenuController">
		<li ng-class="{ active: isActive('/home')}">
			<a href="<spring:url value="#/home"></spring:url>"> 
				<spring:message	code="menu.lbl.home" />
				
			</a>
		</li>
		<li ng-class="{ active: isActive('/customer')}">
			<a href="<spring:url value="#/customer"></spring:url>"> 
				<spring:message	code="menu.lbl.customer" />
			</a>
		</li>
		<li ng-class="{ active: isActive('/agent')}">
			<a href="<spring:url value="#/agent"></spring:url>"> 
				<spring:message	code="menu.lbl.agent" />
			</a>
		</li>
		<li ng-class="{ active: isActive('/postoffice')}">
			<a href="<spring:url value="#/postoffice"></spring:url>"> 
				<spring:message	code="menu.lbl.postoffice" />
			</a>
		</li>
		<li ng-class="{ active: isActive('/formaslass6')}">
			<a href="<spring:url value="#/formaslass6"></spring:url>"> 
				<spring:message	code="menu.lbl.formaslass6" />
			</a>
		</li>
		<li>
			<a href="<spring:url value="/logout"></spring:url>">
			<spring:message	code="menu.lbl.logout" />
			</a>
		</li>
	</ul>	
</div>