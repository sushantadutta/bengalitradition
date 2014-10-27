<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CC Admin</title>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>

<script type="text/javascript">
	function show(str1, str2, sysFalg) //for showing inline editor
	{
		var id1 = document.getElementById(str1);
		var id2 = document.getElementById(str2);
		if (sysFalg == 'N') {
			id2.style.display = "block";
			id1.style.display = "none";
		}

	}

	function updateAppParamValues() {
		var mapJSONObject = {
			"updateAppParamVal" : []
		};
		var table = document.getElementById("data-table");
		var rowCount = table.rows.length;
		for ( var i = 0; i < rowCount - 1; i++) {
			mapJSONObject.updateAppParamVal.push({
				paramName : $('#row' + i + ' .param-name').val(),
				param_value : $('#row' + i + ' .select-box').val(),
				param_code : $('#row' + i + ' .caprAppCode').val()
			})
		}
		//alert(JSON.stringify(mapJSONObject));
		$.ajax(
						{
							url : "updateAppParamValues.htm",
							type : "POST",
							data : JSON.stringify(mapJSONObject),							
							success : function(result) {
								if (result == "true") {
									alert('Data Submitted Successfully');
									window.location
											.replace('<c:url value="/admin/application/app_param_list.htm"/>');
								} else {
									alert('Fails to Save the details');
								}

							},
							contentType : "application/json"
						}).fail(function() {
					alert("error");
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
		<form class="frame">

			<div class="content-title-toolbar">
				<label>Application Parameters</label>

				<div class="modify-icons">
					<input id="save" class="button" type="button" value="update"
						onclick="updateAppParamValues()">
				</div>
			</div>
			<table id="data-table" class="grid-table">
				<thead>
					<tr class="row-header">
						<td align="center">Parameter Name</td>
						<td align="center">Parameter Value</td>
						<td align="center">Description</td>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="appParam" items="${appParamList}"
						varStatus="counter">
						<tr class="odd" id="row${counter.index}">
							<input type="hidden" class="caprAppCode"
								value="${appParam.application_Parameter_PK.carp_app_code}" />
							<input type="hidden" class="param-name"
								value="${appParam.application_Parameter_PK.carp_param_name}" />
							<td class="" id="">${appParam.application_Parameter_PK.carp_param_name}</td>
							<c:choose>
								<c:when
									test="${(appParam.carp_param_type=='V') && (appParam.carp_possible_values !=null)}">
									<td>
										<div id="id1${counter.index}" style="display: block"
											align="left"
											onclick="show('id1${counter.index}','id2${counter.index}','${appParam.carp_sys_param_flag}')">
											&nbsp;${appParam.carp_param_values}&nbsp;</div>
										<div id="id2${counter.index}" style="display: none"
											align="center">
											<select name="aprVal${counter.index}"
												id="aprVal${counter.index}" class="select-box">
												<option value="${appParam.carp_param_values}" selected>${appParam.carp_param_values}</option>
												<c:forEach var="pvalue"
													items="${fn:split(appParam.carp_possible_values, ',')}">
													<c:forEach var="token" items="${fn:split(pvalue, ':')}"
														varStatus="counter">
														<c:choose>
															<c:when test="${counter.index==0}">
																<c:set var="code" value="${token}"></c:set>
															</c:when>
															<c:otherwise>
																<c:set var="meaning" value="${token}"></c:set>
															</c:otherwise>
														</c:choose>
													</c:forEach>
													<option value="${code}">${meaning}</option>
												</c:forEach>
											</select>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div id="id1${counter.index}" style="display: block"
											align="left"
											onclick="show('id1${counter.index}','id2${counter.index}','${appParam.carp_sys_param_flag}')">
											&nbsp;${appParam.carp_param_values}&nbsp;</div>
										<div id="id2${counter.index}" style="display: none"
											align="center">

											<input type="text" id="aprVal${counter.index}"
												name="aprVal${counter.index}"
												value="${appParam.carp_param_values}" class="select-box" />
										</div></td>
								</c:otherwise>
							</c:choose>
							<td>${appParam.carp_desc}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>