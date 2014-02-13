<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>
<head>
<title><spring:message code="dashboard.title"></spring:message></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<jsp:include page="common/include.jsp"></jsp:include>
</head>
<body>
	<!-- Header -->
	<jsp:include page="common/header.jsp"></jsp:include>
		
	<!-- Container -->
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
				<spring:message code="dashboard.lbl.header" />
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>