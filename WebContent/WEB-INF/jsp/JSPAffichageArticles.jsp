<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue Articles</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/pageAccueil/header.html" %>
	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<p class="affichageArticle">Hello ${sessionScope.utilisateur.getPseudo()}</p>
			<p class="affichageArticle">Tu as ${sessionScope.utilisateur.getCredit()} points</p>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletCreationArticles">Mettre en vente un article</a>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Profil">Mon Profil</a>
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/Deconnexion">Déconnexion</a>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	
	<h1>Catalogue des articles</h1>
		<c:choose>
			<c:when test="${!empty articlesListe}">
				<c:forEach var="article" items="${articlesListe}">
					<form action="${pageContext.request.contextPath}/AfficherArticle" method="post">
						<input type="hidden" name="idArticle" value="${article.getNo_article()}">
						<button type="submit">${article.getNom_article()}</button>
					</form>	
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres()}</p>
					<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p>
					<p>${article.getUtilisateur().getNo_utilisateur()}</p>
					<form action="${pageContext.request.contextPath}/Profil" method="post">
						<input type="hidden" name="idProfil" value="${article.getUtilisateur().getPseudo()}">
						<button type="submit">${article.getUtilisateur().getPseudo()}</button>
					</form>	
					<p class="affichageArticle">-----------------------------------------------</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p class="affichageArticle">
					Aucun article n'est disponible
				</p>
			</c:otherwise>
		</c:choose>	
<%@ include file="/WEB-INF/jsp/pageAccueil/footer.html" %>
</body>
</html>