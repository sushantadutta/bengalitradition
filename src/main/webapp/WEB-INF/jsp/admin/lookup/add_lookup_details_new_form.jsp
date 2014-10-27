<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#addLookupDetails").validate({
		rules : {
			"bas_Lookup_Details_PK.dld_lookup_code" : {
				required : true
			},
			"dld_lookup_meaning" : {
				required : true
			},
			"dld_sort_order" :  {
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
	<div id="center-content">
		<div class="content-form">
			<div class="frame">
				<div class="content-title-toolbar">
					<label>LookUp</label>
				</div>
				<div class="field-group">
					<fieldset>
						<legend>LookUp Info</legend>
						<div class="field">
							<div class="label-box">LookUp Name</div>
							<div class="value-box">${lookup.dlk_lookup_name}</div>
						</div>
						<div class="field">
							<div class="label-box">LookUp Type</div>
							<c:if test="${lookup.dlk_lookup_type == 'S'}">
								<div class="value-box">Static</div>
							</c:if>
						</div>
					</fieldset>
				</div>
			</div>
			<form:form method="post" commandName="lookup_detail_bean"
				class="frame" id="addLookupDetails">
				<div class="content-title-toolbar">
					<label>Lookup Detail</label>
				</div>
				<div class="field-group">
					<fieldset>
						<legend>Add Lookup Detail</legend>
						<div class="field">
							<div class="label-box">Lookup Code</div>
							<div class="input-box">
								<form:input path="bas_Lookup_Details_PK.dld_lookup_code" maxlength="100" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Lookup Meaning</div>
							<div class="input-box">
								<form:input path="dld_lookup_meaning" maxlength="200" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Sort Order</div>
							<div class="input-box">
								<form:input path="dld_sort_order" maxlength="1" />
							</div>
						</div>
					</fieldset>
				</div>
				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/> />
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