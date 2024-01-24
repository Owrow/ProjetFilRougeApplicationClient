<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" href="css/accueil.css" />
</head>
<body>
	<%@ include file="../../fragments/navbar.jspf"%>

	
	<div class="container-accueil">
		<c:forEach var="current" items='${restaurants }'>
		<div class="resto-box">
			<p>${current.nom }</p>
			<p>${current.adresse }</p>
						
			<div class="picResto">
			 <img src="<c:url value='/assets/${current.id }.jpeg' />" alt="Image" />
			</div>
			
			
				<form action="detailResto" method="GET">
					<input type="hidden" name="id" value='${current.id}' /> 
					<input class="btnDetails" type="submit" value="Réserver" />
				</form>
				</div>
		</c:forEach>
	</div>
<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>