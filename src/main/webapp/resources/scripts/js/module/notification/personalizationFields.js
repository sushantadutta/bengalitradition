//Redirection
function sendUrl(url) {
	window.location.replace(url);
}

function showAddForm(url) {
	window.location.replace(url);
}

//Tool bar button and validations
$(document).ready(function() {
	$('#personalizationEdit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Field to Edit');
		}else {
			sendUrl('showModifyPersonalizationFieldForm.htm?fieldName=' + id);
		}			
	});
	
	/*$('#delete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Message to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
		sendUrl('deletePersonalizationField.htm?fieldName='+id );
		alert("The Personalization Field with ID:"+id+" has been successfully Deleted.");
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});*/
	
	$('#view').click(function() {
		var fieldName = $("input[@name=grid-radio]:checked").attr('id');
		if (fieldName == null) {
			alert('Select a Field to View');
		}else {
		sendUrl('viewPersonalizationField.htm?fieldName='+fieldName);
		}
	});
});
	