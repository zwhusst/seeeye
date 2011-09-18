<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page
	import="com.ehealth.eyedpt.mvc.view.helpers.BookingSettingHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.BookingSettingItem"%>
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
	src="<c:url value="/resources/scripts/booking.js"/>"></script>
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
				<div class="setting">
					<h1>门诊预约设定</h1>
					<table>
						<thead>
							<tr>
								<th>序号</th>
								<th>员工编号</th>
								<th>姓名</th>
								<th>专家级别</th>
								<th>门诊时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							    List<BookingSettingItem> items = BookingSettingHelper.INSTANCE.getItems();
							    int i = 1;
							%>
							<c:forEach var="item" items="<%=items%>">
								<tr id="r<%=i%>">
									<td><%=i%></td>
									<td>${item.employeeid}</td>
									<td>${item.realname}</td>
									<td>${item.expertrank.label}</td>
									<td>${item.servicetime}</td>
									<td><c:if test="${!item.active}">
											<button type="button"
												onclick="activate('${item.employeeid}')">开通</button>
										</c:if> <c:if test="${item.active}">
											<button type="button" onclick="view('r<%=i%>')">查看</button>
											<button type="button" onclick="setcap('${item.employeeid}')">设置</button>
											<button type="button"
												onclick="deactivate('${item.employeeid}')">停诊</button>
										</c:if>
									</td>
								</tr>
								<%
								    i++;
								%>
							</c:forEach>
						</tbody>
					</table>
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