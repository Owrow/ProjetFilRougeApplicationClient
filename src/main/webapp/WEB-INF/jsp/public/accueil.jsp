<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PATE D'OR</title>
<link rel="stylesheet" href="css/accueil.css" />
</head>
<body>
	
	<div>
		<c:forEach var="current" items='${restaurants }'>
			<p>${current.nom }</p>
		</c:forEach>
	</div>

</body>
</html>