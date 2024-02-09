<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/updateAccount.css" />
</head>
<body>
<%@ include file="../../fragments/navbar.jspf"%>


<div id="ficheContact">
<form action="updateProfile" method="POST">
<div class="card-infos-client">
<h2>${client.prenom }, saisissez les informations à modifier </h2>
	<p>
    <label for="nom">Nom :</label>
    <input class="input" type="text" name="nom" value="${client.nom }" required><br>
	</p>
	<p>
    <label for="prenom">Prénom :</label>
    <input class="input" type="text" name="prenom" value="${client.prenom }" required><br>
	</p>
	<p>
    <label for="mail">Mail :</label>
    <input class="input" type="email" name="mail" value="${client.mail }" required><br>
    </p>
    <p>
    <label for="telephone">Téléphone :</label>
    <input class="input" type="text" name="telephone" value=${client.telephone } required><br>
    </p>

    <input type="hidden" name="id" value="${client.id }" />
</div>
	<div class="boutonValidation">
    <input  class="validation" type="submit" value="Valider les modifications">
	</div>
</form>
</div>

<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>