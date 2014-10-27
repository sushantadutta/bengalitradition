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
				$('#lookup-delete')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a Lookup to delete')
									}  else {																					
										sendUrl('<c:url value="/admin/lookup/delete_lookup.htm?lookup_name="/>'+userId);
									} 
								});
			});
	$(document)
	.ready(
			function() {
				$('#lookup-view')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a Lookup to view.')
									}  else {																					
										sendUrl('<c:url value="/admin/lookup/view_lookup_by_name.htm?look_up_name="/>'+userId);
									} 
								});
			});
	$(document)
	.ready(
			function() {
				$('#lookup-edit')
						.click(
								function() {

									var userId = $("input[@name=grid-radio]:checked").attr('id');									
									if (userId == null) {
										alert('Select a Lookup to delete')
									}  else {																					
										sendUrl('<c:url value="/admin/lookup/edit_look_up.htm?lookup_name="/>'+userId);
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
				<label>Lookup List</label>

				<div class="modify-icons">
					<%-- <div id="lookup-delete" class="delete-icon button button-color"
						title="Delete Program Definition">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div> --%>
					<div id="lookup-view" class="view-icon button button-color"
						title="View Lookup Detail">
						<fmt:message key="global.buttonValue.buttonView" />
					</div>
					<div id="lookup-edit" class="edit-icon button button-color"
						title="Edit Lookup Detail">
						<fmt:message key="global.buttonValue.buttonEdit" />
					</div>
					<div id="add" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/lookup/add_lookup.htm"/>')"
						title="Add Lookup Detail">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
					<%-- <div id="insert" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/lookup/bulk_insert.htm"/>')"
						title="Add New Program Definition">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div> --%>
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td align="center">LookUp Code</td>
						<td align="center">Description</td>
						<td align="center">LookUp Type</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="lookup" items="${lookup_list}">
						<tr class="odd">
							<th><input id="${lookup.dlk_lookup_name}" name="grid-radio" 
								type="radio" /></th>
							<td>${lookup.dlk_lookup_name}</td>
							<td>${lookup.dlk_description}</td>
							
							<td>${lookup_types[lookup.dlk_lookup_type]}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>