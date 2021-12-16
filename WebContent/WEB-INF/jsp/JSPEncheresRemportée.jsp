<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS  -->

<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css" />
<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

<title>Bravo ! Vous avez remporté une enchères</title>
</head>
<body>
	<div id="main">

<%@ include file="/WEB-INF/jsp/pageAccueil/headerCO.html" %>
	<h1 id="titre">Vous avez remporté la vente</h1>

<div id=containe>

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
</div>
<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</div>
</body>
</html>