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
								    List<BookingSettingItem> items = BookingSettingHelper.INSTANCE.getItems();
								    int i = 1;
								%>
								<c:forEach var="item" items="<%=items%>">
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
					<c:forEach var="i2" begin="1" end="<%=items.size()%>">
						<div id="rosters${i2}">
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
								<tr id="proto${i2}">
									<td>0</td>
									<td><select>
											<option>周一</option>
											<option>周二</option>
											<option>周三</option>
											<option>周四</option>
											<option>周五</option>
									</select>
									</td>
									<td><select>
											<option>上午</option>
											<option>上午</option>
									</select>
									</td>
									<td><select>
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
									</select>
									</td>
									<td>
										<button type="button" name="pause">暂停</button>
										<button type="button" name="del">删除</button>
									</td>
								</tr>
								<tbody>
									<%
									    int j = 1;
									%>
									<tr id="roster<%=j%>">
										<td><%=j%></td>
										<td><select>
												<option>周一</option>
												<option>周二</option>
												<option>周三</option>
												<option>周四</option>
												<option>周五</option>
										</select>
										</td>
										<td><select>
												<option>上午</option>
												<option>上午</option>
										</select>
										</td>
										<td><select>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
												<option>9</option>
												<option>10</option>
										</select>
										</td>
										<td>
											<button type="button" onclick="">暂停</button>
											<button type="button" onclick="delRoster(${i2}, <%=j%>)">删除</button>
										</td>
									</tr>
									<%
									    j++;
									%>
								</tbody>
							</table>
							<button type="button" onclick="addRoster(${i2})">增加</button>
							<button type="button" onclick="">保存</button>
							<button type="button" onclick="cancel(${i2})">取消</button>
						</div>
					</c:forEach>
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