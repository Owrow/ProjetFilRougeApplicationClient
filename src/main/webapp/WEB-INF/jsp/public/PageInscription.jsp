<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/inscription.css" />
</head>
<body>
	<%@ include file="../../fragments/navbar.jspf"%>

	<div id="ficheContact">
		<form action="ServletInscription" method="GET">
			<div class="card-infos-client">
				<div class="register-picture">
					<img src="assets/capuccino.jpeg" alt="Register Picture">
				</div>
				<div class="form-fields">
					<h2>Veuillez vous inscrire</h2>
					<p>
						<label for="nom">Nom :</label> <input class="input" type="text"
							name="nom" placeholder="Nom" required><br>
					</p>
					<p>
						<label for="prenom">Prénom :</label> <input class="input"
							type="text" name="prenom" placeholder="Prenom" required><br>
					</p>
					<p>
						<label for="mail">Mail :</label> <input class="input" type="email"
							name="mail" placeholder="exemple@exemple.fr" required><br>
					</p>
					<p>
						<label for="telephone">Téléphone :</label> <input class="input"
							type="text" name="telephone" placeholder="06XXXXXXXX" required><br>
					</p>
					<p>
						<label for="password">Mot de passe :</label> <input class="input"
							type="password" name="password" required>
					</p>
					<p>
						<label for="confirmPass">Confirmation du mot de passe :</label> <input
							class="input" type="password" name="confirmPass" required>
					</p>
					<div class="boutonValidation">
						<input class="validation" type="submit" value="S'inscrire">
					</div>
				</div>
			</div>

		</form>
	</div>

	<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>
