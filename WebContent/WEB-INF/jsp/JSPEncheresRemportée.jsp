<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bravo ! Vous avez remporté une enchères</title>
</head>
<body>
	<h1>Vous avez remporté la vente</h1>


	<p class="affichageArticle" href="/ProjetENI_1_Encheres/">${article.getNom_article()}</p>
		<p class="affichageArticle">Description :${article.getDescription()}</p>
		<p class="affichageArticle">Meilleure offre :${article.getPrix_vente()}</p>
		<p class="affichageArticle">Mise à prix:${article.getPrix_initial()}</p>
		
			<p class="affichageArticle">Retrait
			<a>${utilisateur.getRue()}</a><br>
			<a>${utilisateur.getCode_postal()}</a> <a>${utilisateur.getVille()}</a>
			</p>
		
		
	<p class="affichageArticle">Vendeur :${utilisateur.getPseudo()}</p> <!-- comment aller chercher l'utilisateur vendeur ? -->
	<p class="affichageArticle">Tel :${utilisateur.getTelephone()}</p> <!-- comment aller chercher le numéro de l'utilisateur vendeur ? -->
	<p class="affichageArticle">-----------------------------------------------</p>

	<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletAfficherProfil">retour</a>


</body>
</html>