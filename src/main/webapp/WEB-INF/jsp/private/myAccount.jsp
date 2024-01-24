<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
</head>
<body>
<%@ include file="../../fragments/navbar.jspf"%>

<h2>Profil du Client</h2>


<div>
    <p><strong>Nom :</strong> </p>
    <p><strong>Prénom :</strong> </p>
    <p><strong>Mail :</strong> </p>
    <p><strong>Téléphone :</strong> </p>
    <p><strong>Rôle :</strong> </p>
</div>


	<form action="updateProfile" method="GET">
		<input type="hidden" name="id" value="${client.id }" />
		<input type="submit" value="Modifier mon profil" />
	</form>


<form action="deleteProfile" method="POST">
     <input type="submit" value="Supprimer">
     <p>Êtes-vous sûr de vouloir supprimer votre profil ?</p>
</form>




</body>
</html>

