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
				"ilt_table_name" : {
					required : true
				},
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
				}
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
		<div class="frame">
			<form:form method="post" commandName="loadTableRef" class="frame"
				id="addTableCatelog">

				<div class="content-title-toolbar">
					<label>Table Catalog</label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>Edit Table Catalog</legend>
						<div class="field">
							<div class="label-box">Table Name</div>
							<div class="input-box">
								<form:input path="ilt_table_name" readonly="true" />
								<form:errors path="ilt_table_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Description</div>
							<div class="input-box">
								<form:input path="ilt_table_desc" />
								<form:errors path="ilt_table_desc" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Sort Order</div>
							<div class="input-box">
								<form:input path="ilt_sort_order" />
								<form:errors path="ilt_sort_order" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Auto Generated Key</div>
							<c:choose>
								<c:when test="${loadTableRef.ilt_auto_gen_key=='Y'}">
									<c:set var="autoGenKey" value="checked" />
								</c:when>
								<c:otherwise>
									<c:set var="autoGenKey" value="" />
								</c:otherwise>
							</c:choose>
							<div class="input-box">
								<input type="checkbox" name="auto_generated_key" ${autoGenKey}>
							</div>
						</div>
						<div class="field">
							<div class="label-box">Batch Id Column</div>
							<div class="input-box">
								<form:select path="ilt_batch_id_column">
									<form:option value="">Select</form:option>
									<c:forEach var="batch_id_column" items="${batch_id_columns}">
										<form:option value="${batch_id_column.key}">${batch_id_column.value}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="ilt_batch_id_column" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Key Column</div>
							<div class="input-box">
								<form:select path="ilt_key_column">
									<form:option value="">Select</form:option>
									<c:forEach var="key_column" items="${key_columns}">
										<form:option value="${key_column.key}">${key_column.value}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="ilt_key_column" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Transaction Flag</div>
							<c:choose>
								<c:when test="${loadTableRef.ilt_loy_tranction_flag=='Y'}">
									<c:set var="transFlag" value="checked" />
								</c:when>
								<c:otherwise>
									<c:set var="transFlag" value="" />
								</c:otherwise>
							</c:choose>
							<div class="input-box">
								<input type="checkbox" name="transaction_flag" ${transFlag}>
							</div>
						</div>
						<div class="field">
							<div class="label-box">Data Source</div>
							<div class="input-box">
								<form:select path="ilt_data_source">
									<form:option value="">Select</form:option>
									<c:forEach var="data_source" items="${data_sources}">
										<form:option value="${data_source.key}">${data_source.value}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="ilt_data_source" cssClass="error" />
							</div>
						</div>

					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/> <%-- onclick="goBack('getParticularProgramDefinition.htm?programId='+${programDefinition.programId})" --%> />
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