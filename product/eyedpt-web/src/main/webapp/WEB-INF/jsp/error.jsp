<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; chareset=UTF-8"%>
<!-- imports -->
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
			<!-- container -->
			<div class="container left">
				<div class="error">
					<h2>页面出错</h2>
					<br>
					<br>
					<%
					    try
					    {
					        // The Servlet spec guarantees this attribute will be available
					        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");

					        if ( exception != null )
					        {
					            if ( exception instanceof ServletException )
					            {
					                // It's a ServletException: we should extract the root cause
					                ServletException sex = (ServletException) exception;
					                Throwable rootCause = sex.getRootCause();
					                if ( rootCause == null ) rootCause = sex;
					                out.println("** Root cause is: " + rootCause.getMessage());
					                rootCause.printStackTrace(new java.io.PrintWriter(out));
					            }
					            else
					            {
					                // It's not a ServletException, so we'll just show it
					                exception.printStackTrace(new java.io.PrintWriter(out));
					            }
					        }
					        else
					        {
					            out.println("No error information available");
					        }

					        // Display cookies
					        out.println("\nCookies:\n");
					        Cookie[] cookies = request.getCookies();
					        if ( cookies != null )
					        {
					            for (int i = 0; i < cookies.length; i++)
					            {
					                out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
					            }
					        }

					    }
					    catch (Exception ex)
					    {
					        ex.printStackTrace(new java.io.PrintWriter(out));
					    }
					%>
				</div>
			</div>
			<!-- /container -->
		</div>
		<!-- /content -->

		<%@ include file="fragments/footer.jspf"%>
	</div>
</body>
</html>