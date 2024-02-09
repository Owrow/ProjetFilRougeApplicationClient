<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/account.css" />
</head>
<body>
	<%@ include file="/../WEB-INF/fragments/navbar.jspf"%>

<div class="card-infos-client">

<h2>Bonjour ${client.prenom } ${client.nom } </h2>


<div id="ficheContact">


  <p>
    <label for="nom">Nom :</label>
    <a class="input"> ${client.nom }</a>
	</p>
	<p>
    <label for="prenom">Prénom :</label>
    <a class="input" >${client.prenom }</a>
	</p>
	<p>
    <label for="mail">Mail :</label>
    <a class="input" >${client.mail }</a>
    </p>
    <p>
    <label for="telephone">Téléphone :</label>
    <a class="input" >${client.telephone }</a>
    </p>
</div>


</div>
<div class="divForm">
<form action="updateProfile" method="GET">
	<input type="hidden" name="id" value="${client.id }" />
	<input type="submit" value="Modifier mon profil" />
</form>


<form id="deleteForm" action="deleteProfile" method="POST">
	<input type="hidden" name="id" value="${client.id }" />	
     <input onclick="return afficherConfirmation()" type="submit" value="Supprimer">
</form>
</div>
<%@ include file="../../fragments/footer.jspf"%>
 <script src="${pageContext.request.contextPath}/js/confirmation.js"></script>

</body>
</html>

