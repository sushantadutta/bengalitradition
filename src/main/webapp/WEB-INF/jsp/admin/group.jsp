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
				$('#group-edit')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a group to edit')
									}  else {																					
										sendUrl('<c:url value="/admin/group/edit_group.htm?group_code="/>'+userId);
									} 
								});
			});
	$(document)
	.ready(
			function() {
				$('#group-delete')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a group to delete')
									}  else {	
										var del = confirm("Are you sure you want to delete this?")
										 if (del == true){
											 sendUrl('<c:url value="/admin/group/delete_group.htm?group_code="/>'+userId);
										 }										
									} 
								});
			});
	$(document)
	.ready(
			function() {
				$('#group-view')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a group to view')
									}  else {																					
										sendUrl('<c:url value="/admin/group/group_permission.htm?group_code="/>'+userId);
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
				<label>Group List</label>

				<div class="modify-icons">
					<div id="group-delete" class="delete-icon button button-color"
						title="Delete Group">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div>
					<div id="group-view" class="view-icon button button-color"
						title="View Group">
						<fmt:message key="global.buttonValue.buttonView" />
					</div>
					<div id="group-edit" class="edit-icon button button-color"
						title="Edit Group">
						<fmt:message key="global.buttonValue.buttonEdit" />
					</div>
					<div id="add" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/group/add_group.htm"/>')"
						title="Add New Group">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td align="center">Group Code</td>
						<td align="center">Group Name</td>
						<td align="center">Description</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="group" items="${group_list}">
						<tr class="odd">
							<th><input id="${group.agr_code}" name="grid-radio"
								type="radio" /></th>
							<td>${group.agr_code}</td>
							<td>${group.agr_short_name}</td>
							<td>${group.agr_long_name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>