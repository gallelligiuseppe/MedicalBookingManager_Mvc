$(document).ready(function() {
    $('.downloadButton').on("click", function(event) {
    	event.preventDefault();
    	var url = $(this).attr("href");
    	$.ajax({
    	    type: "GET",
    	    url: url,
    	    cache: false,
    	    xhrFields: {
    	    	responseType: 'blob'
    	    },
    	    success: function(data, textStatus, jqXHR) {
    	    	var fileName = jqXHR.getResponseHeader('fileName');
    	    	
    	    	// Firefox 1.0+
    	    	var isFirefox = typeof InstallTrigger !== 'undefined';
    	    	if(isFirefox) {
    	    		downloadFile(fileName, data);
    	    	} else {
    	    		var link = document.createElement('a');
    	    		link.style = "display: none";  
    	    		// IE & Edge fix for downloading blob files, gives option to save or open the file when the link is opened.
    	    		if (window.navigator && window.navigator.msSaveOrOpenBlob) {
    	    			window.navigator.msSaveOrOpenBlob(data, fileName);
    	    		} else {
    	    			link.href=window.URL.createObjectURL(data);
    	    			link.download=fileName;
    	    		}
    	    		link.click();
    	    	}
    	    },
    	    error: function (jqXHR, status, error) {
    	    	alert('Errore durante il download del file. Errore: ['+jqXHR.status+'], error: ['+error+'].');
    	    }
    	});
    	
    });
} );


function downloadFile(filename, data) {
	var link = document.createElement('a');
	link.style = "display: none";  
	link.href=window.URL.createObjectURL(data);
    link.download = filename;
    document.body.appendChild(link);
    link.click();
    setTimeout(function(){
        document.body.removeChild(link);
        window.URL.revokeObjectURL(url);  
    }, 100); 
}