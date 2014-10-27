//Redirections
function goBack(url) {
	window.location.href = url;
}

// Validations
$("#serviceLevelForm").validate({
	onfocusout : false
});

$(document).ready(function() {
	$("#serviceLevelForm").validate({
		rules : {
			slvCode : {
				required : true
			},
			slvShortName : {
				required : true
			},
			slvMinPoints : {
				digits : true,
				number : true,
				min : 0,
				maxlength : 10
			},
			slvMaxPoints : {
				digits : true,
				number : true,
				min : 1,
				maxlength : 10
			},
			slvPeriodLength : {
				required : true,
				number : true,
				digits : true,				
				min : 1,
				maxlength : 10
			},
			slvMinTransactions : {
				number : true,
				digits : true,
				min : 0,
				maxlength : 10
			},
			slvMaxTransaxtions : {
				number : true,
				digits : true,
				min : 1,
				maxlength : 10
			},
			slvBalanceCountFrequency : {
				number : true,
				digits : true,
				min : 1,
				maxlength : 10
			},
			slvStmtFrequency : {
				number : true,
				digits : true,
				min : 1,
				maxlength : 10
			}
		/*
		 * , slvNextHigherSlvLevel: { required: true }
		 */
		}
	});
});
