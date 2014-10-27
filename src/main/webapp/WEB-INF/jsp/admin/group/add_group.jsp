<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
	$("#add_group").validate({
		rules : {
			"agr_code" : {
				required : true
			},
			"agr_short_name" : {
				required : true
			},
			"agr_long_name" : {
				required : true
			}
	}
});
});

function sendUrl(url) {
	window.location.replace(url);
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
		<%-- <c:set var="addNewServiceLevelUrl"	value="admin/add_user.htm" /> --%>
		<div class="content-form">
			<form:form method="post" commandName="group_bean" class="frame" id="add_group">

				<div class="content-title-toolbar">
					<label> <%-- <fmt:message
							key="servicelevel.showNewServiceLevelForm.newservicelevel" /> --%>Add
						Group Details </label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>
							<%-- <fmt:message key="servicelevel.showNewServiceLevelForm.legend" /> --%>New Group Information
						</legend>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvshortname" /> --%>
								Group Code
							</div>
							<div class="input-box">
								<form:input path="agr_code" id="srvShort" maxlength="60" />
								<form:errors path="agr_code" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								Short Name
							</div>
							<div class="input-box">
								<form:input path="agr_short_name" maxlength="200" />
								<form:errors path="agr_short_name" cssClass="error" />
							</div>
						</div>
						<hr>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvNextHigherSlvLevel" /> --%>
								Long Name
							</div>
							<div class="input-box">
								<form:input path="agr_long_name" maxlength="200" />
								<form:errors path="agr_long_name" cssClass="error" />
							</div>
						</div>
					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/>
					onclick="sendUrl('group_list.htm')"  />
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