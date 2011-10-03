<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.helpers.BookingHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.BookingItem"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.BookingStatus"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.TimeSlot"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.NotifyType"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<link href="<c:url value="/resources/css/default-style.css"/>"
	type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/css/extend-style.css"/>"
	type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/css/popup.css"/>" type="text/css"
	rel="stylesheet" />

<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common-ui.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/booking.js"/>"></script>
</head>

<body>
	<div id="popup_overlay"></div>
	<div id="popup_shell">
		<div id="popup_view" class="popup">
			<c:if test="${bookingBean!=null}">
				<form:form modelAttribute="<%=FormConstants.BEAN_BOOKING%>">
					<fieldset>
						<legend>基本信息</legend>
						<p>
							<form:label path="<%=FormConstants.FIELD_BOOKING_ID%>">预约单号: </form:label>
							<form:input path="<%=FormConstants.FIELD_BOOKING_ID%>"
								readonly="true" class="inputtext" />
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_PATIENT_NAME%>">病人账号: </form:label>
							<form:input path="<%=FormConstants.FIELD_PATIENT_NAME%>"
								readonly="true" class="inputtext" />
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_DOCTOR_NAME%>">医生账号: </form:label>
							<form:input path="<%=FormConstants.FIELD_DOCTOR_NAME%>"
								readonly="true" class="inputtext" />
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_BOOKING_DATE%>">预约日期: </form:label>
							<form:input path="<%=FormConstants.FIELD_BOOKING_DATE%>"
								readonly="true" class="inputtext" />
						</p>
						<p>
							预约时段:
							<form:select path="<%=FormConstants.FIELD_TIMESLOT%>"
								disabled="true">
								<form:options items="<%=TimeSlot.values()%>" itemLabel="label"
									itemValue="name" />
							</form:select>
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_POST_DATE%>">下单日期: </form:label>
							<form:input path="<%=FormConstants.FIELD_POST_DATE%>"
								readonly="true" class="inputtext" />
						</p>
						<p>
							当前状态:
							<form:select path="<%=FormConstants.FIELD_STATUS%>"
								disabled="true">
								<form:options items="<%=BookingStatus.values()%>"
									itemLabel="label" itemValue="name" />
							</form:select>
						</p>
					</fieldset>
					<fieldset>
						<legend>通知设定</legend>
						<p>
							<form:label path="<%=FormConstants.FIELD_NOTIFY_TYPE%>">通知类型: </form:label>
							<form:radiobutton path="<%=FormConstants.FIELD_NOTIFY_TYPE%>"
								value="<%=NotifyType.SMS.name()%>"
								label="<%=NotifyType.SMS.getLabel()%>" disabled="true" />
							<form:radiobutton path="<%=FormConstants.FIELD_NOTIFY_TYPE%>"
								value="<%=NotifyType.EMAIL.name()%>"
								label="<%=NotifyType.EMAIL.getLabel()%>" disabled="true" />
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_NOTIFY_TIME%>">通知时间: </form:label>
							<form:input path="<%=FormConstants.FIELD_NOTIFY_TIME%>"
								readonly="true" class="inputtext" />
						</p>
					</fieldset>
				</form:form>
			</c:if>
			<p>
				<button type="button" onclick="closePopup()">返回</button>
			</p>
		</div>
		<div id="popup_update" class="popup">
			<p>
				预约状态*: <select>
					<%
					    for (BookingStatus s : BookingStatus.values())
					    {
					        out.println("<option value='" + s.getName() + "'>" + s.getLabel() + "</option>");
					    }
					%>
				</select>
			</p>
			<p>
				备注(500字以内)*:
				<textarea rows="4" cols="64"></textarea>
			</p>
			<p>
				<button type="button" onclick="doUpdateBookingStatus()">确定</button>
				<button type="button" onclick="closePopup()">取消</button>
			</p>
		</div>
	</div>
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
									<td>${item.status.label}</td>
									<td>
										<button type="button"
											onclick="popupViewBookingDetails('${item.bookingid}')">查看</button>
										<button type="button"
											onclick="popupUpdateBookingStatus('${item.bookingid}')">更新</button>
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
		</div>
		<!-- /content -->

		<%@ include file="../fragments/footer.jspf"%>
	</div>
</body>
</html>