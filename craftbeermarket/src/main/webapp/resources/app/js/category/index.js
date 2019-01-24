$(document).ready(function(){
	$(".delete").click(function(event){
		event.preventDefault();
		var message = $("#confirmMessage").val();
		var ok = confirm(message);
		if (ok == true) {
			location.href = $(this).attr('href');
		}
	});
});
