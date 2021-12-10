<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue Vente</title>
</head>
<body>

	<c:choose>
		<c:when test="${empty requestScope.erreur}">
			<p class="affichageVente">Hello ${sessionScope.utilisateur.getPseudo()}</p>
			<p class="affichageVente">Tu as ${sessionScope.utilisateur.getCredit()} points</p>
			<a class="affichageVente" href="/ProjetENI_1_Encheres/ServletCreationArticles">Mettre en vente un article</a>
			<a class="affichageVente" href="/ProjetENI_1_Encheres/ServletDeconnexion">deconnexion</a>
		</c:when>
		
		<c:otherwise>
			<p id="msgErreurConnexionUtilisateur">${requestScope.erreur}</p>
		</c:otherwise>
		
	</c:choose>	
	
	<h1>Catalogue des ventes</h1>
		<c:choose>
			<c:when test="${!empty articlesListe}">
			<!-- insérer la liste des artciles avec un prix de vente et l'id de l'utilisateur connecté  -->
				<c:forEach var="article" items="${articlesListe}">
					<a class="affichageArticle" href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getNom_article()}</a>
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres()}</p>
					<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p><a href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getUtilisateur().getPseudo()}</a>
					<p class="affichageArticle">-----------------------------------------------</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p class="affichageVente">
					Aucun article n'est disponible
				</p>
			</c:otherwise>
		</c:choose>	

</body>
</html>