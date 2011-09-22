/**
 * [Component] Setting
 */
var rosterCount = 0;

$(function() {
	$("div[id=rosters]").hide();
	$("tr[id=proto]").hide();

	rosterCount = $("div#rosters tbody tr").length - 1;
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

function view(employeeid) {
	_log("[func] view: " + employeeid);

	$("div#rosters").load(
			"setting?employeeId=" + encodeURIComponent(employeeid)
					+ " div#rosters", function() {
				$("tr[id=proto]").hide();
			});
	setVisible($("div#rosters"), true);
}

function cancel(divId) {
	_log("[func] cancel: " + divId);

	setVisible($("div#" + divId), false);
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

function addRoster() {
	_log("[func] addRoster");

	// update rosterCount
	rosterCount += 1;
	// clone proto roster
	var protoRoster = $("tr#proto");
	var newRoster = protoRoster.clone();
	// update id
	newRoster.prop("id", "roster" + rosterCount);
	// update row no
	newRoster.children("td:first").text(rosterCount);
	// bind actions
	var delBtn = newRoster.find("button[name=del]");
	delBtn.click({
		rosterno : rosterCount
	}, function(event) {
		delRoster(event.data.rosterno);
	});
	// append as last roster
	newRoster.appendTo($("div#rosters tbody:last"));
	// show it up
	newRoster.show("slow");
}

function delRoster(rosterno) {
	_log("[func] delRoster: " + rosterno);

	// get roster to delete
	var roster = $("div#rosters tr#roster" + rosterno);
	// update row no behind
	var next = roster;
	var nextno;
	for ( var i = 0; i < rosterCount - rosterno; i++) {
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
			rosterno : nextno
		}, function(event) {
			delRoster(event.data.rosterno);
		});
	}
	// delete roaster
	roster.remove();
	// update cap2roster
	rosterCount -= 1;
}