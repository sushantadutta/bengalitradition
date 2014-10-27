<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<script type="text/javascript">
	function getTabColumns(tablename) {
		//alert(tablename);
		window.location
				.replace('add_table_catalog_by_source_tab.htm?source_table='
						+ tablename);

	}
	function sendUrl(url) {
		window.location.replace(url);
	}

	$(document).ready(function() {
		$("#addTableCatelog").validate({
			rules : {
				"tsd_data_source_name" : {
					required : true
				},
				"tsd_table_name" : {
					required : true
				},
				"tsd_table_decription" : {
					required : true
				},
				"tsd_sort_order" : {
					required : true,
					number : true,
					digits :  true
				}
			/* ,
							"ilt_table_desc" : {
								required : true
							},
							"ilt_sort_order" : {
								required : true
							},
							"ilt_batch_id_column" : {
								required : true
							},
							"ilt_key_column" : {
								required : true
							},
							"ilt_data_source" : {
								required : true
							} */
			}
		});
	});
	
	

	function getTableName(dataSourceName) {		
		$('#tableNameId').empty().append(
				'<option selected="selected" value="">Select</option>');
		$.getJSON("get_tables_based_on_datasource.htm?datasource=" + dataSourceName, function(data) {
			//alert(data);
			$.each(data, function(key, value) {					
			 $('#tableNameId').append(
						'<option value="' + value + '">' + value + '</option>');
			});
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
	<div id="center-content-no-right-side-bar">
		<div class="frame">
			<form:form method="post" commandName="table_bean" class="frame"
				id="addTableCatelog">

				<div class="content-title-toolbar">
					<label>Table Catalog</label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>Add Table Catalog</legend>
						<div class="field">
							<div class="label-box">Data Source Name</div>
							<div class="input-box">
								<form:select path="tsd_data_source_name"
									onchange="getTableName(this.value);">
									<form:option value="">Select</form:option>
									<c:forEach items="${datasource_list}" var="map">
										<form:option value="${map.key}">${map.key}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="tsd_data_source_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Table Name</div>
							<div class="input-box">
								<form:select path="tsd_table_name" id="tableNameId">
									<form:option value="">
										<fmt:message key="global.dropdown.defaultVal" />
									</form:option>
								</form:select>
								<form:errors path="tsd_table_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Title</div>
							<div class="input-box">
								<form:input path="tsd_table_decription" />
								<form:errors path="tsd_table_decription" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Sort Order</div>
							<div class="input-box">
								<form:input path="tsd_sort_order" />
								<form:errors path="tsd_sort_order" cssClass="error" />
							</div>
						</div>
						<%-- <div class="field">
							<div class="label-box">Table Type</div>
							<div class="input-box">
								<form:select path="tsd_table_type">
									<form:option value="">Select</form:option>
									<c:forEach items="${datasource_list}" var="map">
										<form:option value="${map.key}">${map.key}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="tsd_table_type" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">TTL ID</div>
							<div class="input-box">
								<form:input path="tsd_ttl_id" />
								<form:errors path="tsd_ttl_id" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Key Column</div>
							<div class="input-box">
								<form:input path="tsd_key_column" />
								<form:errors path="tsd_key_column" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Key Unique</div>
							<div class="input-box">
								<form:input path="tsd_key_unique" />
								<form:errors path="tsd_key_unique" cssClass="error" />
							</div>
						</div> --%>
					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/> onclick="sendUrl('table_catalog_list.htm')" />
				<input class="button button-reset button-color" type="reset"
					value=<fmt:message key='global.buttonValue.button-reset'/> />
				<input class="button button-submit button-color" type="submit"
					id="submitslv"
					value=<fmt:message key='global.buttonValue.button-submit'/> />
			</form:form>
		</div>
	</div>
</body>
</html>