 $(document).ready(function(){
	var FormtdDate = '';
	var MinimumDate = '';
	     $('.startDate').change(function() {
	   var currntDate = this.value;
	   var characters = currntDate.split('-');
	   var first = characters[0];
	   var second = characters[1];
	   var third = characters[2];
	   FormtdDate = third+'-'+second+'-'+first;
	   callEndDate(FormtdDate);
	  
	});
	     function callEndDate(FormtdDate){
	    	 $(".endDate").datepicker("destroy");
	         MinimumDate = new Date(FormtdDate)
	         $(function() { 
	             $(".endDate").datepicker({
	                 dateFormat: 'dd-M-yy',
	                 minDate:  MinimumDate,
	                 maxDate: '+12m'
	         });
	         });
	              }
	     $(function() {              
	    	 $(".startDate").datepicker({
	    	    dateFormat: 'dd-M-yy',
	    	    minDate: '-12m',
	    	    maxDate: '+12m'
	    	 });
	    	       });
	     
	     //Editing script for date validation Starts
	     
	     
	     $('.startDateEdit').change(function() {
	  	   var currntDate = this.value;
	  	   var characters = currntDate.split('-');
	  	   var first = characters[0];
	  	   var second = characters[1];
	  	   var third = characters[2];
	  	   FormtdDate = third+'-'+second+'-'+first;
	  	   callEndDateEdit(FormtdDate);
	  	  
	  	});
	     	$(function() { 
	             $(".endDateEdit").datepicker({
	                 dateFormat: 'dd-M-yy',
	                 minDate:  '-12m',
	                 maxDate: '+12m'
	         });
	         });
	  	     function callEndDateEdit(FormtdDate){
	  	    	 $(".endDateEdit").datepicker("destroy");
	  	         MinimumDate = new Date(FormtdDate)
	  	         $(function() { 
	  	             $(".endDateEdit").datepicker({
	  	                 dateFormat: 'dd-M-yy',
	  	                 minDate:  MinimumDate,
	  	                 maxDate: '+12m'
	  	         });
	  	         });
	  	              }
	  	     $(function() {              
	  	    	 $(".startDateEdit").datepicker({
	  	    	    dateFormat: 'dd-M-yy',
	  	    	    minDate: '-12m',
	  	    	    maxDate: '+12m'
	  	    	 });
	  	    	       });
	     
	 });
