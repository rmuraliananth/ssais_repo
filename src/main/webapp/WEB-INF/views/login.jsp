<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	 <!-- Wrap all page content here -->
    <div id="wrap">
        
		<!-- Header -->
		<jsp:include page="common/header.jsp"></jsp:include>
			
		<!-- Container -->
		<div class="container theme-showcase" role="main">
			<div class="jumbotron">
				<div class="row">
					<div class="col-sm-2"></div>		
					<div class="col-sm-7">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title"><spring:message code="login.lbl.header" /></h3>
							</div>
							<div class="panel-body  ui-widget">
								<form method="post" id="loginForm" class="navbar-form" action="<c:url value="/j_spring_security_check" />">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									
							      	<div class="row">
										<div class="col-sm-12">
											<c:if test="${not empty errorMessage}">
												<div class="alert alert-danger">
										        	<c:out value="${errorMessage}"></c:out>
										      	</div>
								      		</c:if>						      	
										</div>	
									</div>
									
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message code="login.lbl.username" />
										</div>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="j_username" id="j_username" placeholder="Username" required autofocus>
										</div>									
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
											<spring:message  code="login.lbl.password" />
										</div>
										<div class="col-sm-4"> 
											<input type="password" class="form-control" name="j_password" id="j_password"  placeholder="Password" required>
										</div>									
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
										</div>
										<div class="col-sm-4">
											<input type="checkbox" name="_spring_security_remember_me" id="_spring_security_remember_me">
											<spring:message code="login.lbl.rememberme" />
										</div>									
									</div>
									<p></p>
									<div class="row">
										<div class="col-sm-2"></div>
										<div class="col-sm-3">
										</div>
										<div class="col-sm-4">
											<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="login.btn.submit" />" name="Login">
											<input type="reset" class="btn btn-sm btn-primary" value="<spring:message code="login.btn.reset" />" name="Reset">
										</div>									
									</div>	
								</form>
								<p></p>		
							</div>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>			
			</div>		
		</div>	
	</div>
	
	<!-- Footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>