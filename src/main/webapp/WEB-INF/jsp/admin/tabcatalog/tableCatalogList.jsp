<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>
<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}

	$(document)
			.ready(
					function() {
						$('#tab-cat-view')
								.click(
										function() {

											var table_name = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (table_name == null) {
												alert('Select a Table Name to View');
											} else {
												sendUrl('<c:url value="/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name="/>'
														+ table_name);
											}
										});
					});
	$(document)
			.ready(
					function() {
						$('#tab-cat-delete')
								.click(
										function() {

											var table_name = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (table_name == null) {
												alert('Select a Table Name to Delete');
											} else {
												sendUrl('<c:url value="/admin/table_catalog/delete_table_catalog_by_name.htm?table_name="/>'
														+ table_name);
											}
										});
					});

	$(document)
			.ready(
					function() {
						$('#tab-cat-edit')
								.click(
										function() {

											var table_name = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (table_name == null) {
												alert('Select a Table Name to Edit');
											} else {
												sendUrl('<c:url value="/admin/table_catalog/edit_table_catalog.htm?table_name="/>'
														+ table_name);
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
				<label>Table Catalog</label>
				<div class="modify-icons">
					<div id="tab-cat-delete" class="delete-icon button button-color"
						title="Delete Table Catalog">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div>
					<div id="tab-cat-view" class="view-icon button button-color"
						title="View Table Catalog">
						<fmt:message key="global.buttonValue.buttonView" />
					</div>
					<%-- <div id="tab-cat-edit" class="edit-icon button button-color"
						title="Edit Table Catalog">
						<fmt:message key="global.buttonValue.buttonEdit" />
					</div> --%>
					<div id="tab-cat-add" class="add-icon button button-color"
						onClick="sendUrl('<c:url value="/admin/table_catalog/add_table_catalog.htm"/>')"
						title="Add Table Catalog">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td align="center">Table</td>
						<td align="center">Title</td>
						<td align="center">Sort Order</td>
						<!-- <td align="center">Generate Key</td>
						<td align="center">Load Flag</td>
						<td align="center">Batch Id</td>
						<td align="center">Key Column</td> -->
					</tr>

				</thead>
				<tbody>
					<c:forEach var="tabCat" items="${tableCatalogList}">
						<tr class="odd">
							<th><input id="${tabCat.tsd_table_name}" name="grid-radio"
								type="radio" />
							</th>
							<td>${tabCat.tsd_table_name}</td>
							<td>${tabCat.tsd_table_decription}</td>
							<td>${tabCat.tsd_sort_order}</td>
							<%-- <td>${tabCat.ilt_load_flag}</td>
							<td>${tabCat.ilt_batch_id_column}</td>
							<td>${tabCat.ilt_key_column}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>