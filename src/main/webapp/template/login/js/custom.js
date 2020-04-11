function hideMessage() {
	$('#span-email-exist').attr("hidden", "hidden");
	$('#btn-register').removeAttr("disabled");
}

function showMessage() {
	$('#span-email-exist').removeAttr('hidden');
	$('#btn-register').attr("disabled", "disabled");
}

$(document).ready(function() {
	$('#input-register-email').keyup(function() {
		clearTimeout($(this).data('timeout'));
		$(this).data('timeout', setTimeout(function() {
			if ($('#input-register-email').val() !== '') {
				var data = {
					email : $('#input-register-email').val()
				}
				$.ajax({
					url : '/api/users?action=check_email_exist',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						if (result == 1) {
							showMessage();
						} else{
							hideMessage();
						}
					}
				});
			} else {
				hideMessage();
			}
		}, 500));

	});
});