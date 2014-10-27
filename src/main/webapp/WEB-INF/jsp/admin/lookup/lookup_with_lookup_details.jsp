
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@include file="/WEB-INF/taglibs.jsp"%>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="description"
	content="Customer Loyality Management Application!" />
<meta name="keywords"
	content="Customer Loyality Management Application!" />
<title><fmt:message
		key="definition.programDefinitionWthSlv.title" />
</title>

<!-- Module Specific Scripts -->
<script type="text/javascript"
	src="scripts/js/module/definition/tabHighlight.js"></script>
<script type="text/javascript"
	src="scripts/js/module/definition/programsHighlight.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/js/module/common/includeDataTable.js" />"></script>
<script type="text/javascript">
	function sendUrl(url) {		
		window.location.replace(url);
	}
	$(document).ready(function() {
	     $('#lookup-det-delete').click(function() {
	         var id = $("input[@name=grid-radio]:checked").attr('id');
	         if (id == null) {
	             alert('Select a Lookup Code to Delete')
	         } else {
	        	    var arr = id.split('~');
					var lookupCode = arr[0];
					var lookupname = arr[1];
					var str = 'delete_lookupdetail.htm?lookup_code='+lookupCode+'&lookupname='+lookupname;
					sendUrl(str);	
	         }
	     });
	 });
	
	 
	 $(document).ready(function() {
	     $('#lookup-det-edit').click(function() {
	         var id = $("input[@name=grid-radio]:checked").attr('id');
	         if (id == null) {
	             alert('Select a Lookup Code to Edit')
	         } else {
	        	    var arr = id.split('~');
					var lookupCode = arr[0];
					var lookupname = arr[1];
					//alert("lookupcode--"+lookupCode+"....lookupname..."+lookupname);
					var str = 'get_edit_lookup_details.htm?lookup_code='+lookupCode+'&lookupname='+lookupname;
					//alert(str);
	             	sendUrl(str);	
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
		<div class="center-small-grid">
			<form class="frame">
				<label>LookUp Details</label>
				<div class="content-title-toolbar"></div>
				<c:choose>
					<c:when test="${lookup.bas_LOOKUP_DETAILSs=='[]'}">
						<div class="frame">
							<div class="field-group">
								<fieldset>
									<legend>
										<fmt:message key="dataInterface.import.information" />
									</legend>
									<div class="information-box">
										<div class="information-icon"></div>
										<div class="information-text">
											<label>No Lookup Details</label>
										</div>
										<div class="button">
											<a href="<c:url value="/admin/lookup/add_lookup_details.htm?lookup_name="/>${lookup.dlk_lookup_name}"> Add Lookup Detail</a>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="modify-icons">
							<div id="lookup-det-delete" class="delete-icon button button-color"
								title="Delete Lookup Detail">
								<fmt:message key="global.buttonValue.buttonDelete" />
							</div>							
							<div id="lookup-det-edit" class="edit-icon button button-color"
								title="Edit Lookup Detail">
								<fmt:message key="global.buttonValue.buttonEdit" />
							</div>
							<div id="look-det-add" class="add-icon button button-color"
								title="Add Lookup Detail" onclick="sendUrl('<c:url value="/admin/lookup/add_lookup_details.htm?lookup_name=${lookup.dlk_lookup_name}"/>');">
								<fmt:message key="global.buttonValue.buttonAdd" />
							</div>
						</div>
						<table id="data-table" class="grid-table">
							<thead>
								<tr class="row-header">
									<th>&nbsp;</th>
									<td>Lookup Code</td>
									<td>Lookup Meaning</td>
									<td>Sort Order</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="lookupDet" items="${lookup.bas_LOOKUP_DETAILSs}">
									<tr class="odd">
										<td><input id="${lookupDet.bas_Lookup_Details_PK.dld_lookup_code}~${lookup.dlk_lookup_name}"
											name="grid-radio" type="radio" /></td>
										<td>${lookupDet.bas_Lookup_Details_PK.dld_lookup_code}</td>
										<td>${lookupDet.dld_lookup_meaning}</td>
										<td>${lookupDet.dld_sort_order}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</div>
</body>
</html>
