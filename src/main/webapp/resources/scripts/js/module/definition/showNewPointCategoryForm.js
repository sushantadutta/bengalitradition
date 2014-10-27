//Validations
$("#pointCategoryAddForm").validate({
	onfocusout : false
});

$(document).ready(function() {
	$("#pointCategoryAddForm").validate({
		rules : {
			pointCode : {
				required : true
			},
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
