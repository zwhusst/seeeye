var PATTERN_ACCEPTABLE_IMAGE_TYPES = /\.(jpg|jpeg|png|gif)$/i;

$(function() {
	/**
	 * [Widget] Password
	 */
	$("input#new_pwd").focus(function() {
		_log("[event.focus] input#new_pwd");

		$("input#repeat_pwd").val("");
	});

	$("input#new_pwd").keyup(function() {
		_log("[event.keyup] input#new_pwd");

		$("span#error_pwd").text("请再次输入密码");
	});

	$("input#repeat_pwd").keyup(function() {
		_log("[event.keyup] input#repeat_pwd");

		var pwd = $("input#new_pwd").val();
		var pwd2 = $("input#repeat_pwd").val();
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

		var filePath = $(this).val();
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
		$("img#uphoto_preview").prop("src", filePath);
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

/**
 * [Component] Mgmt
 */
function editDoctor(employeeId) {
	_log("[func] editDoctor: " + employeeId);

	location.href = "edit?employeeId=" + encodeURIComponent(employeeId);
}

function delDoctor(employeeId) {
	_log("[func] deleteDoctor: " + employeeId);

	$.ajax({
		url : "?employeeId=" + encodeURIComponent(employeeId),
		type : "DELETE",
		success : refreshMgmt
	});
}

function editAdmin(name) {
	_log("[func] editAdmin: " + name);

	location.href = "edit?username=" + encodeURIComponent(name);
}

function delAdmin(name) {
	_log("[func] deleteAdmin: " + name);

	$.ajax({
		url : "?name=" + encodeURIComponent(name),
		type : "DELETE",
		success : refreshMgmt
	});
}

function refreshMgmt() {
	_log("[func] refreshMgmt");

	$("div.mgmt").fadeOut("slow").load("mgmt div.mgmt").fadeIn("slow");
}

/**
 * [Component] Supervisor
 */
$(function() {
	if ($("#stbl").length > 0) {
		if ($("tr#s1 option[selected]").val() == "NA") {
			$("tr#s1 input").prop("readonly", "readonly");
		}
		if ($("tr#s2 option[selected]").val() == "NA") {
			$("tr#s2").hide();
			$("tr#s2")[0].hidden = true;
			$("tr#s2 input").prop("readonly", "readonly");
		}
		if ($("tr#s3 option[selected]").val() == "NA") {
			$("tr#s3").hide();
			$("tr#s3")[0].hidden = true;
			$("tr#s3 input").prop("readonly", "readonly");
		}

		$("tr#s1 select").change({
			input : $("tr#s1 input")
		}, supervisorTypeChanged);
		$("tr#s2 select").change({
			input : $("tr#s2 input")
		}, supervisorTypeChanged);
		$("tr#s3 select").change({
			input : $("tr#s3 input")
		}, supervisorTypeChanged);
	}
});

function supervisorTypeChanged(event) {
	_log("[func] supervisorTypeChanged");

	if ($(this).children("[value='NA']").prop("selected")) {
		event.data.input.val("");
		event.data.input.prop("readonly", "readonly");
	} else {
		event.data.input.removeProp("readonly");
	}
}

function addSupervisor() {
	_log("[func] addSupervisor");

	// show new row
	var s2 = $("tr#s2");
	var s3 = $("tr#s3");
	if (s2[0].hidden) {
		s2.show("slow");
		s2[0].hidden = false;
	} else if (s3[0].hidden) {
		s3.show("slow");
		s3[0].hidden = false;
	} else {
		alert("抱歉，最多只能添加3行导师信息。");
	}
}

function delSupervisor(id) {
	_log("[func] delSupervisor: " + id);

	// hide last row
	var s = $("tr#" + id);
	s.hide("slow");
	s[0].hidden = true;

	// reset row
	$("tr#" + id + " option[value='NA']").prop("selected", true);
	$("tr#" + id + " input").val("");
	$("tr#" + id + " input").prop("readonly", "readonly");
}