<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- tag libs -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="<c:url value="/resources/css/default-style.css"/>"
	type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/extend-style.css"/>"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/cufon-yui.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/lib/cufon-replace.js"/>"></script>

<!--[if IE 6]>
    <script type="text/javascript" src="<c:url value="/resources/scripts/lib/ie_png.js"/>"></script>
     <script type="text/javascript">
       ie_png.fix('.png');
     </script>
<![endif]-->
</head>

<body>
	<div class="main">
		<%@ include file="fragments/header.jspf"%>

		<!-- content -->
		<div class="content clearfix">
			<div class="contentleft">
				<%@ include file="fragments/userpanel.jspf"%>
				<%@ include file="fragments/navigator.jspf"%>
			</div>

			<!-- container -->
			<div class="container left">
				<div class="newswrap">
					<img src="<c:url value="/resources/images/news.jpg"/>" alt="">
					<div>
						<a href="#" class="newsleftlink">眼科相关新闻</a> <a href="#"
							class="newsrightlink">眼科专家风采</a>
					</div>
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