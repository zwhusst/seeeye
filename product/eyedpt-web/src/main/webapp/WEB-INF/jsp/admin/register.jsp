<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.mvc.view.helpers.RoleHelper"%>
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
				<div class="register">
					<h1>管理员注册</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_ADMIN%>"
						method="post">
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
							<label for="repeat_pwd">再次输入密码*: </label>
							<input type="password" class="inputtext" id="repeat_pwd" />
							<span class="error" id="error_pwd"></span>
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_EMAIL%>">邮箱地址*: </form:label>
							<form:input path="<%=FormConstants.FIELD_EMAIL%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_EMAIL%>" class="error" />
						</p>
						<p>
							<form:label path="<%=FormConstants.FIELD_ROLESET%>">权限*: </form:label>
							<form:checkboxes path="<%=FormConstants.FIELD_ROLESET%>"
								items="<%=RoleHelper.ROLESET%>" />
							<form:errors path="<%=FormConstants.FIELD_ROLESET%>" class="error" />
						</p>
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
</body>
</html>