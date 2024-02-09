<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/connexion.css" />

</head>
<body>
	<%@ include file="../../fragments/navbar.jspf"%>


<div id="ficheContact">
		<form action="ServletConnection" method="POST">
			<div class="card-infos-client">
				<h2>Veuillez vous connecter</h2>

				<p>
					<label for="mail">Mail :</label> 
					<input class="input" type="email" name="email" placeholder="exemple@exemple.fr" required><br>
				</p>

				<p>
					<label for="password">Mot de passe :</label> 
					<input class="input" type="password" name="password" required>
				</p>

			</div>
			<div class="boutonValidation">
				<input class="validation" type="submit"
					value="Se connecter">
			</div>
		</form>
	</div>


<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>
