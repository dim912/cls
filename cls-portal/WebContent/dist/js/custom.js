$(function() {
	$("#element_5").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showOn : "button",
		buttonImage : "../images/calendar.gif",
		buttonImageOnly : true,
		buttonText : "Select date"
	});

});


function showMessage() {
		$('#dummyModal').modal('show');
};