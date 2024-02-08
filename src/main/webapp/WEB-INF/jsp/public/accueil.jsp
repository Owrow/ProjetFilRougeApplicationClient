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
			
			
				<form action="ServletTraitementReservation" method="GET">
					<input type="hidden" name="id_restaurant" value='${current.id}' /> 
					<c:if test="${sessionScope.client.nom ne null}">
					<input class="btnDetails" type="submit" value="Plus d'informations / Réserver" />
					</c:if>
					<c:if test="${sessionScope.client.nom eq null}">
					<input class="btnDetails" type="submit" value="Accéder aux informations du restaurant" />
					</c:if>
					
				</form>
				</div>
		</c:forEach>
	</div>
<%@ include file="../../fragments/footer.jspf"%>
</body>
</html>