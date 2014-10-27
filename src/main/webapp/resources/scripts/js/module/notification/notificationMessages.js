//Redirection
function sendUrl(url) {
	window.location.replace(url);
}

//Script for delete button and confirmation
$(document).ready(function() {
	$('#delete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Message to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
		sendUrl('deletePersonalizedMessage.htm?messageId='+id );
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});
});
	
//Scripts for view
$(document).ready(function() {
	$('#view').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Message to View');
		}else{
		sendUrl('viewPersonalizedMessage.htm?messageId='+id );
		}
	});
	
	$('#edit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Field to Edit');
		}else {
			sendUrl('showEditPersonalizedMessageForm.htm?messageId='+id);
		}			
	});
	
	$('#add').click(function() {	
			sendUrl('showPersonalizedMessageForm.htm');		
	});
});