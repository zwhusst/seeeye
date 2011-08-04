<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=gbk"%>
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
		<div class="head-holder">
			<div class="head-wrap">
				<a href="#" class="logo"><img src="resources/images/logo.png"
					alt=""> </a>
				<div class="search-block">
					<input type="text" class="text"> <input type="submit"
						value="搜索" class="search-submit">
				</div>
			</div>
		</div>

		<!-- main menu -->
		<div class="main-menu">
			<div class="main-menuwrap">
				<ul>
					<li><a href="#" class="act">首页</a></li>
					<li><a href="#">科室简介</a></li>
					<li><a href="#">就医指南</a></li>
					<li><a href="#">门急诊安排</a></li>
					<li><a href="#">辅助检查</a></li>
					<li><a href="#">眼科常识</a></li>
					<li><a href="#">医患互动</a></li>
					<li><a href="#">联系我们</a></li>
					<li><a href="#">用户指南</a></li>
				</ul>
			</div>
		</div>
		<!-- /main menu -->

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<div class="loginwrap">
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
				</div>
				<div>
					<h1>眼科之家</h1>
					<ul>
						<li><a href="#">关于眼科</a>
						</li>
						<li><a href="#">预约挂号</a>
						</li>
						<li><a href="#">导医服务</a>
						</li>
						<li><a href="#">咨询专家</a>
						</li>
						<li><a href="#">升级考辅导站</a>
						</li>
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

			<!-- sideblock -->
			<div class="sideblock right">
				<ul class="adlink">
					<li><a href="#"> <img src="resources/images/ad1.png"
							alt=""> </a>
					</li>
					<li><a href="#"> <img src="resources/images/ad2.png"
							alt=""> </a>
					</li>
					<li><a href="#"> <img src="resources/images/ad3.png"
							alt=""> </a>
					</li>
				</ul>
			</div>
			<!-- /sideblock -->
		</div>
		<!-- /content -->

		<!-- footer -->
		<div class="footer clearfix">
			Copyright © 2008～2010 www.seeeye.org
			&nbsp;&nbsp;&nbsp;&nbsp;上海交通大学附属第一人民医院眼科<br>上海市海宁路100号临床医学视觉复明中心<a
				href="#">ICP备：0705052</a>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>