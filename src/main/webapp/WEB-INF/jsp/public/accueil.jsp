<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/accueil.css" />
<link rel="stylesheet" href="css/general.css" />
</head>
<body>
	<%@ include file="../../fragments/navbar.jspf"%>

	<div class="titreRestos">
		<h1 class="local">Localisation & Horaires</h1>
	</div>
	<div class="container mt-4">
		<div class="row row-cols-1 row-cols-md-2">

			<c:forEach var="current" items="${restaurants}">
				<div class="col mb-4">
					<!-- Supprimez la classe col-md-6 pour afficher une carte par colonne sur mobile -->
					<div class="card">
						<img class="card-img-top"
							src="<c:url value='/assets/${current.id}.jpeg' />" alt="Image" />
						<div class="card-body">
							<p class="card-text">${current.adresse}</p>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">Horaires :</li>
								<li class="list-group-item">Du lundi au dimanche</li>
								<li class="list-group-item">de ${current.ouverture} à
									${current.fermeture}</li>
							</ul>
							<form action="ServletTraitementReservation" method="GET">
								<input type="hidden" name="id_restaurant" value="${current.id}" />
								<c:if test="${sessionScope.client.nom ne null}">
									<input class="btn btnDetails" type="submit"
										value="Plus d'informations / Réserver" />
								</c:if>
								<c:if test="${sessionScope.client.nom eq null}">
									<input class="btn btnDetails" type="submit" value="Détails" />
								</c:if>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<%@ include file="../../fragments/footer.jspf"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
