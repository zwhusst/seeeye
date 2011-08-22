<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
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
				<div class="changepwd">
					<h1>修改密码</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_CHANGEPWD%>"
						method="post">
						<p>
							原始密码*:
							<form:password path="<%=FormConstants.FIELD_PASSWORD%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_PASSWORD%>"
								class="error" />
						</p>
						<p>
							设置新的密码*:
							<form:password path="<%=FormConstants.FIELD_NEW_PASSWORD1%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_NEW_PASSWORD1%>"
								class="error" />
						</p>
						<p>
							重复新的密码*:
							<form:password path="<%=FormConstants.FIELD_NEW_PASSWORD2%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_NEW_PASSWORD2%>"
								class="error" />
						</p>
						<p>
							<input name="changepwd" type="submit" value="确认" class="loginbut" />
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