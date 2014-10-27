<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {

		$("#lookup_type").blur(function(event) {
			var strVal = $('#lookup_type').val();
			strVal = strVal.replace(/[^A-Z]+/g, '');
			var capVal = strVal.toUpperCase();
			$('#lookup_type').val(capVal);
		});

		$("#add_lookup").validate({
			rules : {
				"dlk_lookup_name" : {
					required : true
				},
				"dlk_lookup_type" : {
					required : true
				},
				"dlk_lookup_table" : {
					required : true
				},
				"dlk_description" : {
					required : true
				}
			},
			messages : {
				"dlk_lookup_name" : {
					required : "Only Capital Alphabets Allowed."
				}
			}
		});
	});

	function getLookupType(lookupType) {
		if (lookupType == "S") {			
			$("#table-name").hide();
			$("#where-clause").hide();
		}
		if (lookupType == "D") {			
			$("#table-name").show();
			$("#where-clause").show();

		}
	}
	
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
			<form:form method="post" commandName="lookup_bean" class="frame"
				id="add_lookup">

				<div class="content-title-toolbar">
					<label> <%-- <fmt:message
							key="servicelevel.showNewServiceLevelForm.newservicelevel" /> --%>Add
						Look Up</label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>
							<%-- <fmt:message key="servicelevel.showNewServiceLevelForm.legend" /> --%>
							New Look Up
						</legend>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvshortname" /> --%>
								Lookup Code
							</div>
							<div class="input-box">
								<form:input path="dlk_lookup_name" />
								<form:errors path="dlk_lookup_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvshortname" /> --%>
								Description
							</div>
							<div class="input-box">
								<form:input path="dlk_description" />
								<form:errors path="dlk_description" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								Lookup Type
							</div>
							<div class="input-box">
								<form:select path="dlk_lookup_type"
									onchange="getLookupType(this.value);">
									<form:option value="">Select</form:option>
									<c:forEach var="lookup_type" items="${lookup_types}">
										<form:option value="${lookup_type.key}">${lookup_type.value}</form:option>
									</c:forEach>
									</form:select>
								<form:errors path="dlk_lookup_type" cssClass="error" />
							</div>
						</div>
						<!-- ---Sushanta -->
						<div class="field" id="table-name" style="display: none;">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								Table Name
							</div>
							<div class="input-box">
								<form:select path="dlk_lookup_table">
									<form:option value="">Select</form:option>
									<c:forEach var="lookup_type" items="${lookup_table}">
										<form:option value="${lookup_type.key}">${lookup_type.value}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="dlk_lookup_table" cssClass="error" />
							</div>
						</div>
						<!-- Sushanta -->
						<div class="field" id="where-clause" style="display: none;">
							<div class="label-box">
								<%-- <fmt:message
									key="servicelevel.showNewServiceLevelForm.slvlongname" /> --%>
								Where Clause
							</div>
							<div class="input-box">
								<form:input path="dlk_where_clause" />
								<form:errors path="dlk_where_clause" cssClass="error" />
							</div>
						</div>
					</fieldset>
				</div>

				<input class="button button-cancel button-color" type="button"
					value=<fmt:message key='global.buttonValue.button-cancel'/> onclick="sendUrl('lookup_list.htm')" />
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