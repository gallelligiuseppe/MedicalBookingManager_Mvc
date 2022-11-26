<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="it" id="full-page">
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/custom.css"/>
</head>

<body>
	<div class="container-fluid py-3 py-md-4">
		<header id="page-header">
			<div class="row align-items-center">
				<div class="col">
					<h1>Medical Booking Manager</h1>
				</div>
			</div>
		</header>
		
		
				<form:form action="${contextPath}/checkLogin" method="post" id="id_login" modelAttribute="user">
					<div class="form-group">
						<label for="codiceFiscale" class="control-label">Utente:</label>
						<form:input type="text" id="codiceFiscale" path="codiceFiscale" cssClass="form-control" maxlength="16" required/>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<div class="input-group input-group-lg">
							<form:input type="text" id="password" path="password" cssClass="form-control" maxlength="20" required/>
							<div class="input-group-append" aria-hidden="true">
								<button type="button" class="btn btn-default btn-show-hide" title="Mostra password">
									<i class="fas fa-eye"></i>
								</button>
							</div>
						</div>
					</div>
	
					<!-- Messaggio di errore da valorizzare e visualizzare in caso di autenticazione fallita -->
					<c:if test="${not empty errorMessage}">
						<div id="login-msg" class="alert alert-danger d-flex" role="alert" tabindex="0">
							<p class="alert-content">${errorMessage}</p>
						</div>
					</c:if>
					<button id="btn-accedi" type="submit" class="btn btn-lg btn-block">
						<i class="fas fa-sign-in-alt mr-2"></i>ACCEDI
					</button>	
				</form:form>
	</div>
</body>
