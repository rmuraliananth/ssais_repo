<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html lang="en">
<head>
<title><spring:message code="login.title"></spring:message></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<jsp:include page="common/include.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="ui-widget">	
		<form method="post" id="loginForm"
			action="<c:url value="/j_spring_security_check" />">
			<div id="accordion" class="ui-accordion ui-widget ui-helper-reset"
				role="tablist">
				<h3
					class="ui-accordion-header ui-helper-reset ui-state-default ui-accordion-header-active ui-state-active ui-corner-top"
					role="tab" id="ui-accordion-accordion-header-0"
					aria-controls="ui-accordion-accordion-panel-0" aria-selected="true"
					aria-expanded="true" tabindex="0">
					<spring:message code="login.lbl.header" />
				</h3>
				<div
					class="ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active"
					id="ui-accordion-accordion-panel-0"
					aria-labelledby="ui-accordion-accordion-header-0" role="tabpanel"
					aria-hidden="false">

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<fieldset><legend>Welcome</legend>
						
					</fieldset>
					<fieldset id="username">
						<label for="login"><spring:message
								code="login.lbl.username" /></label> <input type="text"
							name="j_username" id="j_username" class="">
					</fieldset>
					<fieldset id="pwd">
						<label for="password"><spring:message
								code="login.lbl.password" /></label> <input type="password"
							name="j_password" id="j_password" placeholder="Password">
					</fieldset>
					<fieldset id="rememberme">
						<input type="checkbox" name="_spring_security_remember_me"
							id="_spring_security_remember_me"> <label><spring:message
								code="login.lbl.rememberme" /></label>
					</fieldset>
					<input type="submit"
						class="ui-button ui-widget ui-state-default ui-corner-all"
						value="<spring:message
					code="login.btn.submit" />"
						name="Login"> <input type="reset"
						class="ui-button ui-widget ui-state-default ui-corner-all"
						value="<spring:message
					code="login.btn.reset" />"
						name="Login">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>