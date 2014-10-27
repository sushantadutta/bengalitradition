
//To make the Back Button in browser
//Need to look at this
function sendUrl(url) {
	window.location.href = url;
}

//Tool bar button
$(document).ready(function() {
	$('#view').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Program to view')
		} else {
			sendUrl('getParticularProgramDefinition.htm?programId=' + id)
		}
	});
});

$(document).ready(function() {
	$('#delete').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Program to delete');
		}
		else {
		var del = confirm("Are you sure you want to delete this?")
		 if (del == true){
		sendUrl('deleteProgramDefinition.htm?programId=' + id);		
		 }
		 else{
			 alert("Current Operation Cancelled.");
		 }
		}
	});
});
	


$(document).ready(function() {
	$('#edit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		if (id == null) {
			alert('Select a Program to edit')
		} else {
			sendUrl('editProgramDefinition.htm?programId=' + id)
		}
	});
});