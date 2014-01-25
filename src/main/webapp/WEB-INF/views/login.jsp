<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true"%>
<html lang="en">
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
	<c:url value="" />
	<form method="post" id="loginForm"
		action="<c:url value="/j_spring_security_check" />">
		<input type="hidden" id="timeZone" name="timeZoneVal" value="">
		<fieldset id="username" style="padding-top: 5%; padding-right: 3%">
			<label for="login"
				style="float: left; padding-left: 5%; padding-top: 2%"><strong>Email
					ID</strong></label> <input type="text" name="j_username" id="j_username"
				placeholder="Email ID" style="float: right; padding-right: 10%"><br>
		</fieldset>
		<fieldset id="pwd" style="padding-top: 3%; padding-right: 3%">
			<label for="password"
				style="float: left; padding-left: 5%; padding-top: 2%"><strong>Password</strong></label>
			<input type="password" name="j_password" id="j_password"
				placeholder="Password" style="float: right; padding-right: 10%"><br>
		</fieldset>
		<fieldset id="pwd"
			style="padding-top: 3%; padding-right: 3%; width: 70%; display: inline-block; float: center">
			<input type="checkbox" name="_spring_security_remember_me"
				id="_spring_security_remember_me"
				style="float: left; margin-left: 10%; margin-top: 3%"> <label
				style="float: left; padding-left: 3%; padding-top: 2%"><strong>Remember
					Me on this Computer?</strong></label><br>
		</fieldset>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div style="padding: 4%; float: center">
			<input type="submit" value="Login Now"
				style="padding-left: 5%; padding-right: 5%;">
		</div>
	</form>
</body>
</html>