//Back Button
function goBack(url) {
	window.location.href = url;
}

//Dropdown select check
$(document).ready(function(){
	$('#persnlsnFieldForm').submit(function(e) {
		if ($('#dt-dropdown').val() == '') {
            e.preventDefault();
            alert("Please select Datatype from Dropdown List");
            return false;
        }
       });		
});
	
//Validations
$("#persnlsnFieldForm").validate({
    onfocusout: false
});
	
$(document).ready(function(){         
    $("#persnlsnFieldForm").validate({
    	rules: {
    		"personalizationField.personalizationField": {	
    			required: true
    		},
    		"personalizationField.personalizationDescription":{	
    			required: true
    		},
    		"personalizationField.personalizationDataType":{
    			required: true
    		}
    		},
	        messages:{
	        	"personalizationField.personalizationField": {
	         		required: "Required"
	         	},
	         	"personalizationField.personalizationDescription":{
	         		required: "Required"
	         	},
	         	"personalizationField.personalizationDataType":{
	    			required: "Select Datatype"
	    		}
	        }
    	})
});

