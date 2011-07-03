function deleteEmployee(empId) {
	req = new XMLHttpRequest();
	req.open("DELETE", "employees/" + empId, true);
	req.onreadystatechange = onDelete;
	req.send();
}

function onDelete() {
	alert("Deleted!");
}