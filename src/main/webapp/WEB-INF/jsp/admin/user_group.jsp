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
	
	
	$(document).ready(function() {
		$('#user-group-delete').click(function() {
			var userId = $("input[@name=grid-radio]:checked").attr('id');
				if(userId == null) {
					alert('Select a User Group to delete');
					 return false;
				}
				var arr = userId.split('~');
				var user_code = arr[0];
				var group_code = arr[1];							
					 sendUrl('<c:url value="/admin/user-group/delete_user_group.htm?user_code="/>'+user_code+'&group_code='+group_code);				
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
				<label>User Group List</label>

				<div class="modify-icons">
					<div id="user-group-delete" class="delete-icon button button-color"
						title="Delete User Group">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div>
					<div id="add" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/user-group/add_user_group.htm"/>')"
						title="Add New User Group">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td align="center">User Name</td>
						<td align="center">Group Name</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="user_group" items="${user_group_list}">
						<tr class="odd">
						<th><input id="${user_group.pk.user.aus_user_name}~${user_group.pk.group.agr_code}" name="grid-radio"
								type="radio" /></th>
							<td>${user_group.pk.user.aus_user_name}</td>
							<td>${user_group.pk.group.agr_code}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>