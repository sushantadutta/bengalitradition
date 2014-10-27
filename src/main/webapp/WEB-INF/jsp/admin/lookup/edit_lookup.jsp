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
</script>
</head>

<body>
	<div id="center-content">
		<%-- <c:set var="addNewServiceLevelUrl"	value="admin/add_user.htm" /> --%>
		<div class="content-form">
			<form:form method="post" commandName="lookup_bean" class="frame"
				id="add_lookup">

				<div class="content-title-toolbar">
					<label>Edit	Look Up</label>
				</div>

				<div class="field-group">
					<fieldset>
						<legend>Edit Look Up</legend>
						<div class="field">
							<div class="label-box">Lookup Code</div>
							<div class="input-box">
								<form:input path="dlk_lookup_name" readonly="true" />
								<form:errors path="dlk_lookup_name" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Description</div>
							<div class="input-box">
								<form:input path="dlk_description" />
								<form:errors path="dlk_description" cssClass="error" />
							</div>
						</div>
						<div class="field">
							<div class="label-box">Lookup Type</div>
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
						<c:choose>
							<c:when test="${lookup_bean.dlk_lookup_type == 'D'}">
								<div class="field" id="table-name">
									<div class="label-box">Table Name</div>
									<div class="input-box">
										<form:select path="dlk_lookup_table">
											<form:option value="">Select</form:option>
											<c:forEach var="lookup_type" items="${lookup_table}">
												<c:choose>
													<c:when
														test="${lookup_bean.dlk_lookup_table == lookup_type.key}">
														<form:option value="${lookup_type.key}"
															selected="selected">${lookup_type.value}</form:option>
													</c:when>
													<c:otherwise>
														<form:option value="${lookup_type.key}">${lookup_type.value}</form:option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</form:select>
										<form:errors path="dlk_lookup_table" cssClass="error" />
									</div>
								</div>								
								<div class="field" id="where-clause">
									<div class="label-box">										
										Where Clause
									</div>
									<div class="input-box">
										<form:input path="dlk_where_clause" />
										<form:errors path="dlk_where_clause" cssClass="error" />
									</div>
								</div>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
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