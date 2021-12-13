<%@page import="fr.eni.projetEncheres.bo.Articles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creation Article</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<h1>Gestion Article</h1>
	<h2>Ajout Article</h2>
	
		<c:if test="${!empty sessionScope.pseudoSession}"> <p>Création article : ${sessionScope.pseudoSession}</p> </c:if>
	<form method="post" action="/ProjetENI_1_Encheres/ServletCreationArticles">
		
		<label for="nom_article"> Nom :</label> 
		<input type="text" id="nom_article" name="nom_article" placeholder="Article"> 
		
		<label for="description"> Description:</label> 
		<input type="text" id="description" name="description" placeholder="description">
		
		<label for="date_debut_encheres"> Date de début des enchères :</label> 
		<input type="date" id="date_debut_encheres" name="date_debut_encheres">
		
		<label for="date_fin_encheres"> Date de fin des enchères :</label> 
		<input type="date" id="date_fin_encheres" name="date_fin_encheres"> 	
		
		<label for="prix_initial"> Prix:</label> 
		<input type="number"id="prix_initial" name="prix_initial"> 
		
		<label for="categorie">Catégorie:</label>

		<select name="categorie" id="categorie">
		    <option value="">--Choisir une catégorie--</option>
		    <option value=1>Informatique</option>
		    <option value=2>Ameublement</option>
		    <option value=3>Vêtement</option>
		    <option value=4>Sport et Loisirs</option>
		</select>
			<input type="submit"> 
		</form>
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>

</body>
</html>