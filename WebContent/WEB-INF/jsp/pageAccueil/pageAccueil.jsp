<!--JSP ACCUEIL -->
<!-- @Author Maxence -->
<!-- @Update Clement -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/headerFooter.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin >
<link href="https://fonts.googleapis.com/css2?family=Economica&display=swap" rel="stylesheet">
<title>Accueil</title>
</head>
<body>
<%@ include file="header.html" %>

<h3 style="text-align:center">Liste des enchères</h3>
	
<c:choose>
			<c:when test="${!empty articlesListe}">
				<c:forEach var="article" items="${articlesListe}">
					<a class="affichageArticle" href="${pageContext.request.contextPath}/Connexion">${article.getNom_article()}</a>
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


<%@ include file="footer.html" %>
</body>
</html>