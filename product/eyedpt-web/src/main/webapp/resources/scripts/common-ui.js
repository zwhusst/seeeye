var MAX_PHOTO_SIZE = 2 * 1024 * 1024; // 2M
var VALID_PHOTO_PATTERN = /\.(jpg|jpeg|png|gif)$/i;

$(function() {
	/**
	 * [Widget] Date
	 */
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

	/**
	 * [Widget] Birthday & Age
	 */
	$("input#ubirthday").change(function() {
		_log("[event.change] input#ubirthday");

		var birthyear = $(this)[0].value.substr(0, 4);
		var today = new Date();
		var age = today.getFullYear() - birthyear;
		// age is 1 if born in this year
		if (age == 0) {
			age = 1;
		}
		$("select#uage")[0].selectedIndex = age - 1;
	});

	/**
	 * [Widget] Photo
	 */
	$("input#uphoto").change(function() {
		_log("[event.change] input#uphoto");

		var filePath = $(this)[0].value;
		if (filePath.length == 0) {
			// hide preview span
			$("img#uphoto_preview").hide("slow");
			return;
		}

		// check type
		if (!filePath.match(VALID_PHOTO_PATTERN)) {
			alert("抱歉，仅支持.jpg, .jpeg, .png, .gif格式的照片。请重新选择。");
			return;
		}

		// show preview span
		$("img#uphoto_preview")[0].src = filePath;
		$("img#uphoto_preview").show("slow");
	});
});
