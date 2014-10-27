<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CC Admin</title>

<!-- Common Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>

<!-- Module Specific Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/tabHighlight.js" />"></script>

<!-- File Specific Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/home.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/programsHighlight.js" />"></script>

<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}
	$(document)
			.ready(
					function() {
						$('#user-edit')
								.click(
										function() {

											var userId = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (userId == null) {
												alert('Select a user to edit')
											} else {
												sendUrl('<c:url value="/admin/user/edit_user.htm?user_code="/>'
														+ userId);
											}
										});
					});
	$(document)
			.ready(
					function() {
						$('#user-delete')
								.click(
										function() {

											var userId = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (userId == null) {
												alert('Select a user to delete')
											} else {
												sendUrl('<c:url value="/admin/user/delete_user.htm?user_code="/>'
														+ userId);
											}
										});
					});
</script>

<c:if test="${fn:length(success) gt 0}">
	<script>
		alert('${success}');
		window.location.replace('${requestedUrl}');
	</script>
</c:if>
<c:if test="${fn:length(error) gt 0}">
	<script>
		alert('${error}');
		window.location.replace('${requestedUrl}');
	</script>
</c:if>

</head>

<body>
	<div id="center-content-no-right-side-bar">
		<form class="frame">
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<td align="center">User Name</td>
						<td align="center">Password</td>
					</tr>	
				</thead>
				<tbody>
					<c:forEach var="user" items="${userAndPassword}">
						<tr class="odd">
							<td>${user.key}</td>
							<td>${user.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>