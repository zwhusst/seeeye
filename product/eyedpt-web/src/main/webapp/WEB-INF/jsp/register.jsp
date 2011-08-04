<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<link href="resources/css/default-style.css" type="text/css"
	rel="stylesheet">
</head>

<body>
	<div class="main">
		<%@ include file="common/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="register">
				<h1>用户注册</h1>
				<form action="<c:url value="/register" />" method="post">
					<p>
						账户: <input name="name" type="text" class="inputtext" />
					</p>
					<p>
						密码: <input name="password" type="password" class="inputtext" />
					</p>
					<p>
						<input name="register" type="submit" value="注册" class="loginbut">
					</p>
				</form>
			</div>

			<%@ include file="common/sidebar.jspf"%>
		</div>
		<!-- /content -->

		<%@ include file="common/footer.jspf"%>
	</div>
</body>
</html>