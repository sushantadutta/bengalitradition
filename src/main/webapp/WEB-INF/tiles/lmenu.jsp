<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="description"
	content="Customer Loyalty Management Application!" />
<meta name="keywords" content="Customer Loyalty Management Application!" />
</head>
<body>
	<div id="left-side-bar-navigation">
		<ul>
			<li class="sub-tab"><a href="<c:url value="/admin/user/user_list.htm" />">&nbsp;
					Users </a></li>
			<li class="sub-tab"><a href="<c:url value="/admin/group/group_list.htm" />">&nbsp;
					Groups </a></li>
			<li class="sub-tab"><a href="<c:url value="/admin/user-group/user_group_list.htm" />">&nbsp;
					User-Group </a></li>
			<li class="sub-tab"><a href="<c:url value="/admin/application/app_param_list.htm" />">&nbsp;
					Application Parameters</a></li>
			<li class="sub-tab"><a href="<c:url value="/admin/table_catalog/table_catalog_list.htm" />">&nbsp;
					Table Catalog</a></li>	
			<li class="sub-tab"><a href="<c:url value="/admin/lookup/lookup_list.htm" />">&nbsp;
					Reference-Data </a></li>
			<%-- <li class="sub-tab"><a href="<c:url value="/admin/permission/permission.htm" />">&nbsp;
					Group Permission </a></li> --%>
			<li class="sub-tab"><a href="<c:url value="/listOfPassword.htm" />">&nbsp;
					Password Management </a></li>
		</ul>
	</div>
</body>
</html>
