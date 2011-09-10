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