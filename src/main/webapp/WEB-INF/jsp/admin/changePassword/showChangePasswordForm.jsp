<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
	<form:form method="post" commandName="passwordBeanHolder" class="frame">
		<div id="center-content">
			<div class="content-form">
				<div class="frame">
					<div class="content-title-toolbar">
						<label>Change Password</label>
					</div>

					<div class="field-group">
						<fieldset>
							<legend>Enter Your Existing Password</legend>
							<div class="field">
								<div class="label-box">Password</div>
								<div class="value-box">
									<form:input path="existingPasswd" />
								</div>
							</div>
						</fieldset>
					</div>

					<div class="field-group">
						<fieldset>
							<legend>New Password</legend>
							<div class="field">
								<div class="label-box">Enter New Password</div>
								<div class="value-box">
									<input type="password" name="newPasswd" />
								</div>
							</div>
							<legend></legend>
							<div class="field">
								<div class="label-box">Confirm Password</div>
								<div class="value-box">
									<form:input path="newPassword" type="password" />
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<input class="button button-cancel button-color" type="button"
					value="Cancel" /> <input class="button button-reset button-color"
					type="reset" value="Reset" /> <input
					class="button button-submit button-color" type="submit"
					id="submitslv" value="Submit" />
			</div>
		</div>
	</form:form>
</body>
</html>