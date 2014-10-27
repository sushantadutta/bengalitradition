/**
 * 
 */

/*
The code below to heighlight selected value
*/

$(document).ready(function() {
	$(".file").click(function() {
		$(".folder").css('color', '#000000');
		$(".folder").css('font-weight', 'normal');
		$(".file").css('color', '#000000');
		$(".file").css('font-weight', 'normal');
		$(this).css('color', '#3B5998');
		$(this).css('font-weight', 'bold');
	})
	$(".folder").click(function() {
		$(".file").css('color', '#000000');
		$(".file").css('font-weight', 'normal');
		$(".folder").css('color', '#000000');
		$(".folder").css('font-weight', 'normal');
		$(this).css('color', '#3B5998');
		$(this).css('font-weight', 'bold');
	})
})

$(document).ready(function() {
		$("#actionType").blur(function(event) {
			var strVal = $('#actionType').val();
			strVal = strVal.replace(/[^a-zA-Z 0-9 _]+/g, '');
			var capVal = strVal.toUpperCase();
			$('#actionType').val(capVal);
		});
		$("#actionType").keydown(function(event) {
			if (event.keyCode == 32) {
				event.preventDefault();
			}
		});
	});

/*$(document).ready(function() {
		$("#createActionTypeForm").validate({
			rules : {
				"acctCode" : {
					required : true,
					minlength : 5,
					maxlength : 15
				},
				"actShortName" : {
					required : true,
					minlength : 5,
					maxlength : 60
				},
				"actLongName" : {
					required : true,
					minlength : 8,
					maxlength : 200
				},
				"mappedToTable":{
			  		required: true
			  	  }
			}
		});
	});*/


$(document).ready(function() {
	$("#editActionDetailsForm").validate({
		rules : {
			"acctCode" : {
				required : true,
				minlength : 5,
				maxlength : 15
			},
			"actShortName" : {
				required : true,
				minlength : 5,
				maxlength : 60
			},
			"actLongName" : {
				required : true,
				minlength : 8,
				maxlength : 200
			},
			"mappedToTable" : {
				required : true
			}
		}
	});
});

$(document).ready(function() {
	$("#createActionAttbForm").validate({
		rules : {
			"ataAttributeName" : {
				required : true
			},
			"ataShortName" : {
				required : true
			},
			"ataLongName" : {
				required : true
			},
			"ataDataType" : {
				required : true
			}
		}
	});
	});

$(document).ready(function() {
	$("#editActionAttbForm").validate({
		rules : {
			"ataAttributeName" : {
				required : true
			},
			"ataShortName" : {
				required : true
			},
			"ataLongName" : {
				required : true
			},
			"ataDataType" : {
				required : true
			}
		}
	});
	});

$(document).ready(function() {
	$("#createMemActionTypeForm").validate({
		rules : {
			"acctCode" : {
				required : true,
				minlength : 5,
				maxlength : 15
			},
			"actShortName" : {
				required : true,
				minlength : 5,
				maxlength : 60
			},
			"actLongName" : {
				required : true,
				minlength : 8,
				maxlength : 200
			},
			"mappedToTable" : {
				required : true
			}
		}
	});
});
$(document).ready(function() {
	$("#editMemActionDetailsForm").validate({
		rules : {
			"acctCode" : {
				required : true,
				minlength : 5,
				maxlength : 15
			},
			"actShortName" : {
				required : true,
				minlength : 5,
				maxlength : 60
			},
			"actLongName" : {
				required : true,
				minlength : 8,
				maxlength : 200
			},
			"mappedToTable" : {
				required : true
			}
		}
	});
});

$(document).ready(function() {
	$("#addMemberAttbForm").validate({
		rules : {
			"ataAttributeName" : {
				required : true
			},
			"ataShortName" : {
				required : true
			},
			"ataLongName" : {
				required : true
			},
			"ataDataType" : {
				required : true
			}
		}
	});
	});	
$(document).ready(function() {
	$("#editMemberAttbForm").validate({
		rules : {
			"ataAttributeName" : {
				required : true
			},
			"ataShortName" : {
				required : true
			},
			"ataLongName" : {
				required : true
			},
			"ataDataType" : {
				required : true
			}
		}
	});
});

function getActAttbDetails() {
	var selectedValue = jQuery("select[name='attbDetails'] option:selected").val();
	
	if (selectedValue == "N") {
		document.getElementById('tree-form').style.display = 'block';
		document.getElementById('hideDivId').style.display = 'none';
	}
	if (selectedValue == "T") {
		document.getElementById('tree-form').style.display = 'none';
		document.getElementById('hideDivId').style.display = 'block';

	}

}
function getMemAttbDetails() {
	var selectedValue = jQuery("select[name='attbDetails'] option:selected").val();
	
	if (selectedValue == "N") {
		document.getElementById('tree-form').style.display = 'block';
		document.getElementById('hideDivId').style.display = 'none';
	}
	if (selectedValue == "T") {
		document.getElementById('tree-form').style.display = 'none';
		document.getElementById('hideDivId').style.display = 'block';

	}

}


$(document).ready(function() {
	$("#tree-navigation").treeview();
});

$(document).ready(function() {
	$("#tree-navigation-title").treeview();
});
$(document).ready(function() {
	$("#hideDivId").hide();
});	

/* function getActionValues(actionTypeValue){				
		var endpoint = "actionDetailsForPerticularActionType.htm?actionType="+ actionTypeValue;		
		jQuery.ajax({  
			type: "GET",
			async: false,
			url: endpoint,
			success: function(data){
				alert(data);
				jQuery("#actionDiv").html(data);				
			
		}		
			});		
	} */



/*
The code below to for ajax
*/
var xmlHttp = "";
var div = "";
function ajaxCall(url, divId) {

		xmlHttp = GetXmlHttpObject();
		if (xmlHttp == null) {
			alert("Browser does not support HTTP Request");
			return;
		}
		div = divId;
		xmlHttp.open("GET", url, true);
		xmlHttp.onreadystatechange = stateChanged;
		xmlHttp.send(null);
	}

	function stateChanged() {
		if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
			document.getElementById(div).innerHTML = xmlHttp.responseText;
		} 
	}

	function GetXmlHttpObject() {
		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}
		return xmlHttp;
	}
	
	/*
	The code below to get url paramarers 
	*/	
	function getUrlParm(name) {
		name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
		var regexS = "[\\?&]" + name + "=([^&#]*)";
		var regex = new RegExp(regexS);
		var results = regex.exec(window.location.href);
		if (results == null)
			return "";
		else
			return results[1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	