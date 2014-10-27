<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function() {
	$("#add_user_group").validate({
		rules : {
			user_name : {
				required : true
			},
			group_name : {
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
			<form:form method="post" commandName="user_group_bean" class="frame" id="add_user_group">

				<div class="content-title-toolbar">
					<label> <%-- <fmt:message
							key="servicelevel.showNewServiceLevelForm.newservicelevel" /> --%>Add
						User-Group Details </label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>
							<%-- <fmt:message key="servicelevel.showNewServiceLevelForm.legend" /> --%>
							New User-Group
						</legend>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvshortname" /> --%>
								User Name
							</div>
							<div class="input-box">
								<select	 name="user_name">
								<option value="">
									<fmt:message key="global.dropdown.defaultVal" />
								</option>
									<c:forEach var="user" items="${user_list}">
										<option value="${user.aus_user_name }">${user.aus_user_name }</option>
									</c:forEach>
								</select>
								<%-- <form:errors
									path="pk.user.aus_user_name" cssClass="error" /> --%>
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								Group Name
							</div>
							<div class="input-box">
								<select name="group_name">
								<option value="">
									<fmt:message key="global.dropdown.defaultVal" />
								</option>
									<c:forEach var="group" items="${group_list}">
										<option value="${group.agr_code }">${group.agr_code }</option>
									</c:forEach>
								</select>
								<%-- <form:errors path="pk.group.agr_code"	cssClass="error" /> --%>
							</div>
						</div>
					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/> onclick="sendUrl('user_group_list.htm')" />
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