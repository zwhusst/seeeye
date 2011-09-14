<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.mvc.constants.FormConstants"%>
<%@ page import="com.ehealth.eyedpt.mvc.constants.SessionConstants"%>
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
	src="<c:url value="/resources/scripts/common-ui.js"/>"></script>
</head>

<body>
	<c:if test="${RESULT_FORGOTPWD}">
		<%
		    session.setAttribute(SessionConstants.RESULT_FORGOTPWD,
								Boolean.FALSE);
		%>
		<script type="text/javascript">
			alert("密码已发送到绑定邮箱，请查收。");
			location.href = "..";
		</script>
	</c:if>

	<div class="main">
		<%@ include file="../fragments/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<%@ include file="../fragments/navigator.jspf"%>
			</div>

			<!-- container -->
			<div class="container left">
				<div class="forgotpwd">
					<h1>忘记密码</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_FORGOTPWD%>"
						method="post">
						<p>
							账户*:
							<form:input path="<%=FormConstants.FIELD_NAME%>"
								class="inputtext" />
							<form:errors path="<%=FormConstants.FIELD_NAME%>" class="error" />
						</p>
						<p>
							验证码: <input type="text" name="checkcode" class="inputtext"
								id="checkcode" /> <img src="<c:url value="/images/checkcode"/>"
								class="inline" id="img_checkcode">看不清？<a href="#"
								id="change_checkcode">换一张</a><span class="error">${MESSAGE_CHECKCODE}</span>
						</p>
						<p>
							<input name="forgotpwd" type="submit" value="提交" class="loginbut" />
							<a href="<c:url value="/"/>">返回</a>
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