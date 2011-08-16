<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.SessionConstants"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<%@ include file="fragments/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<%@ include file="fragments/navigator.jspf"%>
			</div>

			<!-- container -->
			<div class="container left">
				<div class="login">
					<h1>用户登录</h1>
					<form action="<c:url value="/j_spring_security_check"/>"
						method="post">
						<c:if test="${SPRING_SECURITY_LAST_EXCEPTION!=null}">
							<span class="error">${SPRING_SECURITY_LAST_EXCEPTION.message}</span>
							<!-- clear message after shown -->
							<%
							    session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, null);
							%>
						</c:if>
						<p>
							账户: <input name="j_username" type="text" class="inputtext" />
						</p>
						<p>
							密码: <input name="j_password" type="password" class="inputtext" />
						</p>
						<p>
							<input name="login" type="submit" value="登录" class="loginbut" />
						</p>
					</form>
				</div>
			</div>
			<!-- /container -->

			<%@ include file="fragments/sidebar.jspf"%>
		</div>
		<!-- /content -->

		<%@ include file="fragments/footer.jspf"%>
	</div>
</body>
</html>