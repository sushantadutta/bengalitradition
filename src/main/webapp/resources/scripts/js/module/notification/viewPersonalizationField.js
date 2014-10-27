/*//Redirection
function sendUrl(url) {
	window.location.replace(url);
}

function showAddForm(url) {
	window.location.replace(url);
}

//Tool bar buttons
$(document).ready(function() {
	$('#personalizationEdit').click(function() {
		var id = $("input[@name=grid-radio]:checked").attr('id');
		sendUrl('showModifyPersonalizationFieldForm.htm?fieldName=' + id)
	});
	$('#delete').click(function() {
		var fieldName = $("input[@name=grid-radio]:checked").attr('id');
		sendUrl('deletePersonalizationField.htm?fieldName='+fieldName)
	});
});*/