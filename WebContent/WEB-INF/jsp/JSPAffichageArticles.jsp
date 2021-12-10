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

	<h1>Catalogue des articles</h1>
		<c:choose>
			<c:when test="${!empty articlesListe}">
				<c:forEach var="article" items="${articlesListe}">
					<a href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getNom_article()}</a>
					<p>${article.getDescription()}</p>
					<p>Début des enchères :${article.getDate_debut_encheres()}</p>
					<p>Fin des enchères :${article.getDate_fin_encheres()}</p>
					<p>Prix de vente :${article.getPrix_initial()}</p>
					<p>Catégorie :${article.getCategorie().getLibelle()}</p>
					<p>Vendeur :</p><a href="/ProjetENI_1_Encheres/ServletConnexionUtilisateurs">${article.getUtilisateur().getPseudo()}</a>
					<p>-----------------------------------------------</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>
					Aucun article n'est disponible
				</p>
			</c:otherwise>
		</c:choose>	

</body>
</html>