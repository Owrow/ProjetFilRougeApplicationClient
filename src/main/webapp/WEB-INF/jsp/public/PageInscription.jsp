<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>



<form action="ServletInscription" method="get">

<h1>Inscrivez-vous</h1>

<label for="nom">Nom :</label>
<input type="text" name="nom">

<label for="prenom">Prenom :</label>
<input type="text" name="prenom">

<label for="mail">Mail :</label>
<input type="email" name="mail">
 
 <label for="telephone">Telephone :</label>                                                                                                                                                                                        >
<input type="tel" name="telephone">

<label for="password">Mot de passe :</label>
<input type="password" name="password">

<label for="confirmPass">Confirmation du mot de passe :</label>
<input type="password" name="confirmPass">

<input type="submit" value="Valider">

</form>

</body>
</html>