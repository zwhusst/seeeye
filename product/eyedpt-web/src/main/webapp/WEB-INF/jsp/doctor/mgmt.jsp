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
			<div class="container left">
				<div class="mgmt">
					<h1>医生管理</h1>
					<table>
						<thead>
							<tr>
								<th class="col_no">序号</th>
								<th class="col_employeeid">员工编号</th>
								<th class="col_realname">姓名</th>
								<th class="col_gender">性别</th>
								<th class="col_title">职称</th>
								<th class="col_admintitle">行政岗位</th>
								<th class="col_admintitle">专家级别</th>
								<th class="col_admintitle">导师类别</th>
								<th class="col_name">账号</th>
								<th class="col_ops">操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							    List<DoctorMgmtItem> items = DoctorMgmtHelper.INSTANCE.getItems();
							    int i = 1;
							%>
							<c:forEach var="item" items="<%=items%>">
								<tr>
									<td class="col_no"><%=i++%></td>
									<td class="col_employeeid">${item.employeeid}</td>
									<td class="col_realname">${item.realname}</td>
									<td class="col_gender">${item.gender.label}</td>
									<td class="col_title">${item.title.label}</td>
									<td class="col_admintitle">${item.admintitle.label}</td>
									<td class="col_expertrank">${item.expertrank.label}</td>
									<td class="col_supervisortype">${item.supervisortype.label}</td>
									<td class="col_name">${item.name}</td>
									<td class="col_ops">
										<button class="btn_edit"
											onclick="editDoctor('${item.employeeid}')">编辑</button>
										<button class="btn_del"
											onclick="deleteDoctor('${item.employeeid}')">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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