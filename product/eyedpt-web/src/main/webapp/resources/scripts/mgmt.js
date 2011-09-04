function deleteDoctor(employeeId) {
	console.log("[Func] deleteDoctor");

	$.ajax({
		url : "?employeeId=" + employeeId,
		type : "DELETE",
		success : onDeleteDone
	});
}

function onDeleteDone() {
	console.log("[Func] onDeleteDone");
}