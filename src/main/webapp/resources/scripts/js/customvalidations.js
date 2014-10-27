$(document).ready(function(){
    $.validator.addMethod("Caps_TextOnly", 
        function(value, element) {
            return /[A-Z ]/.test(value);
        }, 
        "Caps Required"
        );
});

$(document).ready(function(){
    $.validator.addMethod("Tilda_Present", 
        function(value, element) {
            return this.optional(element) || /^[+a-zA-Z0-9._-~]+~[a-zA-Z0-9.-~]*$/i.test(value); 
        }, 
        "~ not present"
        );
});