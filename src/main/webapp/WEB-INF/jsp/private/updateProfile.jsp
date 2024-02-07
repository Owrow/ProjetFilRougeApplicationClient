<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/general.css" />
</head>
<body>
<%@ include file="../../fragments/navbar.jspf"%>

<form action="updateProfile" method="POST">
<p >N° d'id : ${client.id } </p>

    <label for="nom">Nom :</label>
    <input type="text" name="nom" value="${client.nom }" required><br>

    <label for="prenom">Prénom :</label>
    <input type="text" name="prenom" value="${client.prenom }" required><br>

    <label for="mail">Mail :</label>
    <input type="email" name="mail" value="${client.mail }" required><br>
    
    <label for="telephone">Téléphone :</label>
    <input type="text" name="telephone" value=${client.telephone } required><br>
    
    <input type="hidden" name="id" value="${client.id }" />

    <input type="submit" value="Modifier">
</form>
<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>