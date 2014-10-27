// Redirection
function sendUrl(url) {
	window.location.replace(url);
}
	
// Script associated with Delete Button
/*
$(document).ready(function() {
	$('#pntctgrydelete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a PointCategory association to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
			 sendUrl('deletePointCategory.htm?pointCode=' + id+'&programId='+${programDefinition.programId});
		alert("The PointCategory association with ID:"+id+" has been successfully Deleted.");
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});
});
	
// Script associated with Edit Button
$(document).ready(function() {
	$('#pntctgryedit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a PointCategory association to edit')
		} else {
			sendUrl('editPointCategory.htm?pointCode=' + id+'&programId='+${programDefinition.programId})
		}
	});
});*/