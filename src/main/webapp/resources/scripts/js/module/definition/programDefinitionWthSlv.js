//Redirection
function sendUrl(url) {
	//var url = 'getParticularProgramDefinition.htm?programId=1';
	window.location.replace(url);
}
		
//Script associated with Delete Button
$(document).ready(function() {
	$('#slvdelete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Service Level to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
		sendUrl('deleteServiceLevel.htm?slvCode=' + id+'&programId='+${programDefinition.programId});
		alert("The Service Level with ID:"+id+" has been successfully Deleted.");
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});
});
	
// Script associated with Edit Button	
$(document).ready(function() {
	$('#slvedit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Service Level to edit')
		} else {
			sendUrl('editServiceLevel.htm?slvCode=' + id+'&programId='+${programDefinition.programId})
		}
	});
});