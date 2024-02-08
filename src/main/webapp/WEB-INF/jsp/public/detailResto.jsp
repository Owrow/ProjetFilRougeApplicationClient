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


<h1>${restaurant.nom }</h1>
<p>${restaurant.adresse }</p>

<div>
    <p>Affichage des informations du restaurant</p>
    <p>Nom: ${nomRestaurant}</p>
    <p>Adresse: ${adresseRestaurant}</p>
    <p>Téléphone: ${telephoneRestaurant}</p>
    
    <p>Menu - ${carte.nom}</p>
    
    <c:forEach var="categorie" items="${categories}">
        <h3>${categorie.libelle}</h3>
        <ul>
            <c:forEach var="plat" items="${categorie.plats}">
                <li>Nom: ${plat.nom}</li>
                <li>Prix: ${plat.prix}</li>
                <li>Description: ${plat.description}</li>
            </c:forEach>
        </ul>
    </c:forEach>
   
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
