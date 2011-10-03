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
				<div class="changepwd">
					<h1>修改密码</h1>
					<form:form modelAttribute="<%=FormConstants.BEAN_CHANGEPWD%>"
						method="post">
						<fieldset>
							<p>
								<form:label path="<%=FormConstants.FIELD_PASSWORD%>">原始密码*: </form:label>
								<form:password path="<%=FormConstants.FIELD_PASSWORD%>"
									class="inputtext" />
								<form:errors path="<%=FormConstants.FIELD_PASSWORD%>"
									class="error" />
							</p>
							<p>
								<form:label path="<%=FormConstants.FIELD_NEW_PASSWORD%>">设置新的密码*: </form:label>
								<form:password path="<%=FormConstants.FIELD_NEW_PASSWORD%>"
									class="inputtext" id="new_pwd" />
								<form:errors path="<%=FormConstants.FIELD_NEW_PASSWORD%>"
									class="error" />
							</p>
							<p>
								<label for="repeat_pwd">重复新的密码*: </label> <input type="password"
									class="inputtext" id="repeat_pwd" /> <span class="error"
									id="error_pwd"></span>
							</p>
						</fieldset>
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