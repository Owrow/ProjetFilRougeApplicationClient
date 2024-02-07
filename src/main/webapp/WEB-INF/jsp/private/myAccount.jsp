<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
<link rel="stylesheet" href="css/general.css" />
</head>
<body>
<%@ include file="../../fragments/navbar.jspf"%>


<h2>Bonjour ${client.prenom }</h2>


<div>
    <p><strong>Nom : ${client.nom}</strong> </p>
    <p><strong>Prénom : ${client.prenom}</strong> </p>
    <p><strong>Mail : ${client.mail}</strong> </p>
    <p><strong>Téléphone : ${client.telephone}</strong> </p>
</div>


<form action="updateProfile" method="GET">
	<input type="hidden" name="id" value="${client.id }" />
	<input type="submit" value="Modifier mon profil" />
</form>


<form action="deleteProfile" method="GET">
	<input type="hidden" name="id" value="${client.id }" />	
     <input type="submit" value="Supprimer">
     <p>Êtes-vous sûr de vouloir supprimer votre profil ?</p>
</form>


<%@ include file="../../fragments/footer.jspf"%>

</body>
</html>

