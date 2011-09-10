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

		$("span#error_unmatch_pwd").text("请再次输入密码");
	});

	$("input#repeat_pwd").keyup(function() {
		_log("[event.keyup] input#repeat_pwd");

		var pwd = $("input#new_pwd")[0].value;
		var pwd2 = $("input#repeat_pwd")[0].value;
		if (pwd != pwd2) {
			$("span#error_unmatch_pwd").text("两次输入的密码不一致");
		} else {
			$("span#error_unmatch_pwd").text("");
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