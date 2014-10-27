
//Validations
$("#pointCategoryEditForm").validate({
	onfocusout : false
});

$(document).ready(function() {
	$("#pointCategoryEditForm").validate({
		rules : {
			pointShortName : {
				required : true
			},
			/*pointLongName : {
				required : true
			},*/
			pointCategory : {
				required : true
			}
		}
	});
});
