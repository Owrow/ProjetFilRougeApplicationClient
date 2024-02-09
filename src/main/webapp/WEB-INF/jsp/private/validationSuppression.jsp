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
	<h1>${client.prenom } voulez-vous confirmer la suppression de
		votre profil ?</h1>

	<form action="deleteProfile" method="POST">
		<input type="hidden" name="id" value="${client.id }" /> <input
			type="submit" value="Supprimer">
		<p>Je confirme la suppression</p>
	</form>
	<form action="myAccount" method="GET">
		<input type="hidden" name="id" value="${client.id }" /> <input
			type="submit" value="Redirection">
		<p>Non je garde mon profil</p>
	</form>

</body>
</html>