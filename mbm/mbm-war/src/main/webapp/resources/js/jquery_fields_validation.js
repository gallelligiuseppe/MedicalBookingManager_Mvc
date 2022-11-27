/*
 * Questo file deve essere importato nella commonHead.jsp.
 * Tramite le classi css applicate ai vari input type dei form è possibile applicare una validazione di tipo whitelist.
 * I tipi di validazione sono i seguenti:
 * 
 * 		1 - allow-only-currency-validation : Consente l'inserimento di soli numeri (da 0 a 9) con l'aggiunta dei soli caratteri virgola "," e punto "."
 * 											 Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire una valuta o un numero decimale.
 * 
 * 		2 - allow-only-numbers-validation :	 Consente l'inserimento di soli numeri (da 0 a 9) più il segno meno "-"
 * 											 Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire soltanto valori numerici interi.	
 * 
 * 		3 - allow-only-phone-numbers-validation : Consente l'inserimento di soli numeri (da 0 a 9)
 * 												  Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire un numero di telefono				
 * 
 * 		4 - date-validation : Consente l'inserimento di soli numeri (da 0 a 9) con l'aggiunta del segno slash "/".
 * 							  Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire una data con formattazione gg/MM/aaaaa oppure MM/aaaa
 * 
 * 		5 - allow-only-chars-validation : Consente l'inserimento di soli caratteri maiuscoli e minuscoli (a-zA-Z) escludendo qualsiasi altro tipo di carattere, numero o segno speciale.
 * 										  Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire una stringa semplice, come ad esempio nome e cognome.
 * 
 * 		6 - email-validation : Consente l'inserimento di caratteri maiuscoli e minuscoli (a-zA-Z) con l'aggiunta dei numeri (0-9) e dei soli caratteri underscore "_", punto "." e segno meno "-".
 * 										  Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire un indirizzo email.
 * 
 * 		7 - allow-only-alphanumeric-validation : Consente l'inserimento di soli caratteri maiuscoli e minuscoli (a-zA-Z) e numeri (0-9) escludendo qualsiasi altro tipo di carattere.
 * 										  		 Utilizzare questa classe CSS per tutti gli input type all'interno dei quali è necessario inserire una stringa semplice con aggiunta di numeri, come ad esempio un codice fiscale.
 *  
 * */

$(document).ready(function() {
	
	
	/**************************************************************************************************************************************************
	 ********************************************************* Validazione dei campi VALUTA ***********************************************************
	 **************************************************************************************************************************************************/
	$('.allow-only-currency-validation').keypress(function(key) {
		return validateOnlyCurrency(key.charCode);
	});
	
	$('.allow-only-currency-validation').focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateOnlyCurrency(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateOnlyCurrency(charCode) {
		//only chars uppercase and lowercase allowed and "."
		var inp = String.fromCharCode(charCode);
		return (/[0-9.]/.test(inp));
		return isAllowed;
	};
	
	/**************************************************************************************************************************************************
	 ********************************************************* Validazione dei campi NUMERICI *********************************************************
	 **************************************************************************************************************************************************/
	$('.allow-only-numbers-validation').keypress(function(key) {
		return validateOnlyNumbers(key.charCode);
	});
	
	$('.allow-only-numbers-validation').focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateOnlyNumbers(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateOnlyNumbers(charCode) {
		//only positive and negative "-" numbers
		var inp = String.fromCharCode(charCode);
		return (/[0-9-]/.test(inp));
	};
	
	
	/************************************************************************************************************************************************************
	 ********************************************************* Validazione dei campi NUMERO DI TELEFONO *********************************************************
	 ************************************************************************************************************************************************************/
	$('.allow-only-phone-numbers-validation').keypress(function(key) {
		return validatePhoneNumbers(key.charCode);
	});
	
	$(".allow-only-phone-numbers-validation").focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validatePhoneNumbers(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validatePhoneNumbers(charCode) {
		//only positive numbers allowed
		var inp = String.fromCharCode(charCode);
		return (/[0-9]/.test(inp));
	};
	
	/**********************************************************************************************************************************************
	 ********************************************************* Validazione dei campi DATA *********************************************************
	 **********************************************************************************************************************************************/
	$('.date-validation').keypress(function(key) {
		return validateDate(key.charCode);
	});
	
	$('.date-validation').focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateDate(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateDate(charCode) {
		if(charCode >= 47 && charCode <= 57) {
			return true;
		} else {
			return false;
		}
	};
	
	/**************************************************************************************************************************************************
	 ********************************************************* Validazione dei campi SOLOCARATTERI ****************************************************
	 **************************************************************************************************************************************************/
	$('.allow-only-simple-string-validation').keypress(function(key) {
		//only chars uppercase and lowercase allowed
		return validateOnlyChars(key.charCode);
	});
	
	$(".allow-only-simple-string-validation").focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateOnlyChars(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateOnlyChars(charCode) {
		//only chars uppercase and lowercase allowed and " " and "'" 
		var inp = String.fromCharCode(charCode);
		return (/[a-zA-Z ']/.test(inp));
	};
	
	
	/**********************************************************************************************************************************************
	 ********************************************************* Validazione dei campi EMAIL ********************************************************
	 **********************************************************************************************************************************************/
	$('.email-validation').keypress(function(key) {
		return validateEmail(key.charCode);
	});
	
	$(".email-validation").focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateEmail(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateEmail(charCode) {
		//only chars uppercase and lowercase allowed and "@" and "_" and "." and "-"
		var inp = String.fromCharCode(charCode);
		return (/[a-zA-Z0-9@_.-]/.test(inp));
	};
	
	/*******************************************************************************************************************************************************
	 ********************************************************* Validazione dei campi CODICE FISCALE ********************************************************
	 *******************************************************************************************************************************************************/
	$('.allow-only-alphanumeric-validation').keypress(function(key) {
		//only chars uppercase and lowercase allowed
		return validateAlphanumeric(key.charCode);
	});
	
	$(".allow-only-alphanumeric-validation").focusout(function() {
		var str = $(this).val();
		var isValid = true;
		for (var i = 0; i < str.length; i++) {
			isValid = isValid && validateAlphanumeric(str.charAt(i).charCodeAt(0));
		}
		
		if(!isValid) {
			$(this).val("");
		}
	});
	
	function validateAlphanumeric(charCode) {
		var inp = String.fromCharCode(charCode);
		return (/[a-zA-Z0-9]/.test(inp));
	};
	
});