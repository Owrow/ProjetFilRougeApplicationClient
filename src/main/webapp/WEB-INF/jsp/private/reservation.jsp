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
		<p> ${restaurant.nom}</p>
		<p>Adresse : ${restaurant.adresse}</p>
		<p>Horaires : Tous les jours de ${restaurant.ouverture} à ${restaurant.fermeture}</p>

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
	<c:if test="${not empty sessionScope.client}">
	<h3>Réservation</h3>

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
	
	<h3>Contact</h3>
	<form action="messagerie" method="GET">
		<input type="hidden" name="restaurantId" value="${ restaurant.id }">
		<input  type="submit" value="Nous contacter !" />
	
	</form>
	</c:if>
	
	<c:if test="${sessionScope.client.nom eq null}">
	<p>Pour réserver ou nous contacter veuillez vous connecter ou vous inscrire</p>
	<a href="ServletInscription">S'inscrire</a>
	<a href="ServletConnection">Se connecter</a>
	</c:if>


	<%-- <div>
		<%@ include file="../../fragments/footer.jspf"%>
	</div> --%>
</body>
</html>