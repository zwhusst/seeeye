/**
 * [Component] Setting
 */
var rosterCount = 0;
var currentEmpId;
var currentBookingId;

$(function() {
			$("tr#proto").hide();
			$("div[id=rosters]").hide();
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
function popupActivate(employeeId) {
	_log("[func] popupActivate: " + employeeId);

	currentEmpId = employeeId;
	prePopup();
	setVisible("popup_activate", true);
}

function doActivate() {
	_log("[func] doActivate");

	var price = $("div#popup_activate input[name=price]").val();
	// validate
	if (price <= 0) {
		alert("挂号费必须大于0");
		return;
	}

	$.ajax({
				url : "setting/activate",
				type : "POST",
				data : {
					employeeId : encodeURIComponent(currentEmpId),
					price : price
				},
				success : function() {
					$("div#caps").load("setting div#caps", function() {
								// clear data
								$("div#popup_activate input[name=price]")
										.val("");
								closePopup();
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
	// validate
	if (price <= 0) {
		alert("挂号费必须大于0");
		return;
	}

	$.ajax({
				url : "setting/setcap",
				type : "POST",
				data : {
					employeeId : encodeURIComponent(currentEmpId),
					price : price
				},
				success : function() {
					// clear data
					$("div#popup_setcap input[name=price]").val("");
					closePopup();
				}
			});
}

function popupDeactivate(employeeId) {
	_log("[func] popupDeactivate: " + employeeId);

	currentEmpId = employeeId;
	$.getJSON("setting/deactivate", {
				employeeId : encodeURIComponent(currentEmpId)
			}, function(status) {

				if (status != null) {
					$("div#popup_deactivate input[name=start]")
							.val(toISODateString(new Date(status.startDate)));
					$("div#popup_deactivate input[name=end]")
							.val(toISODateString(new Date(status.endDate)));
				}

				prePopup();
				setVisible("popup_deactivate", true);
			});
}

function doDeactivate() {
	_log("[func] doDeactivate");

	var permanent = $("#radio_permanent").is(":checked");
	var startDate = $("div#popup_deactivate input[name=start]").val();
	var endDate = $("div#popup_deactivate input[name=end]").val();
	if (!permanent && endDate < startDate) {
		alert("结束日期不能早于开始日期");
		return;
	}

	$.ajax({
				url : "setting/deactivate",
				type : "POST",
				data : {
					employeeId : encodeURIComponent(currentEmpId),
					permanent : permanent,
					startDate : startDate,
					endDate : endDate
				},
				success : function() {
					$("div#caps").load("setting div#caps", function() {
								// clear data
								$("#radio_temporary")
										.prop("checked", "checked");
								$("div#popup_deactivate input[name=start]")
										.val("");
								$("div#popup_deactivate input[name=end]")
										.val("");
								closePopup();
							});
				}
			});
}

function popupViewBookingDetails(bookingId) {
	_log("[func] popupViewBookingDetails: " + bookingId);

	currentBookingId = bookingId;
	$("div#popup_view").load(
			"mgmt?bookingId=" + encodeURIComponent(currentBookingId)
					+ " div#popup_view", function() {
				prePopup();
				setVisible("popup_view", true);
			});
}

function popupUpdateBookingStatus(bookingId) {
	_log("[func] popupUpdateBookingStatus: " + bookingId);

	currentBookingId = bookingId;
	prePopup();
	setVisible("popup_update", true);
}

function doUpdateBookingStatus() {
	_log("[func] doUpdateBookingStatus");
}

// rosters
function viewRosters(employeeId) {
	_log("[func] viewRosters: " + employeeId);

	currentEmpId = employeeId;
	// mustn't use data parameter having page fragments
	$("div#rosters").load(
			"setting?employeeId=" + encodeURIComponent(employeeId)
					+ " div#rosters", function() {
				$("tr#proto").hide();
				setVisible("rosters", true);
				setVisible("caps", false);

				rosterCount = $("div#rosters tbody tr").length - 1;
				// bind click handler to delete buttons
				$("div#rosters button[name=del]").each(function(idx) {
							// skip proto roster
							if (idx == 0) {
								return;
							}
							$(this).click(function() {
										delRoster(idx);
									});
						});
			});
}

function saveRosters() {
	_log("[func] saveRosters");

	var rosters = new Array();
	$("tr[id*=roster]").each(function(idx) {
				var roster = new Object();
				// weekday
				var s = $(this).find("select:first");
				var i = $(s).prop("selectedIndex");
				roster.dayOfWeek = $(s).find("option:eq(" + i + ")").val();
				// time slot
				s = $(this).find("select:eq(1)");
				i = $(s).prop("selectedIndex");
				roster.timeSlot = $(s).find("option:eq(" + i + ")").val();
				// capability
				s = $(this).find("select:eq(2)");
				i = $(s).prop("selectedIndex");
				roster.capability = $(s).find("option:eq(" + i + ")").val();
				rosters[idx] = roster;
			});

	$.ajax({
				url : "setting/saverosters?employeeId="
						+ encodeURIComponent(currentEmpId),
				type : "POST",
				contentType : "application/json",
				data : $.toJSON(rosters),
				success : function() {
					$("div#caps").load("setting div#caps", function() {
								hideRosters();
							});
				}
			});
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
	for (var i = 0; i < rosterCount - rosterno; i++) {
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
	// update roster count
	rosterCount -= 1;
}