<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.view.helpers.BookingHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.BookingItem"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.BookingStatus"%>
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
				<div class="mgmt">
					<h1>门诊预约管理</h1>
					<table>
						<thead>
							<tr>
								<th>序号</th>
								<th>预约单号</th>
								<th>用户姓名</th>
								<th>医生姓名</th>
								<th>预约日期</th>
								<th>下单日期</th>
								<th>预约状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<%
							    List<BookingItem> bookingItems = BookingHelper.INSTANCE.getItems(BookingStatus.ACCEPTED);
							    int i = 1;
							%>
							<c:forEach var="item" items="<%=bookingItems%>">
								<tr>
									<td><%=i%></td>
									<td>${item.bookingid}</td>
									<td>${item.patientname}</td>
									<td>${item.doctorname}</td>
									<td>${item.bookingdate}</td>
									<td>${item.postdate}</td>
									<td>${item.status}
										<button type="button" onclick="">更新</button>
									</td>
									<td>
										<button type="button" onclick="">查看</button>
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