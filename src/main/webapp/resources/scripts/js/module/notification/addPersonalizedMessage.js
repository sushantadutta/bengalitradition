//Browser Back Button
function goBack(url) {
	window.location.href = url;
}

//Populating message box with personalized fields  
$(document).ready(function(){
	$('#field-type').click(function(){
		$("#messageBox").val($('#messageBox').val() + "<" + this.value + ">");
	})
});
	
//Validation for Message Box
/*$(document).ready(function(){
	$("#submit").click(function(){
		var currentMessage = $('#messageBox').val();
		var validationMessage = "* Message Not Formatted Properly";
		var regex = /~/gi, result, indices = [];
		var trueCount = 0;
		while ( (result = regex.exec(currentMessage)) ) {
	    	indices.push(result.index);
		}
		if(indices.length%2 === 0 && indices.length !== 0){
			for(var i=0; i<indices.length;i++){
				$('#field-type  > option').each(function(){
					if(this.value === currentMessage.substring(indices[i]+1, indices[i+1])){
						trueCount++;
					}
				})
				i++;
			}
			if(trueCount === indices.length/2){
				$("#messageBox").remove('<br><label for="messageBox" generated="true">' + validationMessage + '</label>');
				//Validation Suceeds
				//Do Nothing
			}
			else{
				$("#messageBox").after('<br><label for="messageBox" generated="true">' + validationMessage + '</label>');
				event.preventDefault();
			}
		}
		else{
			$("#messageBox").after('<br><label for="messageBox" generated="true" >'  +validationMessage + '</label>');	
			event.preventDefault();
		}
	})
})*/
	
//Validations
$("#addPersnlzdFldForm").validate({
    onfocusout: false
});

$(document).ready(function(){         
    $("#addPersnlzdFldForm").validate({
    	rules: {
    		messageDescription: {
    			required: true
    		},
    		messageMessage:{	
    			required: true
    		},
    		messageNotificationType:{	
    			required: true
    		},
    		messageLongName: {
    			required:true
    		}
    		},
	        messages: {
	        	messageDescription: {
	         		required: "Required",
	                minlength: "Mandatory Field."
	         	},
	    		messageNotificationType:{	
	    			required: "Select a Notification Type"
	    		}
	        }
	    	})
});