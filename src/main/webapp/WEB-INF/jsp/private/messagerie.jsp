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


<form action="messagerie" method="POST">
<label for="objet" >Objet :</label>
<textarea id="story" name="story" rows="1" cols="33"></textarea>
<label for="objet" >Votre message :</label>
<textarea id="story" name="story" rows="5" cols="33"></textarea>




</form>


<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>