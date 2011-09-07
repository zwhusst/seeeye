function editDoctor(employeeId) {
	_log("[Func] editDoctor: " + employeeId);

	location.href = "edit?employeeId=" + encodeURIComponent(employeeId);
}

function deleteDoctor(employeeId) {
	_log("[Func] deleteDoctor: " + employeeId);

	$.ajax({
		url : "?employeeId=" + encodeURIComponent(employeeId),
		type : "DELETE",
		success : onDeleteDone
	});
}

function editAdmin(name) {
	_log("[Func] editAdmin: " + name);

	location.href = "edit?username=" + encodeURIComponent(name);
}

function deleteAdmin(name) {
	_log("[Func] deleteAdmin: " + name);

	$.ajax({
		url : "?name=" + encodeURIComponent(name),
		type : "DELETE",
		success : onDeleteDone
	});
}

function onDeleteDone() {
	_log("[Func] onDeleteDone");

	$("div.mgmt").fadeOut("slow").load("mgmt div.mgmt").fadeIn("slow");
}