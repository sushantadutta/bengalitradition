
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@include file="/WEB-INF/taglibs.jsp"%>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="description"
	content="Customer Loyality Management Application!" />
<meta name="keywords"
	content="Customer Loyality Management Application!" />
<title>View Table Catalog</title>
<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}

	$(document).ready(function() {
		$('#colDelete').click(function() {
			 var id = $("input[@name=grid-radio]:checked").attr('id');			
			if (id == null) {
				alert('Select a Column Name to delete');
				return false;
			}
			var coltab = id.split("~");
			tableName = coltab[0];
			columnName = coltab[1];			
			 var del = confirm("Are you sure you want to delete this?")
			if (del == true) {
				sendUrl('deleteSysDictionaryCol.htm?table_name='+tableName+"&column_name="+columnName);				
			}
		});
	});
</script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>
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
	<div id="center-content">
		<div class="frame">
			<div class="content-title-toolbar">
				<label>Table Catalog</label>

				<div class="field-group">
					<fieldset>
						<legend>Table Catalog Details</legend>
						<div class="field">
							<div class="label-box">Table Name</div>
							<div class="value-box">${table_catalog_bean.tsd_table_name}</div>
						</div>
						<div class="field">
							<div class="label-box">Title</div>
							<div class="value-box">${table_catalog_bean.tsd_table_decription}</div>
						</div>
					</fieldset>

				</div>
			</div>

			<div class="modify-icons">
				<div id="colDelete" class="delete-icon button button-color"
					title="Delete System Column">
					<fmt:message key="global.buttonValue.buttonDelete" />
				</div>
				<div id="edit" class="edit-icon button button-color"
					title="Edit Column Details"
					onclick="sendUrl('<c:url value="/admin/table_catalog/edit_column_details.htm?table_name=${table_catalog_bean.tsd_table_name}"/>');">
					<fmt:message key="global.buttonValue.buttonEdit" />
				</div>
				<div id="add" class="add-icon button button-color"
					onClick="sendUrl('<c:url value="/admin/table_catalog/add_column_details.htm?table_name=${table_catalog_bean.tsd_table_name}"/>')"
					title="Add New Program Definition">
					<fmt:message key="global.buttonValue.buttonAdd" />
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<th>&nbsp;</th>
						<td>Name</td>
						<td>Title</td>
						<td>Data Type</td>
						<td>Data Length</td>
						<td>Sort Order</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tabColumRef"
						items="${table_catalog_bean.sys_DICTIONARY_COLSs}">
						<tr class="odd">
							<td><input
								id="${table_catalog_bean.tsd_table_name}~${tabColumRef.cols_PK.tdc_column_name}"
								name="grid-radio" type="radio" />
							</td>
							<td>${tabColumRef.cols_PK.tdc_column_name}</td>
							<td>${tabColumRef.tdc_column_title}</td>
							<td>${tabColumRef.tdc_data_type}</td>
							<td>${tabColumRef.tdc_data_length}</td>
							<td>${tabColumRef.tdc_sort_order}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>