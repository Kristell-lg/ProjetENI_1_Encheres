<%@page import="fr.eni.projetEncheres.bo.Articles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Creation Article</title>
		<link rel="stylesheet" href="css/reset.css"> <!-- Reset le design css -->
        <!-- <link rel="stylesheet" href="css/.css"> <!-- Applique le nouveau design -->
	
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
		<h1>Gestion Article</h1>
		<h2>Ajout Article</h2>
	
		<c:if test="${!empty sessionScope.pseudoSession}"> <p>Création article : ${sessionScope.pseudoSession}</p> </c:if>
		<form method="post" action="/ProjetENI_1_Encheres/ServletCreationArticles">
			<div>
				<label for="nom_article"> Nom :</label> 
				<input type="text" id="nom_article" name="nom_article" placeholder="Article"> 
			</div>
			<div>
				<label for="description"> Description:</label> 
				<input type="text" id="description" name="description" placeholder="description">
			</div>
			<div>
				<label for="date_debut_encheres"> Date de début des enchères :</label> 
				<input type="date" id="date_debut_encheres" name="date_debut_encheres">
			</div>
			<div>
				<label for="date_fin_encheres"> Date de fin des enchères :</label> 
				<input type="date" id="date_fin_encheres" name="date_fin_encheres"> 	
			</div>
			<div>
				<label for="prix_initial"> Prix:</label> 
				<input type="number"id="prix_initial" name="prix_initial"> 
			</div>
			<div>
				<label for="categorie">Catégorie:</label>
	
				<select name="categorie" id="categorie">
				    <option value="">--Choisir une catégorie--</option>
				    <option value=1>Informatique</option>
				    <option value=2>Ameublement</option>
				    <option value=3>Vêtement</option>
				    <option value=4>Sport et Loisirs</option>
				</select>
			</div>
			<fieldset>
				<p>Retrait</p>
				<div>
					<label for="rue">Rue : </label>
					<input type="text" name="rue" id="rue"maxlength="30" value="${requestScope.rue}" required/>
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" name="ville" id="ville"maxlength="30" value="${requestScope.ville}" required/>
				</div>
				<div>	
					<label for="codepostal">Code Postal : </label>
					<input type="text" name="codepostal" id="codepostal" maxlength="5" value="${requestScope.cp}" required/>
				</div>
			</fieldset>
			<input type="submit"> 
			<input type="reset">
		</form>
		<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
	</body>
</html>