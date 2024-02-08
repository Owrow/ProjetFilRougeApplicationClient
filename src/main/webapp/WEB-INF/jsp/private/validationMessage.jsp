<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%@ include file="../../fragments/navbar.jspf"%></div>

<h1> ${client.prenom } Votre message a bien été envoyé</h1>

<form action="accueil" method="GET">
<input type="submit" value="Revenir à l'accueil">
</form>

</body>
</html>