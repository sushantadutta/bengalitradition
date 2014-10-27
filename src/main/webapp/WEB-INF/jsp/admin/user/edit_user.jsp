<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}

	$(document).ready(function() {
		$("#edit_user_bean").validate({
			rules : {
				"aus_user_name" : {
					required : true
				},
				"aus_first_name" : {
					required : true,
					lettersonly : true
				},
				"aus_last_name" : {
					required : true,
					lettersonly : true
				},
				"aus_password" : {
					required : true
				},
				confirm_password : {
					required : true,
					equalTo : "#maxtransactions"
				},
				"aus_mobile_number" : {
					required : true,
					number : true,
					digits : true
				},
				"aus_email" : {
					required : true,
					email : true
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
			<form:form method="post" commandName="user_bean" class="frame"
				id="edit_user_bean">

				<div class="content-title-toolbar">
					<label> <%-- <fmt:message
							key="servicelevel.showNewServiceLevelForm.newservicelevel" /> --%>Edit
						User </label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>
							<%-- <fmt:message key="servicelevel.showNewServiceLevelForm.legend" /> --%>
							User Information
						</legend>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvshortname" /> --%>
								User Name
							</div>
							<div class="input-box">
								<form:input path="aus_user_name" id="srvShort" maxlength="60"
									readonly="true" />
								<form:errors path="aus_user_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								First Name
							</div>
							<div class="input-box">
								<form:input path="aus_first_name" maxlength="200" />
								<form:errors path="aus_first_name" cssClass="error" />
							</div>
						</div>
						<hr>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvNextHigherSlvLevel" /> --%>
								Last Name
							</div>
							<div class="input-box">
								<form:input path="aus_last_name" maxlength="200" />
								<form:errors path="aus_last_name" cssClass="error" />
							</div>
						</div>

						<!-- <hr> -->
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvMaxPoints" /> --%>
								Family Name
							</div>
							<div class="input-box">
								<form:input path="aus_family_name" id="maxValue" />
								<form:errors path="aus_family_name" cssClass="error" />
							</div>
						</div>

						<%-- <div class="field">
							<div class="label-box">
								<fmt:message
									key="servicelevel.showNewServiceLevelForm.slvMaxTransaxtions" />
								Password
							</div>
							<div class="input-box">
								<form:password path="aus_password" 	maxlength="10" />
								<form:errors path="aus_password" cssClass="error" />
							</div>
						</div> --%>
						<hr>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvBalanceCountFrequency" /> --%>
								Notification
							</div>
							<div class="input-box">
								<form:select path="aus_notify_option">
									<c:forEach var="notification" items="${notification_flag}">
										<form:option value="${notification.key}">${notification.value}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="aus_notify_option" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvStmtFrequency" /> --%>
								Mobile Number
							</div>
							<div class="input-box">
								<form:input path="aus_mobile_number" maxlength="15" />
								<form:errors path="aus_mobile_number" cssClass="error" />
							</div>
						</div>
						<%-- <c:forEach var="mapflag" items="${mapFlag}">
							<c:set var="flag" value="${mapflag}"></c:set>
						</c:forEach>
						<hr> --%>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="accumulationprocess.showNewAccumulationProceesForm.notificationflag" /> --%>
								Email
							</div>
							<div class="input-box">
								<form:input path="aus_email" maxlength="100" />
								<form:errors path="aus_email" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="accumulationprocess.showNewAccumulationProceesForm.notificationtype" /> --%>
								Admin Flag
							</div>
							<c:choose>
								<c:when test="${user_bean.aus_admin_flag == 'Y'}">
									<c:set var="adminflag" value="checked" />
								</c:when>
								<c:otherwise>
									<c:set var="adminflag" value="" />
								</c:otherwise>
							</c:choose>
							<div class="input-box">
								<input type="checkbox" name="adminFlag"${adminflag}>
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="accumulationprocess.showNewAccumulationProceesForm.notificationtype" /> --%>
								Status
							</div>
							<div class="input-box">
								<form:select path="aus_status">
									<c:forEach var="status" items="${status}">
										<form:option value="${status.key}">${status.value}</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/>
					onclick="sendUrl('user_list.htm')" />
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