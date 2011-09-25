// enable load() in IE
$.ajaxSetup({
	cache : false
});

var LOG_ENABLED = (window.console != undefined);

/**
 * Logs the given message.
 * 
 * @param message
 */
function _log(message) {
	if (!LOG_ENABLED) {
		return;
	}

	console.log(message);
}

/**
 * Converts the given date to string in ISO format, i.e., "YYYY-MM-DD".
 * 
 * @param date
 * @returns {String}
 */
function toISODateString(date){
	var fullMonth = date.getMonth()+1;
	if(fullMonth<10){
		fullMonth = "0"+fullMonth;
	}
	
	var fullDate = date.getDate();
	if(fullDate<10){
		fullDate = "0"+fullDate;
	}
	
	return date.getFullYear()+"-"+fullMonth+"-"+fullDate;
}