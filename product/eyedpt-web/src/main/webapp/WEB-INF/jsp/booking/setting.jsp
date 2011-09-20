<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page
	import="com.ehealth.eyedpt.mvc.view.helpers.BookingSettingHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.BookingSettingItem"%>
<%@ page
	import="com.ehealth.eyedpt.mvc.view.helpers.BookingRosterHelper"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.models.BookingRosterItem"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.Weekday"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.TimeSlot"%>
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.mvc.constants.ViewConstants"%>
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
					<div id="caps">
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
								    List<BookingSettingItem> settingItems = BookingSettingHelper.INSTANCE.getItems();
								    int i = 1;
								%>
								<c:forEach var="item" items="<%=settingItems%>">
									<tr>
										<td><%=i%></td>
										<td>${item.employeeid}</td>
										<td>${item.realname}</td>
										<td>${item.expertrank.label}</td>
										<td>${item.servicetime}</td>
										<td><c:if test="${!item.active}">
												<button type="button"
													onclick="activate('${item.employeeid}')">开通</button>
												<button type="button" onclick="view(<%=i%>)">查看</button>
												<button type="button" onclick="setcap('${item.employeeid}')">设置</button>
												<button type="button"
													onclick="deactivate('${item.employeeid}')">停诊</button>
											</c:if> <c:if test="${item.active}">
												<button type="button" onclick="view(<%=i%>)">查看</button>
												<button type="button" onclick="setcap('${item.employeeid}')">设置</button>
												<button type="button"
													onclick="deactivate('${item.employeeid}')">停诊</button>
											</c:if></td>
									</tr>
									<%
									    i++;
									%>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<c:if test="${employeeId!=null}">
						<div id="rosters">
							<table>
								<thead>
									<tr>
										<th>序号</th>
										<th>门诊日</th>
										<th>时段</th>
										<th>数量</th>
										<th>操作</th>
									</tr>
								</thead>
								<tr id="proto">
									<td>0</td>
									<td><select>
											<c:forEach var="day" items="<%=Weekday.values()%>">
												<option value="${day.name}">${day.label}</option>
											</c:forEach>
									</select>
									</td>
									<td><select>
											<c:forEach var="slot" items="<%=TimeSlot.values()%>">
												<option value="${slot.name}">${slot.label}</option>
											</c:forEach>
									</select>
									</td>
									<td><select>
											<c:forEach var="cap"
												items="<%=FormConstants.BOOKING_CAPABILITY_RANGE%>">
												<option>${cap}</option>
											</c:forEach>
									</select>
									</td>
									<td>
										<button type="button" name="del">删除</button>
									</td>
								</tr>
								<tbody>
									<%
									    List<BookingRosterItem> rosterItems = BookingRosterHelper.INSTANCE.getItems(request
									                .getParameter(ViewConstants.PARAM_EMPLOYEE_ID));
									        int j = 1;
									        for (BookingRosterItem item : rosterItems)
									        {
									%>
									<tr id="roster<%=j%>">
										<td><%=j%></td>
										<td><select>
												<%
												    for (Weekday day : Weekday.values())
												            {
												                if ( day == item.getDayofweek() )
												                {
												                    out.println("<option value=" + day.getName() + " selected=\"selected\">" + day.getLabel()
												                            + "</option>");
												                }
												                else
												                {
												                    out.println("<option value=" + day.getName() + ">" + day.getLabel() + "</option>");
												                }
												            }
												%>
										</select>
										</td>
										<td><select>
												<%
												    for (TimeSlot slot : TimeSlot.values())
												            {
												                if ( slot == item.getTimeslot() )
												                {
												                    out.println("<option value=" + slot.getName() + " selected=\"selected\">" + slot.getLabel()
												                            + "</option>");
												                }
												                else
												                {
												                    out.println("<option value=" + slot.getName() + ">" + slot.getLabel() + "</option>");
												                }
												            }
												%>
										</select>
										</td>
										<td>
											<%
											    for (int cap : FormConstants.BOOKING_CAPABILITY_RANGE)
											            {
											                if ( cap == item.getCapability() )
											                {
											                    out.println("<option selected=\"selected\">" + cap + "</option>");
											                }
											                else
											                {
											                    out.println("<option>" + cap + "</option>");
											                }
											            }
											%>
										</td>
										<td>
											<button type="button" onclick="delRoster(<%=j%>)">删除</button>
										</td>
									</tr>
									<%
									    j++;
									        }
									%>
								</tbody>
							</table>
							<button type="button" onclick="addRoster()">增加</button>
							<button type="button" onclick="">保存</button>
							<button type="button" onclick="cancel('rosters')">取消</button>
						</div>
					</c:if>
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