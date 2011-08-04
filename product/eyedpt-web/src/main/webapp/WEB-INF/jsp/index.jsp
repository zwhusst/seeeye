<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
<%@ page import="com.ehealth.eyedpt.dal.entities.User"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="resources/css/default-style.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="resources/scripts/jquery.js"></script>
<script type="text/javascript" src="resources/scripts/cufon-yui.js"></script>
<script type="text/javascript" src="resources/scripts/cufon-replace.js"></script>

<!--[if IE 6]>
    <script type="text/javascript" src="resources/scripts/ie_png.js"></script>
     <script type="text/javascript">
       ie_png.fix('.png');
     </script>
<![endif]-->
</head>

<body>
	<div class="main">
		<%@ include file="common/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<div class="loginwrap">
					<c:if test="${sessionScope.user!=null}">
						<h1>用户面板</h1>
						<p>
							欢迎，<%=((User) session.getAttribute("user")).getName()%>!
						</p>
						<p>
							<a href="<c:url value="/logout" />">退出</a>
						</p>
					</c:if>
					<c:if test="${sessionScope.user==null}">
						<h1>用户登录</h1>
						<form action="<c:url value="/login" />" method="post">
							<p>
								账户: <input name="name" type="text" class="inputtext" />
							</p>
							<p>
								密码: <input name="password" type="password" class="inputtext" />
							</p>
							<p>
								<input name="login" type="submit" value="登录" class="loginbut">
								<input name="register" type="submit" value="注册" class="loginbut">
							</p>
						</form>
					</c:if>
				</div>
				<div>
					<h1>眼科之家</h1>
					<ul>
						<li><a href="#">关于眼科</a></li>
						<li><a href="#">预约挂号</a></li>
						<li><a href="#">导医服务</a></li>
						<li><a href="#">咨询专家</a></li>
						<li><a href="#">升级考辅导站</a></li>
					</ul>
				</div>
			</div>
			<!-- container -->
			<div class="container left">
				<div class="newswrap">
					<img src="resources/images/news.jpg" alt="">
					<div>
						<a href="#" class="newsleftlink">眼科相关新闻</a> <a href="#"
							class="newsrightlink">眼科专家风采</a>
					</div>
				</div>
			</div>
			<!-- /container -->

			<%@ include file="common/sidebar.jspf"%>
		</div>
		<!-- /content -->

		<%@ include file="common/footer.jspf"%>
	</div>
</body>
</html>