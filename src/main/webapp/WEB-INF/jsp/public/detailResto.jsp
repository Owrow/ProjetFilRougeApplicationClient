<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PATE D'OR</title>
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

</body>
</html>