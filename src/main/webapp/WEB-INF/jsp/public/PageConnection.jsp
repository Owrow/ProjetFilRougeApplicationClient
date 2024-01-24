<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection</title>
<link rel="stylesheet" href="css/general.css" />

</head>
<body>
	<%@ include file="../../fragments/navbar.jspf"%>

<form action="ServletConnection" method="post">

<h1>Veuillez vous connecter</h1>

<label>Mail :</label>
<input type="email" name="email">

<label>Mot De Passe :</label>
<input type="password" name="password">

<input type="submit" value="Valider" >

</form>


<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>
