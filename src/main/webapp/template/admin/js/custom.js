$(document).ready(function(){
	$("#btn-save-change").click(function(event) {
		event.preventDefault();
		var password = $('#new-password').val();
		var confirm = $('#confirm').val();
        if (password !== confirm) {
            $('#confirm-incorrect').removeAttr('hidden');
        } else {
            $('#confirm-incorrect').attr('hidden', 'hidden');
            $('#form-profile').submit();
        }
    });
});