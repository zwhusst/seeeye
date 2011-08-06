<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>

<html>
<head>
<title>上海第一人民医院眼科</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="resources/css/default-style.css" type="text/css"
	rel="stylesheet">
<link href="resources/css/extend-style.css" type="text/css"
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
					<img src="resources/images/news.jpg" alt="">
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