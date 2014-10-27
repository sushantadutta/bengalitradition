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

			<div class="content-title-toolbar">
				<label>User List</label>

				<div class="modify-icons">
					<div id="user-delete" class="delete-icon button button-color"
						title="Delete User">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div>
					<%-- <div id="view" class="view-icon button button-color"
						title="View Program Definition">
						<fmt:message key="global.buttonValue.buttonView" />
					</div> --%>
					<div id="user-edit" class="edit-icon button button-color"
						title="Edit User">
						<fmt:message key="global.buttonValue.buttonEdit" />
					</div>
					<div id="add" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/user/add_user.htm"/>')"
						title="Add New User">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td align="center">User Id</td>
						<td align="center">First Name</td>
						<td align="center">Last Name</td>
						<td align="center">Work Area</td>
						<td align="center">Status</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="user" items="${user_list}">
						<tr class="odd">
							<th><input id="${user.aus_user_name}" name="grid-radio"
								type="radio" />
							</th>
							<td>${user.aus_user_name}</td>
							<td>${user.aus_first_name}</td>
							<td>${user.aus_last_name}</td>
							<td>${user.aus_work_area}</td>
							<td>${status[user.aus_status]}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>