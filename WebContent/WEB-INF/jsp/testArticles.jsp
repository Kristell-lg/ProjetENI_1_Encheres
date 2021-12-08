<%@page import="fr.eni.projetEncheres.bo.Articles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Article</title>
</head>
<body>
	<h1>Gestion Article</h1>
	<h2>Ajout Article</h2>
	
	<c:if test="${!empty a}">

	<p>
	${a.getNo_article()}
	${a.getNom_article()} 
	${a.getDescription()}
	${a.getDate_debut_encheres()}
	${a.getDate_fin_encheres()}
	${a.getPrix_initial()}
	${a.getPrix_vente()}
	${a.getNo_utilisateur()}
	${a.getNo_categorie()}
	</p>
	
	</c:if>
		
	<form method="post" action="/ProjetENI_1_Encheres/ServletTestArticles">
		
		<label for="nom_article"> Nom :</label> 
		<input type="text" id="nom_article" name="nom_article" placeholder="Article"> 
		
		<label for="description"> description :</label> 
		<input type="text" id="description" name="description" placeholder="description">
		
		<label for="date_debut_encheres"> Date début encheres :</label> 
		<input type="date" id="date_debut_encheres" name="date_debut_encheres">
		
		<label for="date_fin_encheres"> date_fin_encheres :</label> 
		<input type="date" id="date_fin_encheres" name="date_fin_encheres"> 	
		
		<label for="prix_initial"> prix_initial :</label> 
		<input type="number"id="prix_initial" name="prix_initial"> 
		
		<label for="prix_vente"> prix_vente :</label> 
		<input type="number"id="prix_vente" name="prix_vente"> 
		
		<label for="no_utilisateur"> no_utilisateur :</label> 
		<input type="number"id="no_utilisateur" name="no_utilisateur"> 
		
		<label for="no_categorie"> no_categorie :</label> 
		<input type="number"id="no_categorie" name="no_categorie"> 
			
			<input type="submit"> 
		</form>

</body>
</html>