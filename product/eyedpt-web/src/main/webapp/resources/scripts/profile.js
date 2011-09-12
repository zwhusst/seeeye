var PATTERN_ACCEPTABLE_IMAGE_TYPES = /\.(jpg|jpeg|png|gif)$/i;

$(function() {
	/**
	 * [Widget] Password
	 */
	$("input#new_pwd").focus(function() {
		_log("[event.focus] input#new_pwd");

		$("input#repeat_pwd")[0].value = "";
	});

	$("input#new_pwd").keyup(function() {
		_log("[event.keyup] input#new_pwd");

		$("span#error_pwd").text("请再次输入密码");
	});

	$("input#repeat_pwd").keyup(function() {
		_log("[event.keyup] input#repeat_pwd");

		var pwd = $("input#new_pwd")[0].value;
		var pwd2 = $("input#repeat_pwd")[0].value;
		if (pwd != pwd2) {
			$("span#error_pwd").text("两次输入的密码不一致");
		} else {
			$("span#error_pwd").text("");
		}
	});

	$("input#repeat_pwd").parents("form").submit(function() {
		_log("[event.submit] form");

		if ($("span#error_pwd").text() != "") {
			$("span#error_pwd").fadeOut().fadeIn();
			// prevent submit
			return false;
		}
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
		if (!filePath.match(PATTERN_ACCEPTABLE_IMAGE_TYPES)) {
			alert("抱歉，只接受.jpg/.jpeg/.png/.gif格式的照片。请重新选择。");
			$("span#error_uphoto").text("只接受.jpg/.jpeg/.png/.gif格式的照片");
			$("img#uphoto_preview").hide("slow");
			return;
		}
		
		// clear error message
		$("span#error_uphoto").text("");

		// show preview span
		$("img#uphoto_preview")[0].src = filePath;
		$("img#uphoto_preview").show("slow");
	});

	$("input#uphoto").parents("form").submit(function() {
		_log("[event.submit] form");

		if ($("span#error_uphoto").text() != "") {
			$("span#error_uphoto").fadeOut().fadeIn();
			// prevent submit
			return false;
		}
	});
});

function editDoctor(employeeId) {
	_log("[func] editDoctor: " + employeeId);

	location.href = "edit?employeeId=" + encodeURIComponent(employeeId);
}

function deleteDoctor(employeeId) {
	_log("[func] deleteDoctor: " + employeeId);

	$.ajax({
		url : "?employeeId=" + encodeURIComponent(employeeId),
		type : "DELETE",
		success : onDeleteDone
	});
}

function editAdmin(name) {
	_log("[func] editAdmin: " + name);

	location.href = "edit?username=" + encodeURIComponent(name);
}

function deleteAdmin(name) {
	_log("[func] deleteAdmin: " + name);

	$.ajax({
		url : "?name=" + encodeURIComponent(name),
		type : "DELETE",
		success : onDeleteDone
	});
}

function onDeleteDone() {
	_log("[func] onDeleteDone");

	$("div.mgmt").fadeOut("slow").load("mgmt div.mgmt").fadeIn("slow");
}