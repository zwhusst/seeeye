<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.Gender"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.DoctorTitle"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.DoctorAdminTitle"%>
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
				<div class="editprofile">
					<h1>编辑档案</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_DOCTOR%>"
						method="post">
						<p>
							<form:hidden path="<%=FormConstants.FIELD_NAME%>" />
							真实姓名*:
							<form:input path="<%=FormConstants.FIELD_REAL_NAME%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_REAL_NAME%>"
								class="error" />
						</p>
						<p>
							性别*:
							<form:radiobutton path="<%=FormConstants.FIELD_GENDER%>"
								value="<%=Gender.M.name()%>" label="<%=Gender.M.getLabel()%>" />
							<form:radiobutton path="<%=FormConstants.FIELD_GENDER%>"
								value="<%=Gender.F.name()%>" label="<%=Gender.F.getLabel()%>" />
							<form:errors path="<%=FormConstants.FIELD_GENDER%>" class="error" />
						</p>
						<p>
							生日:
							<form:input path="<%=FormConstants.FIELD_BIRTHDAY%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_BIRTHDAY%>"
								class="error" />
						</p>
						<p>
							年龄*:
							<form:select path="<%=FormConstants.FIELD_AGE%>"
								items="<%=FormConstants.AGE_RANGE%>" />
							<form:errors path="<%=FormConstants.FIELD_AGE%>" class="error" />
						</p>
						<p>
							邮箱地址*:
							<form:input path="<%=FormConstants.FIELD_EMAIL%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_EMAIL%>" class="error" />
						</p>
						<p>
							手机号码*:
							<form:input path="<%=FormConstants.FIELD_CELLPHONE%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_CELLPHONE%>"
								class="error" />
						</p>
						<p>
							固定电话:
							<form:input path="<%=FormConstants.FIELD_TELEPHONE%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_TELEPHONE%>"
								class="error" />
						</p>
						<p>
							地址*:
							<form:input path="<%=FormConstants.FIELD_ADDRESS%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_ADDRESS%>"
								class="error" />
						</p>
						<p>
							员工编号*:
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
							行政岗位*:
							<form:select path="<%=FormConstants.FIELD_ADMIN_TITLE%>">
								<form:options items="<%=DoctorAdminTitle.values()%>"
									itemLabel="label" itemValue="name" />
							</form:select>
							<form:errors path="<%=FormConstants.FIELD_ADMIN_TITLE%>"
								class="error" />
						</p>
						<p>
							上次晋升日期:
							<form:input path="<%=FormConstants.FIELD_LAST_PROMOTE%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_LAST_PROMOTE%>"
								class="error" />
						</p>
						<p>
							专业特长*:
							<form:input path="<%=FormConstants.FIELD_SPECIALITIES%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_SPECIALITIES%>"
								class="error" />
						</p>
						<p>
							毕业院校:
							<form:input path="<%=FormConstants.FIELD_COLLEAGE%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_COLLEAGE%>"
								class="error" />
						</p>
						<p>
							专业:
							<form:input path="<%=FormConstants.FIELD_MAJOR%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_MAJOR%>" class="error" />
						</p>
						<p>
							亚专业:
							<form:input path="<%=FormConstants.FIELD_SECOND_MAJOR%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_SECOND_MAJOR%>"
								class="error" />
						</p>
						<p>
							最高学位:
							<form:select path="<%=FormConstants.FIELD_DEGREE%>"
								items="<%=FormConstants.DEGREE_RANGE%>" />
							<form:errors path="<%=FormConstants.FIELD_DEGREE%>" class="error" />
						</p>
						<p>
							最高学历:
							<form:select path="<%=FormConstants.FIELD_EDUCATION%>"
								items="<%=FormConstants.EDUCATION_RANGE%>" />
							<form:errors path="<%=FormConstants.FIELD_EDUCATION%>"
								class="error" />
						</p>
						<p>
							博士生导师:
							<form:checkbox
								path="<%=FormConstants.FIELD_DOCTORAL_SUPERVISIOR%>" />
							<form:errors path="<%=FormConstants.FIELD_DOCTORAL_SUPERVISIOR%>"
								class="error" />
						</p>
						<p>
							硕士生导师:
							<form:checkbox path="<%=FormConstants.FIELD_SUPERVISOR%>" />
							<form:errors path="<%=FormConstants.FIELD_SUPERVISOR%>"
								class="error" />
						</p>
						<p>
							<input name="edit" type="submit" value="确认" class="loginbut" />
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
</body>
</html>