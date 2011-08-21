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
					<ul>
						<li class="headline">
							<span class="col_no"></span>
							<span class="col_name">账号</span>
							<span class="col_ops">操作</span>
						</li>
						<%
						    List<AdminMgmtItem> items = AdminMgmtHelper.INSTANCE.getItems();
							int i = 1;
						%>
						<c:forEach var="item" items="<%=items%>">
							<li>
								<span class="col_no"><%=i++%></span>
								<span class="col_name">${item.name}</span>
								<span class="col_ops">
									<a href="#">删除</a>
								</span>
							</li>
						</c:forEach>
					</ul>
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