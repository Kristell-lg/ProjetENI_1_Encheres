<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CSS  -->


<link rel="stylesheet" href="css/Article.css" />

<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

<title>Catalogue Articles</title>
</head>
<body>
	<div id="main">

<%@ include file="/WEB-INF/jsp/pageAccueil/headerCO.html" %>
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
		<div id="containerProfil">
		<div id="Profil">
			<p class="affichageArticle">Bonjour ${sessionScope.utilisateur.getPseudo()} !</p>
			<p class="affichageArticle">Crédit : ${sessionScope.utilisateur.getCredit()} points</p>
			</div>
			<div id="LienHeader">
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletCreationArticles">Mettre en vente un article</a>
			<p></p>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Profil">Mon Profil</a>
			<p></p>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Deconnexion">Déconnexion</a>
			</div>
			</div>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	<h1 id="titre">Catalogue des articles</h1> <!-- à modifier selon selection voulu par l'utilisateur -->
	
		<c:choose>
		
			<c:when test="${!empty articlesListe}">
				
				<form action="${pageContext.request.contextPath}/AccueilFiltre" method="post">
				<div id="FlexRecherche">
						<div id="CategorieEnsemble">
						<label for="categorie">Catégorie:</label>
			
						<select name="categorie" id="categorie">
						    <option value=0>--Choisir une catégorie--</option>
						    <option value=1>Informatique</option>
						    <option value=2>Ameublement</option>
						    <option value=3>Vêtement</option>
						    <option value=4>Sport et Loisirs</option>
						</select>
						<br>
						<label for="recherche">Recherche par titre d'annonce :</label>
						<input type="text" name="recherche">
							
						<input type="submit" value="Valider">
						</div>
					</form>
					
					<div id="FiltreEnsemble">
					<form action="${pageContext.request.contextPath}/AccueilFiltre" method="post">
						
						<label for="filtre">Filtrer</label>
						<select name="filtre" id="filtre">
							<option value=0>--Choisir un filtre--</option>
						    <option value=0>--Choisir dans mes achats--</option>
						    <option value=1>Enchères ouvertes</option>
						    <option value=2>Mes enchères en cours</option>
						    <option value=3>Mes enchères remportées</option>
						    <option value=0>--Choisir dans mes ventes--</option>
						    <option value=4>Mes vente en cours</option>
						    <option value=5>Ventes non débutées</option>
						    <option value=6>Mes ventes terminées</option>
						</select>
							
						<input type="submit" value="Valider">
						</div>
					</form>
			</div>
				<c:if test="${!empty titre}">
					<p id="titre">${titre}</p>
				</c:if>
				
				
				<div id="position">
				<c:forEach var="article" items="${articlesListe}">
					<div id="container">
					<form action="${pageContext.request.contextPath}/AfficherArticle" method="get">
						<div id="ButtonDeux">
						<input type="hidden" name="idArticle" value="${article.getNo_article()}">
						<button id="ButtonDeux" type="submit">${article.getNom_article()}</button>
				</div>
					
						
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}</p>
					<p class="affichageArticle">Prix initial :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Dernier Prix :${article.getPrix_vente()}</p>
					<p class="affichageArticle">Vendeur :</p>
					
					<form action="${pageContext.request.contextPath}/Profil" method="post">
						
						<input type="hidden" name="idProfil" value="${article.getUtilisateur().getNo_utilisateur()}">
						<button type="submit">${article.getUtilisateur().getPseudo()}</button>
					
				</div>
				
				</c:forEach>
			
				</div>
					
			</c:when>
			
			<c:otherwise>
				<p class="affichageArticle">
					Aucun article n'est disponible
				</p>
			</c:otherwise>
			
		</c:choose>	


<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
	</div>

</body>
</html>