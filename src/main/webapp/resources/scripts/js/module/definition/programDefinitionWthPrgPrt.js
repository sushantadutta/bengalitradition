//Redirection
function sendUrl(url) {
	window.location.replace(url);
}

//Script associated with Delete Button
$(document).ready(function() {
	$('#prgprtdelete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Program Partner association to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
		sendUrl('deleteProgramPartner.htm?prgPrtOrgId=' + id+'&programId='+${programDefinition.programId});
		alert("The Program Partner association with ID:"+id+" has been successfully Deleted.");
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});
});
	
//Script associated with Edit Button
$(document).ready(function() {
	$('#prgprtedit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Program Partner association to edit')
		} else {
			sendUrl('editProgramPartner.htm?prgPrtOrgId=' + id+'&programId='+${programDefinition.programId})
		}
	});
});