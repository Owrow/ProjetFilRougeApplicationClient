<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
	<div>
		<%@ include file="../../fragments/navbar.jspf"%>
	</div>



	<div>
		<p>Affichage des informations du restaurant</p>
		<p>Nom: ${restaurant.nom}</p>
		<p>Adresse: ${restaurant.adresse}</p>
		<p>Horaires: ${restaurant.ouverture} : ${restaurant.fermeture}</p>

		<p>Menu - ${carte.nom}</p>

		<c:forEach var="currentCategorie" items="${categories}">

			<h3>${currentCategorie.nom}</h3>

			<c:forEach var="currentPlatCarte" items="${platCartes}">
				<c:if
					test="${currentPlatCarte.plat.categorie.id eq currentCategorie.id}">
					<ul>
						<li>Nom: ${currentPlatCarte.plat.nom}</li>
						<li>Prix: ${currentPlatCarte.plat.prix}</li>
						<li>Description: ${currentPlatCarte.plat.description}</li>
					</ul>
				</c:if>
			</c:forEach>
			</ul>
		</c:forEach>
	</div>

	<h3>Réservation de Restaurant</h3>

	<form action="ServletTraitementReservation" method="post">

		<input type="hidden" name="restaurantId" value="${ restaurant.id }">

		<label for="date">Date de réservation :</label> <input type="date"
			id="date" name="date" 	required> <label for="heure">Créneau
			horaire :</label> <select id="creneau" name="creneau" required>
			<optgroup>Service du midi
			</optgroup>
			<option value="12:00">12:00</option>
			<option value="12:30">12:30</option>
			<option value="13:00">13:00</option>
			<option value="13:30">13:30</option>
			<optgroup>Service du soir
			</optgroup>
			<option value="19:00">12:00</option>
			<option value="19:30">12:30</option>
			<option value="20:00">13:00</option>
			<option value="20:30">13:30</option>
			<option value="21:00">13:30</option>
			<option value="21:30">13:30</option>
		</select> <label for="tailleGroupe">Taille du groupe :</label> <input
			type="number" id="tailleGroupe" name="tailleGroupe" min="1" required>

		<button type="submit">Réserver</button>
	</form>


	<%-- <div>
		<%@ include file="../../fragments/footer.jspf"%>
	</div> --%>
</body>
</html>