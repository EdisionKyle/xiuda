$.ajax({
	url: '/comm/test1.php',
	type: 'POST',
	async: true,
	data: {
		name: 'yang',
		age: 25
	},
	timeout: 5000,
	dataType: 'json',
	beforeSend: function(xhr) {

	},
	success: function(data) {
		
	},
	error: function(xhr, textStatus) {

	},
	complete: function() {

	}
});