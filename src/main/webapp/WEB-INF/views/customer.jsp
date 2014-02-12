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
<title><spring:message code="customer.title"></spring:message></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<jsp:include page="common/include.jsp"></jsp:include>
</head>
<body>
	<h2>
		<spring:message code="customer.title" />
	</h2>
	<jsp:include page="common/menu.jsp"></jsp:include>
	<div>

		<table id="customerList"></table>
		<div id="customerPager"></div>

		<script type="text/javascript">
			$(function() {

				var colNames = [
						'<spring:message code="customer.lbl.id"/>',
						'<spring:message code="customer.lbl.name"/>',
						'<spring:message code="customer.account.lbl.account_no"/>',
						'<spring:message code="customer.account.lbl.principal_amount"/>',
						'<spring:message code="customer.account.lbl.open_date"/>',
						'<spring:message code="customer.account.lbl.maturity_date"/>',
						'<spring:message code="customer.lbl.phone_no"/>',
						'<spring:message code="customer.lbl.email_id"/>',
						'<spring:message code="customer.lbl.address"/>',
						'<spring:message code="customer.account.lbl.id"/>',
						'<spring:message code="customer.account.lbl.name"/>' ];

				var colModel = [
						{
							name : 'id',
							index : 'id',
							align : "center",
							width : 50

						},
						{
							name : 'name',
							index : 'customer_name',
							align : "left",
							width : 150
						},
						{
							name : 'account.accountNo',
							index : 'account_no',
							align : "center",
							width : 150
						},
						{
							name : '<spring:message code="customer.account.lbl.principal_amount"/>',
							index : 'principal_amount',
							align : "right",
							width : 150
						},
						{
							name : '<spring:message code="customer.account.lbl.open_date"/>',
							index : 'open_date',
							align : "center",
							width : 150
						},
						{
							name : '<spring:message code="customer.account.lbl.maturity_date"/>',
							index : 'maturity_date',
							align : "center",
							width : 150
						},
						{
							name : '<spring:message code="customer.lbl.phone_no"/>',
							index : 'phone_no',
							align : "left",
							width : 150
						},
						{
							name : '<spring:message code="customer.lbl.email_id"/>',
							index : 'email_id',
							align : "left",
							width : 150
						},
						{
							name : '<spring:message code="customer.lbl.address"/>',
							index : 'address',
							align : "left",
							width : 150
						},
						{
							name : 'account.id',
							index : 'account_id',
							align : "center",
							width : 150
						},
						{
							name : '<spring:message code="customer.account.lbl.name"/>',
							index : 'account_name',
							align : "left",
							width : 150
						} ];

				$("#customerList").jqGrid({
					url : 'view?q=2',
					datatype : "json",
					colNames : colNames,
					colModel : colModel,
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#customerPager',
					sortname : 'id',
					viewrecords : true,
					sortorder : "desc",
					autowidth : true,
					rownumbers : true,
					height : "100%",
					editurl : "server.php",
					caption : '<spring:message code="customer.lbl.header"/>'
				});
				$("#customerList").jqGrid('navGrid', '#customerPager', {
					edit : false,
					add : false,
					del : false
				});

			});
		</script>
	</div>
</body>
</html>