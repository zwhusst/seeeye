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
					<form:form modelAttribute="<%=FormConstants.BEAN_ADMIN%>"
						method="post">
						<p>
							<form:hidden path="<%=FormConstants.FIELD_NAME%>" />
							邮箱地址*:
							<form:input path="<%=FormConstants.FIELD_EMAIL%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_EMAIL%>" class="error" />
						</p>
						<c:if test="${param.username!=null}">
							<p>
								权限*:
								<form:checkboxes path="<%=FormConstants.FIELD_ROLESET%>"
									items="<%=RoleHelper.ROLESET%>" />
								<form:errors path="<%=FormConstants.FIELD_ROLESET%>"
									class="error" />
							</p>
						</c:if>
						<p>
							<input type="submit" value="确认" class="loginbut" />
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