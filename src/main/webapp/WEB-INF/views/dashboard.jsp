<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html  ng-app="SmallSavingsAgentApp">
<head>
<head>
<title><spring:message code="dashboard.title"></spring:message></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<jsp:include page="common/include.jsp"></jsp:include>
</head>
<body>
	 <!-- Wrap all page content here -->
    <div id="wrap">
		<!-- Header -->
		<jsp:include page="common/header.jsp"></jsp:include>
		
		<!-- Content -->
		<div ng-view=''></div>
	</div>	
	<!-- Footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>