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
	<h1>Gestion Article</h1>
	<h2>Ajout Article</h2>
	
	<c:if test="${!empty articlesListe}">
		<c:forEach var="article" items="${articlesListe}">
			<p>
				${article}
			</p>
		</c:forEach>
	</c:if>
		
	<form method="post" action="/ProjetENI_1_Encheres/ServletCreationArticles">
		
		<label for="nom_article"> Nom :</label> 
		<input type="text" id="nom_article" name="nom_article" placeholder="Article"> 
		
		<label for="description"> Description :</label> 
		<input type="text" id="description" name="description" placeholder="description">
		
		<label for="date_debut_encheres"> Date de début des enchères :</label> 
		<input type="date" id="date_debut_encheres" name="date_debut_encheres">
		
		<label for="date_fin_encheres"> Date de fin des enchères :</label> 
		<input type="date" id="date_fin_encheres" name="date_fin_encheres"> 	
		
		<label for="prix_initial"> Prix:</label> 
		<input type="number"id="prix_initial" name="prix_initial"> 
		
			<input type="submit"> 
		</form>

</body>
</html>