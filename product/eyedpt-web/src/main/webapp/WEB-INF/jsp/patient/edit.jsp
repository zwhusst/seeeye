<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.Gender"%>
<%@ page import="com.ehealth.eyedpt.dal.entities.enums.RegistryType"%>
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
	src="<c:url value="/resources/scripts/city.js"/>"></script>
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
					<form:form modelAttribute="<%=FormConstants.BEAN_PATIENT%>"
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
							省份*:
							<form:select path="<%=FormConstants.FIELD_PROVINCE%>"
								id="province" />
							<form:errors path="<%=FormConstants.FIELD_PROVINCE%>"
								class="error" />
						</p>
						<p>
							城市*:
							<form:select path="<%=FormConstants.FIELD_CITY%>" id="city" />
							<form:errors path="<%=FormConstants.FIELD_CITY%>" class="error" />
						</p>
						<p>
							注册方式*:
							<form:radiobutton path="<%=FormConstants.FIELD_REG_TYPE%>"
								value="<%=RegistryType.ID.name()%>"
								label="<%=RegistryType.ID.getLabel()%>" />
							<form:radiobutton path="<%=FormConstants.FIELD_REG_TYPE%>"
								value="<%=RegistryType.MEDICARE.name()%>"
								label="<%=RegistryType.MEDICARE.getLabel()%>" />
							<form:errors path="<%=FormConstants.FIELD_REG_TYPE%>"
								class="error" />
						</p>
						<p>
							注册号码*:
							<form:input path="<%=FormConstants.FIELD_REG_NO%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_REG_NO%>" class="error" />
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
							传真号码:
							<form:input path="<%=FormConstants.FIELD_FAX%>" class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_FAX%>" class="error" />
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