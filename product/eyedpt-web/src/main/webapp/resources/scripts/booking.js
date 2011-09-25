/**
 * [Component] Setting
 */
var rosterCount = 0;
var currentEmpId;

$(function() {
	$("div[id=rosters]").hide();
	$("tr[id=proto]").hide();

	rosterCount = $("div#rosters tbody tr").length - 1;
});

function setVisible(divId, visible, mode) {
	_log("[func] setVisible: " + divId + "," + visible);

	if (visible) {
		$("div#" + divId).show(mode);
	} else {
		$("div#" + divId).hide(mode);
	}
}

// popups
function prePopup() {
	_log("[func] prePopup");

	// get screen height/width
	var overlayHeight = $(document).height();
	var overlayWidth = $(window).width();
	// calculate shell position
	var shellTop = (overlayHeight / 3) - ($('#popup_shell').height() / 2);
	var shellLeft = (overlayWidth / 2) - ($('#popup_shell').width() / 2);
	// adjust style
	$('#popup_overlay').css({
		height : overlayHeight,
		width : overlayWidth
	}).show();
	$('#popup_shell').css({
		top : shellTop,
		left : shellLeft
	}).show();
}

function popupActivate(employeeId) {
	_log("[func] popupActivate: " + employeeId);

	currentEmpId = employeeId;
	prePopup();
	setVisible("popup_activate", true);
}

function doActivate() {
	_log("[func] doActivate");

	var price = $("div#popup_activate input[name=price]").val();
	$.ajax({
		url : "setting/activate",
		data : {
			employeeId : encodeURIComponent(currentEmpId),
			price : price
		},
		type : "POST",
		success : function() {
			$("div#caps").load("setting div#caps", function() {
				closePopup("popup_activate");
			});
		}
	});
}

function popupSetcap(employeeId) {
	_log("[func] popupSetcap: " + employeeId);

	currentEmpId = employeeId;
	$.getJSON("setting/setcap", {
		employeeId : encodeURIComponent(currentEmpId)
	}, function(price) {
		$("div#popup_setcap input[name=price]").val(price);

		prePopup();
		setVisible("popup_setcap", true);
	});
}

function doSetcap() {
	_log("[func] doSetcap");

	var price = $("div#popup_setcap input[name=price]").val();
	$.ajax({
		url : "setting/setcap",
		data : {
			employeeId : encodeURIComponent(currentEmpId),
			price : price
		},
		type : "POST",
		success : function() {
			closePopup("popup_setcap");
		}
	});
}

function popupDeactivate(employeeId) {
	_log("[func] popupDeactivate: " + employeeId);

	prePopup();
	setVisible("popup_deactivate", true);
}

function doDeactivate() {
	_log("[func] doDeactivate");

}

function closePopup(divId) {
	_log("[func] closePopup: " + divId);

	$("div.popup").hide();
	setVisible("popup_overlay", false);
	setVisible("popup_shell", false);
}

// rosters
function viewRosters(employeeId) {
	_log("[func] viewRosters: " + employeeId);

	// mustn't use data parameter having page fragments
	$("div#rosters").load(
			"setting?employeeId=" + encodeURIComponent(employeeId)
					+ " div#rosters", function() {
				$("tr[id=proto]").hide();
			});
	setVisible("caps", false);
	setVisible("rosters", true);
}

function hideRosters() {
	_log("[func] hideRosters");

	setVisible("rosters", false);
	setVisible("caps", true);
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