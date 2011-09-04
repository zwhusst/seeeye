<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.view.helpers.AdminMgmtHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.AdminMgmtItem"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<link href="<c:url value="/resources/css/default-style.css"/>"
	type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/css/extend-style.css"/>"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/scripts/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/mgmt.js"/>"></script>
</head>

<body>
	<div class="main">
		<%@ include file="../fragments/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<%@ include file="../fragments/userpanel.jspf"%>
				<%@ include file="../fragments/navigator.jspf"%>
			</div>

			<!-- container -->
			<div class="container left">
				<div class="mgmt">
					<h1>权限管理</h1>
					<table>
						<thead>
							<tr>
								<th class="col_no">序号</th>
								<th class="col_name">账号</th>
								<th class="col_ops">操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							    List<AdminMgmtItem> items = AdminMgmtHelper.INSTANCE.getItems();
							    int i = 1;
							%>
							<c:forEach var="item" items="<%=items%>">
								<tr>
									<td class="col_no"><%=i++%></td>
									<td class="col_name">${item.name}</td>
									<td class="col_ops"><button class="delBtn"
											onclick="deleteAdmin('${item.name}')">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="<c:url value="/admin/register"/>">注册</a>
				</div>
			</div>
			<!-- /container -->

			<%@ include file="../fragments/sidebar.jspf"%>
		</div>
		<!-- /content -->

		<%@ include file="../fragments/footer.jspf"%>
	</div>
</body>
</html>