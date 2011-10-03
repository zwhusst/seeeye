$(function() {
	/**
	 * [Widget] Date
	 */
	if ($.datepicker != undefined) {
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
	}

	/**
	 * [Widget] Birthday & Age
	 */
	$("input#ubirthday").change(function() {
		_log("[event.change] input#ubirthday");

		var birthyear = $(this).val().substr(0, 4);
		var today = new Date();
		var age = today.getFullYear() - birthyear;
		// age is 1 if born in this year
		if (age == 0) {
			age = 1;
		}
		$("select#uage").prop("selectedIndex", age - 1);
	});

	/**
	 * [Widget] Checkcode
	 */
	var baseImgSrc = $("img#img_checkcode").prop("src");

	$("a#change_checkcode").click(
			function() {
				_log("[event.click] a#change_checkcode");

				// force to reload checkcode image
				$("img#img_checkcode").prop("src",
						baseImgSrc + "?timestamp=" + new Date().getTime());
			});

	// work around to resolve stale checkcode image in IE
	$("a#change_checkcode").click();
});

/**
 * [Widget] Popup
 */
function prePopup() {
	_log("[func] prePopup");

	// get screen height/width
	var overlayHeight = $(document).height();
	var overlayWidth = $(window).width();
	// calculate shell position
	var shellTop = (overlayHeight / 3) - ($('#popup_shell').height() / 2);
	var shellLeft = (overlayWidth / 2) - ($('#popup_shell').width() / 2);
	// adjust style
	$('#popup_overlay').css({
		height : overlayHeight,
		width : overlayWidth
	}).show();
	$('#popup_shell').css({
		top : shellTop,
		left : shellLeft
	}).show();
}

function closePopup() {
	_log("[func] closePopup");

	$("div.popup").hide();
	setVisible("popup_overlay", false);
	setVisible("popup_shell", false);
}
