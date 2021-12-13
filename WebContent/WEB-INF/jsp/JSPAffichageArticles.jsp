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
			<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletDeconnexion">Déconnexion</a>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	
	<h1>Catalogue des articles</h1>
		<c:choose>
			<c:when test="${!empty articlesListe}">
				<c:forEach var="article" items="${articlesListe}">
					<a class="affichageArticle" href="/${pageContext.request.contextPath}/Connexion">${article.getNom_article()}</a>
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres()}</p>
					<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p><a href="${pageContext.request.contextPath}/Connexion">${article.getUtilisateur().getPseudo()}</a>
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