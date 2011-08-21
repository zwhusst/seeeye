<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.view.helpers.DoctorMgmtHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.DoctorMgmtItem"%>
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
					<h1>医生管理</h1>
					<ul>
						<li class="headline">
							<span class="col_no"></span>
							<span class="col_employeeid">员工编号</span>
							<span class="col_realname">姓名</span>
							<span class="col_gender">性别</span>
							<span class="col_title">职称</span>
							<span class="col_admintitle">行政岗位</span>
							<span class="col_name">账号</span>
							<span class="col_ops">操作</span>
						</li>
						<%
						    List<DoctorMgmtItem> items = DoctorMgmtHelper.INSTANCE.getItems();
						    int i = 1;
						%>
						<c:forEach var="item" items="<%=items%>">
							<li>
								<span class="col_no"><%=i++%></span>
								<span class="col_employeeid">${item.employeeid}</span>
								<span class="col_realname">${item.realname}</span>
								<span class="col_gender">${item.gender.label}</span>
								<span class="col_title">${item.title.label}</span>
								<span class="col_admintitle">${item.admintitle.label}</span>
								<span class="col_name">${item.name}</span>
								<span class="col_ops">
									<a href="#">删除</a>
								</span>
							</li>
						</c:forEach>
					</ul>
					<a href="<c:url value="/doctor/register"/>">注册</a>
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