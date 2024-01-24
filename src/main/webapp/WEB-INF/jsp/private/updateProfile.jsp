<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateProfile" method="POST">
    <label for="nom">Nom :</label>
    <input type="text" name="nom" value="${client.nom }" required><br>

    <label for="prenom">Prénom :</label>
    <input type="text" name="prenom" value="${client.prenom }" required><br>

    <label for="mail">Mail :</label>
    <input type="email" name="mail" value="${client.mail }" required><br>

    <label for="telephone">Téléphone :</label>
    <input type="text" name="telephone" value=${client.telephone } required><br>

    <input type="submit" value="Modifier">
</form>

</body>
</html>