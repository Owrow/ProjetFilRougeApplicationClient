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


<h2>Bonjour ${client.prenom } ${client.nom } </h2>


<div id="ficheContact">

    <p>Nom : ${client.nom } </p>
    <p>Prénom : ${client.prenom } </p>
    <p>Mail : ${client.mail } </p>
    <p>Téléphone : ${client.telephone }</p>
  
</div>

<form action="updateProfile" method="GET">
	<input type="hidden" name="id" value="${client.id }" />
	<input type="submit" value="Modifier mon profil" />
</form>


<form action="deleteProfile" method="GET">
	<input type="hidden" name="id" value="${client.id }" />	
     <input type="submit" value="Supprimer">
</form>


<%@ include file="../../fragments/footer.jspf"%>

</body>
</html>

