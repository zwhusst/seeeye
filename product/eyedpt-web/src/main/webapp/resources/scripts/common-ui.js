$(function() {
	$.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
	$("input.inputdate").datepicker(
			{
				showOn : "button",
				buttonImage : "../resources/images/calendar.gif",
				buttonImageOnly : true,
				dateFormat : "yy-mm-dd",
				changeYear : true,
				changeMonth : true,
				yearRange : "c-99:c",
				yearSuffix : "",
				monthNamesShort : [ "1", "2", "3", "4", "5", "6", "7", "8",
						"9", "10", "11", "12" ]
			});

	$("input#birthday").bind("change", function() {
		var birthyear = $(this)[0].value.substr(0, 4);
		var today = new Date();
		var age = today.getFullYear() - birthyear;
		// age is 1 if born in this year
		if (age == 0) {
			age = 1;
		}
		$("select#age")[0].selectedIndex = age - 1;
	});
});
