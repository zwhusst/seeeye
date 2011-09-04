// enable load() in IE
$.ajaxSetup({
	cache : false
});

var LOG_ENABLED = (window.console != undefined);

function _log(message) {
	if (!LOG_ENABLED) {
		return;
	}

	console.log(message);
}