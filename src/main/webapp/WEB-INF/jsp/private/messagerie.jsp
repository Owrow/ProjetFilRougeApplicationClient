<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/accueil.css" />
</head>
<body>
<form action="messagerie" method="GET">
<label for="objet" >Objet :</label>
<textarea id="story" name="story" rows="1" cols="33"></textarea>
<label for="objet" >Votre message :</label>
<textarea id="story" name="story" rows="5" cols="33"></textarea>




</form>


<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>