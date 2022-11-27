$.ajaxSetup({
    timeout: 60000 //Time in milliseconds
});

$(document).ajaxSend(function(e, xhr, options) {
	var token = $("meta[name='_csrf_header']").attr("content");
    xhr.setRequestHeader("Csrf-Token", token);
    $('#spinner').fadeIn();
});

$(document).ajaxComplete(function(e, xhr, options) {
	$("meta[name='_csrf_header']").attr("content", xhr.getResponseHeader('Csrf-Token'));
	$('#spinner').fadeOut();
});


$(document).ajaxError(function(e, xhr, options) {
	$('#spinner').fadeOut();
	$("#modal-error-body").html("Si è verificato un errore inaspettato durante l'esecuzione della chiamata.<br>Segnalare il problema all'assistenza tecnica.");
	$("#modal-error-title").html("Errore interno");
	$("#modal-error").modal('show');
}); 