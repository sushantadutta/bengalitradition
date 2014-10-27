<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CC Admin</title>

<!-- Common Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>

<!-- Module Specific Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/tabHighlight.js" />"></script>

<!-- File Specific Scripts -->
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/home.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/definition/programsHighlight.js" />"></script>

<script type="text/javascript">
	function getSelectedCols() {

		return !$('#module0 option:selected').remove().appendTo('#module');
	}
	function removeSelectedCols() {
		return !$('#module option:selected').remove().appendTo('#module0');
	}

	function showGrpPermissionDiv() {
		document.getElementById("grpPermissionDiv").style.display = "block";
	}

	function submitGroupPermission(groupCode) {
	/* 	if("#module").selectedValues() == false){
			alert("nothing");
		}else{
			alert("BOOM");
		} */
		
		var rVal = $('#module').val();
		/* var lVal = $('#module0').selectedValues();
		alert(lVal); */
		if(rVal == null){
			alert("No Value Selected")
			return false;
		}
		var grpJSONObject = {
			"grpData" : []
		};
		$('#module').find('option:selected').each(function() {

			grpJSONObject.grpData.push({

				groupPermission : $(this).val()
			});

		});
		//alert(JSON.stringify(grpJSONObject)+":-"+groupCode);

		$
				.ajax(
						{
							url : "postGrpPermissionJson.htm?groupCode="
									+ groupCode + "",
							type : "POST",
							data : JSON.stringify(grpJSONObject),
							success : function(result) {
								// alert(result);
								if (result == "1") {
									alert('Error while validating the Qualification Criteria,Please check it and submit!');
								} else {
									// alert(JSON.stringify(criteriaJSONObject));
									alert('Data Submitted Successfully');
									window.location
											.replace('<c:url value="/admin/group/group_permission.htm?group_code=${param.group_code}"/>');
								}
							},
							//dataType : "json",
							contentType : "application/json"
						}).fail(function() {
					alert("error");
				});
	}
</script>

<script type="text/javascript">
	function sendUrl(url) {
		window.location.replace(url);
	}
	$(document)
			.ready(
					function() {
						$('#user-edit')
								.click(
										function() {

											var userId = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (userId == null) {
												alert('Select a user to edit')
											} else {
												sendUrl('<c:url value="/admin/user/edit_user.htm?user_code="/>'
														+ userId);
											}
										});
					});
	$(document)
			.ready(
					function() {
						$('#user-delete')
								.click(
										function() {

											var userId = $(
													"input[@name=grid-radio]:checked")
													.attr('id');
											if (userId == null) {
												alert('Select a user to delete')
											} else {
												var url = 'delete_group_permission.htm?group_code=${param.group_code}&&permission_code='
														+ userId;
												sendUrl(url);
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

			<div class="content-title-toolbar">
				<label>Group-Permission List</label>

				<div class="modify-icons">
					<div id="user-delete" class="delete-icon button button-color"
						title="Delete Program Definition">
						<fmt:message key="global.buttonValue.buttonDelete" />
					</div>
					<%-- <div id="view" class="view-icon button button-color"
						title="View Program Definition">
						<fmt:message key="global.buttonValue.buttonView" />
					</div> --%>
					<%-- <div id="user-edit" class="edit-icon button button-color"
						title="Edit Program Definition">
						<fmt:message key="global.buttonValue.buttonEdit" />
					</div> --%>
					<div id="add" class="add-icon button button-color"
						onClick="showGrpPermissionDiv();" title="Add Group Permissions">
						<fmt:message key="global.buttonValue.buttonAdd" />
					</div>
				</div>
			</div>
			<div>
				<table id="data-table" class="grid-table">
					<thead>
						<tr class="row-header">
							<th>&nbsp;</th>
							<td align="center">Permission</td>
							<td align="center">Description</td>
							<!-- <td align="center">Last Name</td>
						<td align="center">Work Area</td>
						<td align="center">Status</td> -->
						</tr>

					</thead>
					<tbody>
						<c:forEach var="permission"
							items="${group.adm_GROUP_PERMISSIONSs}">
							<tr class="odd">
								<th><input id="${permission.pk.permissions.apn_code}"
									name="grid-radio" type="radio" />
								</th>
								<td>${permission.pk.permissions.apn_code}</td>
								<td>${permission.pk.permissions.apn_description}</td>
								<%-- <td>${permission.aus_last_name}</td>
							<td>${user.aus_work_area}</td>
							<td>${status[user.aus_status]}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div id="grpPermissionDiv" class="field"
			style="width: 600px; display: none;">
			<!--                            <div class="label-box">Module Permission:</div>-->
			
			<table>
				<tr>
					<td style="width: 240px;">
						<div class="input-box">
							<select name="module0" id="module0" multiple
								style="width: 220px; height: 200px;">
								<!--                            <option value="">Select Permission</option>   -->
								<c:forEach var="grp_permission" items="${group_permission}"
									varStatus="counter">
									<option value="${grp_permission.key}">${grp_permission.value}</option>


								</c:forEach>
							</select>
						</div></td>
					<td style="width: 10px;">
						<div>
							<input id="" type="image"
								src="<c:url value="/resources/images/btn-rightArrowActive.gif" />"
								onclick="getSelectedCols();" /> <br /> <input id=""
								type="image"
								src="<c:url value="/resources/images/btn-leftArrowInactive.gif"/>"
								onclick="removeSelectedCols();" />
						</div></td>

					<td><select name="module" id="module" multiple
						style="width: 220px; height: 200px;"></select></td>
				</tr>
			</table>
			 
			<input id="submit" class="button button-submit button-color"
			value="Submit"
			type="submit" onclick="submitGroupPermission('${param.group_code}');">
		</div>

		
	</div>
</body>
</html>