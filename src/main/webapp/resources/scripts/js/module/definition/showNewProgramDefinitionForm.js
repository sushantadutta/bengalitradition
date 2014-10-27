//Redirections
function resetProgramDefinitionForm() {
	document.getElementById("NewProgramDef").reset();
}
function goBack(url) {
	window.location.href = url;
}

/*var FormtdDate = "";
var MinimumDate = "";
     $("#programStartDateDtpicker1").change(function() {
   var currntDate = this.value;
   var characters = currntDate.split('/');
   var first = characters[0];
   var second = characters[1];
   var third = characters[2];
   FormtdDate = third+'/'+second+'/'+first;
   alert(FormtdDate);
   callEndDate(FormtdDate);
  
});
      function callEndDate(FormtdDate){
            
           MinimumDate = new Date(FormtdDate)
               $("#programEndDateDtPicker2").datepicker({
                   dateFormat: 'dd/mm/yy',
                   minDate:  MinimumDate
                   //maxDate: '+12m'
           });
                }
      $(function() {              
$("#programStartDateDtpicker1").datepicker({
   dateFormat: 'dd/mm/yy',
   minDate: new Date()
   //maxDate: '+12m'
});
      });*/

// Date Picker

/*  $(function() {  
	  $("#programStartDateDtpicker1").datepicker({ 
		  dateFormat :'dd-M-yy', 
		  minDate : 0, 
		  maxDate : '+12m' 
			  }); 
	  });
 
 $(function() { 
	 $("#programEndDateDtPicker2").datepicker({ 
		 dateFormat :'dd-M-yy', 
		 minDate : 0, 
		 maxDate : '+12m' 
			 }); 
	 });*/


// Validations
$("#NewProgramDef").validate({
	onfocusout : false
});

$(document).ready(function() {
	$("#NewProgramDef").validate({
		rules : {
			"programCode" : {
				required : true,
				maxlength : 20
			},
			"programDescription" : {
				required : true,
				maxlength : 200
			},
			"programStatus" : {
				required : true
			},
			"programShortName" : {
				required : true,
				maxlength : 60
			},			
			"duration" : {
				required : true
			}/*,
			"programPeriodLength" :{
				required : true,
				number : true
			},
			"programStartDate" :{
				required : true
			},
			"programEndDate" :{
				required :true
			}*/
		}
	});
});