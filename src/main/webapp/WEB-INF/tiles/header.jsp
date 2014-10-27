<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="java.util.Map"%>
<%
	String userName = SecurityContextHolder.getContext()
			.getAuthentication().getName();
%>
<%@include file="/WEB-INF/jsp/loytaglibs.jsp"%>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="description"
	content="Customer Loyalty Management Application!" />
<meta name="keywords" content="Customer Loyalty Management Application!" />

</head>
<body>
	<div id="header-v2">
		<div id="header-content">
			<div id="small-logo"></div>
			<div id="header-navigation">
				<div class="header-top-content">
					<a id="header-home" href="#">Home | </a> <a
						id="header-change-password" href="<c:url value="/changePassword.htm"/>">Change
						Password |</a> <a id="header-help" href="#">Help</a>
				</div>

				<div id="user-welcome">
					<div id="welcome-message">Welcome,</div>
					<div id="welcome-user-message-logout">
						<%= userName%>
					</div>
					<div id="header-separator">
						| <a id="header-logout"
							href="<c:url value="/j_spring_security_logout"/>">Logout</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


