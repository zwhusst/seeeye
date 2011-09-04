function deleteDoctor(employeeId) {
	_log("[Func] deleteDoctor: " + employeeId);

	$.ajax({
		url : "?employeeId=" + employeeId,
		type : "DELETE",
		success : onDeleteDone
	});
}

function deleteAdmin(name) {
	_log("[Func] deleteAdmin: " + name);

	$.ajax({
		url : "?name=" + name,
		type : "DELETE",
		success : onDeleteDone
	});
}

function onDeleteDone() {
	_log("[Func] onDeleteDone");

	$("div.mgmt").fadeOut("slow").load("mgmt div.mgmt").fadeIn("slow");
}