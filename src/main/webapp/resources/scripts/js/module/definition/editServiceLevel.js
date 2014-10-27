//Back button in browser, need to look into this
function goBack(url) {
	window.location.href = url;
}

// Validations
$("#serviceLevelEditForm").validate({
	onfocusout : false
});

$(document).ready(function() {
	$("#serviceLevelEditForm").validate({
		rules : {
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
				number: true,
				digits : true,				
				min : 1,
				maxlength : 10
			},
			slvMinTransactions : {
				digits : true,
				number : true,
				min : 0,
				maxlength : 10
			},
			slvMaxTransaxtions : {
				digits : true,
				number : true,
				min : 1,
				maxlength : 10
			},
			slvBalanceCountFrequency : {
				digits : true,
				number : true,
				min : 1,
				maxlength : 10
			},
			slvStmtFrequency : {
				digits : true,
				number : true,
				min : 1,
				maxlength : 10
			}
		}
	});
});