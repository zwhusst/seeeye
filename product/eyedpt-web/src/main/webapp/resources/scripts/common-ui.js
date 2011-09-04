$(function() {
	$.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
	$("input.inputdate").datepicker({
		showOn : "button",
		buttonImage : "../resources/images/calendar.gif",
		buttonImageOnly : true,
		dateFormat: "yy-mm-dd"
	});
});