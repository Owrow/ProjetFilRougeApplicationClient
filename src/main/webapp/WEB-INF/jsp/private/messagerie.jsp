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
	<p>resturant ${restaurant.id }</p>
	<div>
		<form action="messagerie" method="POST">
		<input type="hidden" name="restaurantId" value="${restaurant.id }" /> 
			<label for="objet">Votre message :</label>
			<textarea id="story" name="message" rows="5" cols="33"></textarea>
			<input type="submit" value="Envoyer"></input>
			<input type="hidden" name="id" value="${client.id }" />
			</form>
	</div>
	


	<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>