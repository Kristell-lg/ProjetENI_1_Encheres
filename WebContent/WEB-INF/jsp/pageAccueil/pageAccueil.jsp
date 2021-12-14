<!--JSP ACCUEIL -->
<!-- @Author Maxence -->
<!-- @Update Clement -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="java.time.format.DateTimeFormatter" %>
    
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
			
					<c:if test="${!empty requestScope.erreur}">
						<p style="color:red">${requestScope.erreur}</p>
					</c:if>
				
				<div>
					<form action="${pageContext.request.contextPath}/Accueil" method="post">
						<label for="categorie">Catégorie:</label>
			
						<select name="categorie" id="categorie">
						    <option value=0>--Choisir une catégorie--</option>
						    <option value=1>Informatique</option>
						    <option value=2>Ameublement</option>
						    <option value=3>Vêtement</option>
						    <option value=4>Sport et Loisirs</option>
						</select>
						
						<label for="recherche">Recherche par titre d'annonce :</label>
						<input type="text" name="recherche">
						
						<input type="submit" value="Valider">
					</form>
				</div>
				
				<h2>${requestScope.titre}</h2>
				
				<c:forEach var="article" items="${articlesListe}">
					<a class="affichageArticle" href="${pageContext.request.contextPath}/Connexion">${article.getNom_article()}</a>
					<p class="affichageArticle">Fin des enchères :${article.getDate_fin_encheres().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}</p>
					<p class="affichageArticle">Prix de vente :${article.getPrix_initial()}</p>
					<p class="affichageArticle">Vendeur :</p><a href="${pageContext.request.contextPath}/Connexion">${article.getUtilisateur().getPseudo()}</a>
					<p class="affichageArticle">-----------------------------------------------</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:if test="${!empty requestScope.erreur}">
							<p style="color:red">${requestScope.erreur}</p>
						</c:if>
					
					<div>
						<form action="${pageContext.request.contextPath}/Accueil" method="post">
							<label for="categorie">Catégorie:</label>
				
							<select name="categorie" id="categorie">
							    <option value=0>--Choisir une catégorie--</option>
							    <option value=1>Informatique</option>
							    <option value=2>Ameublement</option>
							    <option value=3>Vêtement</option>
							    <option value=4>Sport et Loisirs</option>
							</select>
							
							<label for="recherche">Recherche par titre d'annonce :</label>
							<input type="text" name="recherche">
						
							<input type="submit" value="Valider">
						</form>
					</div>
				<p class="affichageArticle">
					Aucun article n'est disponible
				</p>
			</c:otherwise>
		</c:choose>	


<%@ include file="footer.html" %>
</body>
</html>