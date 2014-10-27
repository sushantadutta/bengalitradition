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

<title>CC Admin</title>

<!-- CC Loyal Style Sheets -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/sprites.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tab.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/form.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tree.css" />" />

<!-- Plugin Style Sheets -->
<!-- Tree View -->
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/js/plugin/jquery.treeview/jquery.treeview.css" />"
	type="text/css" media="screen" />


<!-- DataTables -->
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/js/plugin/DataTables-1.8.2/media/css/demo_page.css" />"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/js/plugin/DataTables-1.8.2/media/css/demo_table_jui.css" />"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/js/plugin/DataTables-1.8.2/examples/examples_support/themes/cc-loyalty-fresh/jquery-ui-1.8.4.custom.css" />"
	type="text/css" />

<!-- jQuery UI (Calender)-->
<link rel="stylesheet"
	href="<c:url value="/resources/scripts/js/plugin/jquery-ui-1.8.17.custom/css/smoothness/jquery-ui-1.8.17.custom.css" />"
	type="text/css" />


<!-- Scripts -->
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/scripts/js/plugin/jquery.js" />"></script>

<!-- Tree View -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/plugin/jquery.treeview/jquery.treeview.js" />"></script>

<!-- DataTable -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/plugin/DataTables-1.8.2/media/js/jquery.dataTables.js" />">
        </script>

<!-- Validation -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/plugin/jquery-validation-1.9.0/jquery.validate.js" />">
        </script>

<!-- jQuery UI -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/plugin/jquery-ui-1.8.17.custom/js/jquery-ui-1.8.17.custom.min.js" />"></script>
<script type="text/javascript" src="scripts/js/dateVal.js">
        </script>
<script type="text/javascript" src="<c:url value="/resources/scripts/js/theme.js" />"> </script>
<script type="text/javascript">
            $(document).ready(function() {
                var theme_name = "theme2";
                //theme.applyTheme(theme_name);
            })
        </script>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/override.css" />" />
</head>

<body>
<%-- 	<tiles:insertAttribute name="header" /> --%>
	<div id="container">
		<tiles:insertAttribute name="lmenu" />
		<tiles:insertAttribute name="rmenu" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
