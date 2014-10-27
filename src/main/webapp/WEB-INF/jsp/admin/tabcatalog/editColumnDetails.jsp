
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
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>
<style type="text/css">
.fg-toolbar {
	width: 683;
}
</style>
<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}

	/* 	function validateTable(data){
	 for(i=0; i<data ;i++){
	 var colTitle = "coltitle"+i;
	 var colOrder = "colorder"+i;
	 var dataTitleValue = document.getElementById(colTitle).value;
	 var dataOrderValue = document.getElementById(colOrder).value;
	 if(dataTitleValue != '' && dataOrderValue != ''){
	 updateColmnValues('${table_catalog_bean.tsd_table_name}');
	 return true;
	 }else{
	 alert("No empty columns allowed");
	 return false;
	 }
	
	
	 }
	
	 } */

	/*  $(document).ready(function() {
		$('#coltitle').blur(function(event) {
			var strVal = $('#coltitle').val();			
			strVal = strVal.replace(/[^a-zA-Z 0-9 _]+/g, '');
			var capVal = strVal.toUpperCase();
			$('#coltitle').val(capVal);
		});
		$('#coltitle').keydown(function(event) {
			if (event.keyCode == 32) {
				event.preventDefault();
			}
		});
	}); */	
	
	function updateColmnValues(data) {
		var mapJSONObject = {
			"updateColVal" : []
		};
		var table = document.getElementById("data-table");
		var rowCount = table.rows.length;
		for ( var i = 0; i < rowCount - 1; i++) {			
			if ($('#row' + i + ' .coltitle').val() === '') {
				alert("Please enter column title");
				return false;				
			} else if ($('#row' + i + ' .colorder').val() === '') {
				alert("Please enter column order");
				return false;
			} else if ($('#row' + i + ' .colorder').val() != '') {
				var key = $('#row' + i + ' .colorder').val();
				var regex = /[0-9]|\./;
				if (!regex.test(key)) {
					alert("Please enter number only");
				}
			}

			mapJSONObject.updateColVal.push({
				columnName : $('#row' + i + ' .columnname').val(),
				columnTitle : $('#row' + i + ' .coltitle').val(),
				colmnDataType : $('#row' + i + ' .coldatatype').val(),
				colmnDataLength : $('#row' + i + ' .collength').val(),
				colmnOrder : $('#row' + i + ' .colorder').val(),
				tablename : data
			})
		}

		$
				.ajax(
						{
							url : "edit_column_details.htm",
							type : "POST",
							data : JSON.stringify(mapJSONObject),
							success : function(result) {
								if (result == "true") {
									alert('Data Submitted Successfully');
									window.location
											.replace('<c:url value="/admin/table_catalog/view_table_catalog_by_table_name.htm?table_name=${table_catalog_bean.tsd_table_name}"/>');
								} else {
									alert('Fails to Save the details');
								}

							},
							contentType : "application/json"
						}).fail(function() {
					//alert("error");
				});

	}
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
			<c:set var="length1"
				value="${fn:length(table_catalog_bean.sys_DICTIONARY_COLSs)}"></c:set>
			<div class="modify-icons">
				<input id="cancel" class="button" type="button" value="Cancel"
					onclick="sendUrl('view_table_catalog_by_table_name.htm?table_name=${table_catalog_bean.tsd_table_name}');"
					style="margin-right: -60px;">
				<input id="save" class="button" type="button" value="Update"
					onclick="updateColmnValues('${table_catalog_bean.tsd_table_name}');"
					style="margin-right: -147px;">
			</div>
			<table id="data-table" class="grid-table" style="width: 696px;">
				<thead>
					<tr class="row-header">
						<td>Name</td>
						<td>Title</td>
						<td>Data Type</td>
						<td>Data Length</td>
						<td>Sort Order</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tabColumRef"
						items="${table_catalog_bean.sys_DICTIONARY_COLSs}"
						varStatus="counter">
						<tr class="odd" id="row${counter.index}">
							<td><input type="text" class="columnname"
								value="${tabColumRef.cols_PK.tdc_column_name }" readonly="true">
							</td>
							<td><input type="text" class="coltitle"
								value="${tabColumRef.tdc_column_title }"
								id="coltitle${counter.index}">
							</td>
							<td><input type="text" class="coldatatype"
								value="${tabColumRef.tdc_data_type }" readonly="true">
							</td>
							<td><input type="text" class="collength"
								value="${tabColumRef.tdc_data_length }" readonly="true">
							</td>
							<td><input type="text" class="colorder"
								value="${tabColumRef.tdc_sort_order }"
								id="colorder${counter.index}">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>