<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.Gender"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.DoctorTitle"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.ExpertRank"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.SupervisorType"%>
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
<link href="<c:url value="/resources/css/jquery-ui.css"/>"
	type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/css/jquery-ui-ext.css"/>"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery-ui.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery-ui-i18n.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/common-ui.js"/>"></script>
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
				<div class="register">
					<h1>医生注册</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_DOCTOR%>"
						method="post" enctype="multipart/form-data">
						<fieldset>
							<legend>账户信息</legend>
							<p>
								<form:label path="<%=FormConstants.FIELD_NAME%>">账号*: </form:label>
								<form:input path="<%=FormConstants.FIELD_NAME%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_NAME%>" class="error" />
							</p>
							<p>
								<label for="new_pwd">密码*: </label>
								<form:password path="<%=FormConstants.FIELD_PASSWORD%>"
									class="inputtext" id="new_pwd" />
								<form:errors path="<%=FormConstants.FIELD_PASSWORD%>"
									class="error" />
							</p>
							<p>
								<label for="repeat_pwd">再次输入密码*: </label> <input type="password"
									class="inputtext" id="repeat_pwd" /> <span class="error"
									id="error_pwd"></span>
							</p>
						</fieldset>
						<fieldset>
							<legend>个人信息</legend>
							<p>
								<form:label path="<%=FormConstants.FIELD_REAL_NAME%>">真实姓名*: </form:label>
								<form:input path="<%=FormConstants.FIELD_REAL_NAME%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_REAL_NAME%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_GENDER%>">性别*: </form:label>
								<form:radiobutton path="<%=FormConstants.FIELD_GENDER%>"
									value="<%=Gender.M.name()%>" label="<%=Gender.M.getLabel()%>" />
								<form:radiobutton path="<%=FormConstants.FIELD_GENDER%>"
									value="<%=Gender.F.name()%>" label="<%=Gender.F.getLabel()%>" />
								<form:errors path="<%=FormConstants.FIELD_GENDER%>"
									class="error" />
							</p>
							<p>
								<label for="ubirthday">生日: </label>
								<form:input path="<%=FormConstants.FIELD_BIRTHDAY%>"
									class="inputdate" id="ubirthday" />
								<form:errors path="<%=FormConstants.FIELD_BIRTHDAY%>"
									class="error" />
							</p>
							<p>
								年龄*:
								<form:select path="<%=FormConstants.FIELD_AGE%>"
									items="<%=FormConstants.AGE_RANGE%>" id="uage" />
								<form:errors path="<%=FormConstants.FIELD_AGE%>" class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_EMAIL%>">邮箱地址*: </form:label>
								<form:input path="<%=FormConstants.FIELD_EMAIL%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_EMAIL%>" class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_CELLPHONE%>">手机号码*: </form:label>
								<form:input path="<%=FormConstants.FIELD_CELLPHONE%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_CELLPHONE%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_TELEPHONE%>">固定电话: </form:label>
								<form:input path="<%=FormConstants.FIELD_TELEPHONE%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_TELEPHONE%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_ADDRESS%>">地址*: </form:label>
								<form:input path="<%=FormConstants.FIELD_ADDRESS%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_ADDRESS%>"
									class="error" />
							</p>
						</fieldset>
						<fieldset>
							<legend>工作信息</legend>
							<p>
								<form:label path="<%=FormConstants.FIELD_EMPLOYEE_ID%>">员工编号*: </form:label>
								<form:input path="<%=FormConstants.FIELD_EMPLOYEE_ID%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_EMPLOYEE_ID%>"
									class="error" />
							</p>
							<p>
								职称*:
								<form:select path="<%=FormConstants.FIELD_TITLE%>">
									<form:options items="<%=DoctorTitle.values()%>"
										itemLabel="label" itemValue="name" />
								</form:select>
								<form:errors path="<%=FormConstants.FIELD_TITLE%>" class="error" />
							</p>
							<p>
								行政岗位:
								<form:select path="<%=FormConstants.FIELD_ADMIN_TITLE%>"
									itemValue="<%=DoctorAdminTitle.NA.name()%>">
									<form:options items="<%=DoctorAdminTitle.values()%>"
										itemLabel="label" itemValue="name" />
								</form:select>
								<form:errors path="<%=FormConstants.FIELD_ADMIN_TITLE%>"
									class="error" />
							</p>
							<p>
								专家级别:
								<form:select path="<%=FormConstants.FIELD_EXPERT_RANK%>"
									itemValue="<%=ExpertRank.NA.name()%>">
									<form:options items="<%=ExpertRank.values()%>"
										itemLabel="label" itemValue="name" />
								</form:select>
								<form:errors path="<%=FormConstants.FIELD_EXPERT_RANK%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_FIRST_RECRUIT%>">参加工作日期: </form:label>
								<form:input path="<%=FormConstants.FIELD_FIRST_RECRUIT%>"
									class="inputdate" />
								<form:errors path="<%=FormConstants.FIELD_FIRST_RECRUIT%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_LAST_PROMOTE%>">上次晋升日期: </form:label>
								<form:input path="<%=FormConstants.FIELD_LAST_PROMOTE%>"
									class="inputdate" />
								<form:errors path="<%=FormConstants.FIELD_LAST_PROMOTE%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_SPECIALITIES%>">专业特长*: </form:label>
								<form:input path="<%=FormConstants.FIELD_SPECIALITIES%>"
									class="inputtext long" />
								<form:errors path="<%=FormConstants.FIELD_SPECIALITIES%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_COLLEAGE%>">毕业院校: </form:label>
								<form:input path="<%=FormConstants.FIELD_COLLEAGE%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_COLLEAGE%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_MAJOR%>">专业: </form:label>
								<form:input path="<%=FormConstants.FIELD_MAJOR%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_MAJOR%>" class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_SECOND_MAJOR%>">亚专业: </form:label>
								<form:input path="<%=FormConstants.FIELD_SECOND_MAJOR%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_SECOND_MAJOR%>"
									class="error" />
							</p>
							<p>
								最高学位:
								<form:select path="<%=FormConstants.FIELD_DEGREE%>"
									items="<%=FormConstants.DEGREE_RANGE%>" />
								<form:errors path="<%=FormConstants.FIELD_DEGREE%>"
									class="error" />
							</p>
							<p>
								最高学历:
								<form:select path="<%=FormConstants.FIELD_EDUCATION%>"
									items="<%=FormConstants.EDUCATION_RANGE%>" />
								<form:errors path="<%=FormConstants.FIELD_EDUCATION%>"
									class="error" />
							</p>
							<p>
								导师信息:
								<button type="button" onclick="addSupervisor()">增加</button>
							</p>
							<table id="stbl">
								<thead>
									<tr>
										<th>类别</th>
										<th>院校</th>
									</tr>
								</thead>
								<tbody>
									<tr id="s1">
										<td><form:select
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE1%>"
												itemValue="<%=SupervisorType.NA.name()%>">
												<form:options items="<%=SupervisorType.values()%>"
													itemLabel="label" itemValue="name" />
											</form:select> <form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE1%>"
												class="error" />
										</td>
										<td><form:input
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE1%>"
												class="inputtext" /> <form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE1%>"
												class="error" />
										</td>
									</tr>
									<tr id="s2">
										<td><form:select
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE2%>"
												itemValue="<%=SupervisorType.NA.name()%>">
												<form:options items="<%=SupervisorType.values()%>"
													itemLabel="label" itemValue="name" />
											</form:select> <form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE2%>"
												class="error" />
										</td>
										<td><form:input
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE2%>"
												class="inputtext" />
											<button type="button" onclick="delSupervisor('s2')">删除</button>
											<form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE2%>"
												class="error" /></td>
									</tr>
									<tr id="s3">
										<td><form:select
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE3%>"
												itemValue="<%=SupervisorType.NA.name()%>">
												<form:options items="<%=SupervisorType.values()%>"
													itemLabel="label" itemValue="name" />
											</form:select> <form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_TYPE3%>"
												class="error" />
										</td>
										<td><form:input
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE3%>"
												class="inputtext" />
											<button type="button" onclick="delSupervisor('s3')">删除</button>
											<form:errors
												path="<%=FormConstants.FIELD_SUPERVISOR_COLLEGE3%>"
												class="error" />
										</td>
									</tr>
								</tbody>
							</table>
						</fieldset>
						<fieldset>
							<legend>附加信息</legend>
							<p>
								<label for="uphoto">照片(小于2M): </label> <input name="_photo"
									type="file" value="照片" class="inputtext" id="uphoto" /> <span
									class="error" id="error_uphoto"></span> <img width="128px"
									id="uphoto_preview" />
							</p>
							<p>
								个人简介(2000字以内):
								<form:textarea path="<%=FormConstants.FIELD_DESCRIPTION%>"
									rows="4" cols="64" />
								<form:errors path="<%=FormConstants.FIELD_DESCRIPTION%>"
									class="error" />
							</p>
						</fieldset>
						<p>
							<input type="submit" value="注册" class="loginbut" />
						</p>
					</form:form>
				</div>
			</div>
			<!-- /container -->

			<%@ include file="../fragments/sidebar.jspf"%>
		</div>
		<!-- /content -->

		<%@ include file="../fragments/footer.jspf"%>
	</div>

	<script type="text/javascript">
		$(function() {
			$("img#uphoto_preview").hide();
		});
	</script>
</body>
</html>