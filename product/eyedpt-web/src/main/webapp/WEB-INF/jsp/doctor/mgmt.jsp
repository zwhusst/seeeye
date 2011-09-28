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
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/profile.js"/>"></script>
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
			<div class="container2 left">
				<div class="mgmt">
					<h1>医生管理</h1>
					<table>
						<thead>
							<tr>
								<th>序号</th>
								<th>员工编号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>职称</th>
								<th>行政岗位</th>
								<th>专家级别</th>
								<th>导师类别</th>
								<th>账号</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							    List<DoctorMgmtItem> items = DoctorMgmtHelper.INSTANCE.getItems();
							    int i = 1;
							%>
							<c:forEach var="item" items="<%=items%>">
								<tr>
									<td><%=i++%></td>
									<td>${item.employeeid}</td>
									<td>${item.realname}</td>
									<td>${item.gender.label}</td>
									<td>${item.title.label}</td>
									<td>${item.admintitle.label}</td>
									<td>${item.expertrank.label}</td>
									<td>${item.supervisortype.label}</td>
									<td>${item.name}</td>
									<td>
										<button type="button" onclick="editDoctor('${item.employeeid}')">编辑</button>
										<button type="button" onclick="delDoctor('${item.employeeid}')">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="<c:url value="/doctor/register"/>">注册</a>
				</div>
			</div>
			<!-- /container -->
		</div>
		<!-- /content -->

		<%@ include file="../fragments/footer.jspf"%>
	</div>
</body>
</html>