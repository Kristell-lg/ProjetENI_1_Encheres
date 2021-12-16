<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->

<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="stylesheet" href="css/AfficherProfil.css" />
<!-- FONT ECONOMICA -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<!-- ICONE DE PAGE -->
<link rel="Shortcut Icon" href="css/images/iconeOsna.png">

<title>Catalogue Vente</title>
</head>
<body>
	<div id="main">

<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<p class="affichageVente">Hello ${sessionScope.utilisateur.getPseudo()}</p>
			<p class="affichageVente">Tu as ${sessionScope.utilisateur.getCredit()} points</p>
			<a class="affichageVente" href="/ProjetENI_1_Encheres/ServletCreationArticles">Mettre en vente un article</a>
			<a class="affichageVente" href="/ProjetENI_1_Encheres/Deconnexion">deconnexion</a>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	
	<h1 id ="titre">Catalogue des ventes</h1>
		<c:choose>
			<c:when test="${!empty articlesListe}">
			<!-- insérer la liste des artciles avec un prix de vente et l'id de l'utilisateur connecté  -->
				<c:forEach var="article" items="${articlesListe}">
				
				<form action="${pageContext.request.contextPath}/Profil" method="post">
					<input type="hidden" name="idProfil" value="${article.getNo_article()}">
					<button type="submit">${article.getNom_article()}</button>
				</form>			
					<a class="affichageArticle" href="${pageContext.request.contextPath}/Connexion">${article.getNom_article()}</a>
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres()}</p>
					<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p><a href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getUtilisateur().getPseudo()}</a>
					<p class="affichageArticle">-----------------------------------------------</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p class="affichageVente">
					Aucun article n'a été vendu
				</p>
			</c:otherwise>
		</c:choose>	
<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</div>
</body>
</html>