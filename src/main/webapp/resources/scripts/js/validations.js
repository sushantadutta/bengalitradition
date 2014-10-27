$("#Validate").validate({
    onfocusout: false
});

$(document).ready(function(){         
    $("#Validate").validate({
    	rules: {
            minLength2: {
                minlength: 2
            },
            programCode: {
                number: true
            },
            emailId: {
                email: true
            },
            digitsOnly: {
                digits: true
            },
            url: {
                url: true
            },
            capsOnly: {
                Caps_TextOnly: true
            }
        },
        messages: {
            minLength2: {
                //required: "* Required",
                //minlength: "* 2 Characters Required."
            },
            numberOnly: {
                //required: "* Required",
                //number: "* Enter Number."
            }
        }
    });
});