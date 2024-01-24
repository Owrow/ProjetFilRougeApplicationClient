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
	<div>
		<h1>Bonjour ${client.prenom }</h1>
	</div>
	<div>
		<h3>Contactez nous !</h3>
	</div>
	<div>
		<form action="messagerie" method="POST">
			<label for="objet">Objet :</label>
			<textarea id="story" name="sujet" rows="1" cols="33"></textarea>
			<label for="objet">Votre message :</label>
			<textarea id="story" name="message" rows="5" cols="33"></textarea>
			<button type="button" value="submit">Envoyer !</button>
			</form>
	</div>
	&


	<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>