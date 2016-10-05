var exec = require('cordova/exec');
module.exports = {
	show : function(id, title, message, success, error) {
	    exec(success, error, "Notification", "notify", [id, title, message]);
	}
};