<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/reservation.css">
<link rel="stylesheet" href="css/general.css" />
</head>
<body>
	<div>
		<%@ include file="../../fragments/navbar.jspf"%>
	</div>



		<div class="container mt-4">
			<div class="row">
				<div class="col-md-8">
					<div class="card">
						<div class="card-body">
							<div class="pic-resa">
								<img class="card-img-top" alt="pic" src="assets/1.jpeg" />
							</div>
							<h5 class="card-title">${restaurant.nom}</h5>
							<p class="card-text">${restaurant.adresse}</p>
							<p class="card-text">Horaires : Tous les jours de
								${restaurant.ouverture} à ${restaurant.fermeture}</p>
						</div>
					</div>
					<c:if test="${not empty sessionScope.client}">
						<div class="client-connexionState">
							<div class="reservation-form">
								<h3>Réservation</h3>
								<form action="ServletTraitementReservation" method="post">
									<input type="hidden" name="restaurantId"
										value="${ restaurant.id }">
									<div class="mb-3">
										<label for="date" class="form-label">Date de
											réservation :</label> <input type="date" class="form-control"
											id="date" name="date" required>
									</div>
									<div class="mb-3">
										<label for="creneau" class="form-label">Créneau
											horaire :</label> <select id="creneau" class="form-select"
											name="creneau" required>
											<optgroup label="Service du midi">
												<option value="12:00">12:00</option>
												<option value="12:30">12:30</option>
												<option value="13:00">13:00</option>
												<option value="13:30">13:30</option>
											</optgroup>
											<optgroup label="Service du soir">
												<option value="19:00">19:30</option>
												<option value="19:30">20:00</option>
												<option value="20:00">20:30</option>
												<option value="20:30">21:00</option>
												<option value="21:00">21:30</option>
												<option value="21:30">22:00</option>
											</optgroup>
										</select>
									</div>
									<div class="mb-3">
										<label for="tailleGroupe" class="form-label">Taille du
											groupe :</label> <input type="number" class="form-control"
											id="tailleGroupe" name="tailleGroupe" min="1" required>
									</div>
									<button type="submit" class="button-resa">Réserver</button>
								</form>
							</div></div>
					
						<h3>Contact</h3>
						<form action="messagerie" method="GET">
							<input type="hidden" name="restaurantId"
								value="${ restaurant.id }"> <input class="btn_contact"
								type="submit" value="Nous contacter !" />

						</form>
				</div>
				</c:if>

				<c:if test="${sessionScope.client.nom eq null}">
					<div class="client-connexionState">
						<p>Pour réserver ou nous contacter veuillez vous connecter ou
							vous inscrire</p>
						<div class="divForm">
							<form action="ServletInscription" method="GET">
								<input type="submit" value="S'inscrire" />
							</form>


							<form action="ServletConnection" method="GET">
								<input type="submit" value="Se connecter">
							</form>
						</div>
					</div>
				</c:if>

			</div>

		</div>
	</div>

	<div class="container mt-4">
		<div class="row">
			<div class="col">
				<div class="card menu-card">
					<div class="card-body">
						<p class="card-text">Menu - ${carte.nom}</p>
						<c:forEach var="currentCategorie" items="${categories}">
							<h3>${currentCategorie.nom}</h3>
							<c:forEach var="currentPlatCarte" items="${platCartes}">
								<c:if
									test="${currentPlatCarte.plat.categorie.id eq currentCategorie.id}">
									<ul>
										<li>${currentPlatCarte.plat.nom}</li>
										<li>${currentPlatCarte.plat.description}</li>
										<li>${currentPlatCarte.plat.prix}€</li>

									</ul>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div>
		<%@ include file="../../fragments/footer.jspf"%>
	</div>
</body>
</html>
