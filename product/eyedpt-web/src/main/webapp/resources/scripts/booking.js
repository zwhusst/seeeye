/**
 * [Component] Setting
 */
// start with 1
var cap2roster = new Array();

$(function() {
	$("div[id*=rosters]").hide();
	$("tr[id*=proto]").hide();

	// fill cap2roster
	cap2roster[0] = 0;
	for ( var i = 1; i <= $("div#caps tbody tr").length; i++) {
		// exclude proto roster
		cap2roster[i] = $("div#rosters" + i + " tbody tr").length - 1;
	}
});

function activate(employeeid) {
	_log("[func] activate: " + employeeId);
}

function setcap(employeeid) {
	_log("[func] setcap: " + employeeId);
}

function deactivate(employeeid) {
	_log("[func] deactivate: " + employeeId);
}

function view(no) {
	_log("[func] view: " + no);

	setVisible($("div#rosters" + no), true);
}

function cancel(no) {
	_log("[func] cancel: " + no);

	setVisible($("div#rosters" + no), false);
}

function setVisible(div, visible) {
	_log("[func] setVisible: " + div);

	if (visible) {
		$("div#caps").hide("fast");
		div.show("slow");
	} else {
		div.hide("slow");
		$("div#caps").show("fast");
	}
}

function addRoster(capno) {
	_log("[func] addRoster: " + capno);

	// update cap2roster
	cap2roster[capno] += 1;
	// clone proto roster
	var protoRoster = $("tr#proto" + capno);
	var newRoster = protoRoster.clone();
	// update id
	newRoster.prop("id", "roster" + cap2roster[capno]);
	// update row no
	newRoster.children("td:first").text(cap2roster[capno]);
	// bind actions
	var delBtn = newRoster.find("button[name=del]");
	delBtn.click({
		capno : capno,
		rosterno : cap2roster[capno]
	}, function(event) {
		delRoster(event.data.capno, event.data.rosterno);
	});
	// append as last roster
	newRoster.appendTo($("div#rosters" + capno + " tbody:last"));
	// show it up
	newRoster.show("slow");
}

function delRoster(capno, rosterno) {
	_log("[func] delRoster: " + capno + "," + rosterno);

	// get roster to delete
	var roster = $("div#rosters" + capno + " tr#roster" + rosterno);
	// update row no behind
	var next = roster;
	var nextno;
	for ( var i = 0; i < cap2roster[capno] - rosterno; i++) {
		next = next.next();
		nextno = rosterno + i;
		// update id
		next.prop("id", "roster" + nextno);
		// update row no
		next.children("td:first").text(nextno);
		// rebind actions
		var delBtn = next.find("button[name=del]");
		delBtn.unbind("click");
		delBtn.click({
			capno : capno,
			rosterno : nextno
		}, function(event) {
			delRoster(event.data.capno, event.data.rosterno);
		});
	}
	// delete roaster
	roster.remove();
	// update cap2roster
	cap2roster[capno] -= 1;
}